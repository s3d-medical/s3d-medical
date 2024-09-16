package com.s3d.tech.jms.activemq.consumer;


import java.io.Serializable;
import java.util.Map;

import javax.jms.TextMessage;

import com.s3d.tech.jms.QueueConsumer;
import com.s3d.tech.jms.bizhandler.MessageBizHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivemqQueueConsumerImpl implements QueueConsumer {

	@Override
	public void handleMessage(TextMessage message) {
		if (message != null) {
			String text = "";
			try{
				text = message.getText();
				this.messageBizHandler.execute(text);
				this.logger.debug("Complete handle message =" + text);
				
			} catch (Exception e) {
				this.logger.error("Handle message failed. Json message in queue is:  "+ text, e.getCause());
			}
		}else{
			this.logger.error("Handle message failed, as for message is null.");
		}
	}

	@Override
	public void handleMessage(String message) {
			try{
				this.messageBizHandler.execute(message);
			} catch (Exception e) {
				this.logger.error("Handle message failed", e.getCause());
			}
	}

	@Override
	public void handleMessage(Map<String, Object> message) {
		try{
			this.messageBizHandler.execute(message);
		} catch (Exception e) {
			this.logger.error("Handle message failed", e.getCause());
		}
	}

	@Override
	public void handleMessage(byte[] message) {
		try{
			this.messageBizHandler.execute(message);
		} catch (Exception e) {
			this.logger.error("Handle message failed", e.getCause());
		}
	}

	@Override
	public void handleMessage(Serializable message) {
		try{
			this.messageBizHandler.execute(message);
		} catch (Exception e) {
			this.logger.error("Handle message failed", e.getCause());
		}
	}

	public void setMessageBizHandler(MessageBizHandler messageBizHandler) {
		this.messageBizHandler = messageBizHandler;
	}

	private MessageBizHandler messageBizHandler;

	private Logger logger = LoggerFactory.getLogger(getClass());

}