package com.s3d.tech.jms.activemq.producer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.jms.*;

import com.s3d.tech.jms.QueueProducer;
import com.s3d.tech.utils.GsonParser;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.Assert;

/**
 * send message in json format.
 * That means the content of message is string.
 *
 * @author wind.chen
 */
public class ActivemqQueueProducerImpl implements QueueProducer {

    private JmsTemplate jmsTemplate;

    private ExecutorService taskExecutor;

    private Destination destination;

    private boolean asyncSend;

    /**
     * @param jmsTemplate       jms template
     * @param destination       目标队列
     * @param isAsyncSend       是否异步发送
     * @param runnableQueueSize 异步发送时, 线程阻塞队列中最大可以放入的runnable数量
     * @param theadPoolMaxSize  异步发送时，发送线程的最大值。 默认是           1-theadPoolMaxSize
     */
    public ActivemqQueueProducerImpl(JmsTemplate jmsTemplate, Destination destination, boolean isAsyncSend, Integer runnableQueueSize,
                                     Integer theadPoolMaxSize) {
        this.jmsTemplate = jmsTemplate;
        // init queue
        this.destination = destination;
        this.asyncSend = isAsyncSend;

        if (asyncSend) {
            this.taskExecutor = new ThreadPoolExecutor(20, theadPoolMaxSize, 120,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(runnableQueueSize),
                    new ThreadPoolExecutor.CallerRunsPolicy());
        }
    }

    @Override
    public void sendSingleObj(Object obj) {
        if (obj == null) {
            return;
        }
        String message = GsonParser.parseObjToJson(obj);
        this.sendSingleStr(message);
    }

    @Override
    public void sendSingleStr(final String message) {
        if (asyncSend) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    sendOne(message, destination);
                }
            });
        } else {
            sendOne(message, destination);
        }
    }

    @Override
    public void sendBatchObj(List<Object> messages) {
        if (CollectionUtils.isNotEmpty(messages)) {
            List<String> strMessageList = new ArrayList<String>();
            for (Object obj : messages) {
                String message = GsonParser.parseObjToJson(obj);
                strMessageList.add(message);
            }
            this.sendBatchStr(strMessageList);
        }
    }

    @Override
    public void sendBatchStr(final List<String> messages) {
        Assert.notNull(messages, "query 'messages' can't be null !");
        Assert.notEmpty(messages, "query 'message' can't be empty !");
        if (asyncSend) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    sendMany(messages, destination);
                }
            });
        } else {
            sendMany(messages, destination);
        }
    }

    private void sendOne(final String message, Destination destination) {
        this.jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    private void sendMany(final List<String> messages, Destination destination) {
        if(messages == null){
            return ;
        }
        Connection connection = null;
        Session session = null;
        try {
            connection = this.jmsTemplate.getConnectionFactory().createConnection();
            session = connection.createSession(true, Session.SESSION_TRANSACTED);
            MessageProducer producer = session.createProducer(destination);
            for(int i=0; i<messages.size(); i++){
                TextMessage textMessage = new ActiveMQTextMessage();
                textMessage.setText(messages.get(i));
                producer.send(textMessage);
            }
            session.commit();
            session.close();
           // connection.close();
        } catch (JMSException e) {
            try {
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }
}
