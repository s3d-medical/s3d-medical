package com.s3d.auth;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2015/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-auth-context.xml")
public class MemcachedTest {

    @Autowired
    private MemcachedClient memcachedClient;

    public void testNoCas(String key, Integer value) {
        memcachedClient.set(key, 1000000, value);
    }

    @Test
    public void testMemcachedclient() throws InterruptedException {
        final String key = "nurser";
        // set init value.
        this.setNoCas(key, 0);


        for (int i = 1; i < 1000; i++) {
            Runnable runnable = new BookRun(i, key);
            new Thread(runnable).start();
        }

        Thread.currentThread().sleep(20000);
        System.out.println("ddd");
    }

    private class BookRun implements Runnable {
        private Integer userId;
        private String key;
        private int runTimes = 0;

        private BookRun(Integer userId, String key) {
            this.userId = userId;
            this.key = key;
        }

        @Override
        public void run() {
            for (; ; ) {
                boolean re = book(key, userId);
                runTimes = runTimes+ 1;
                if (re) {
                    break;
                }
            }
        }
    }

    private boolean book(String key, Integer userId) {
        // read data
        CASValue casValue = readByCas(key);
        Integer oldValue = (Integer) casValue.getValue();
        if (oldValue > 100) {
            return true;
        }
        // decrease 1
        boolean result = setWithCas(key, oldValue + 1, casValue.getCas());
        if (result) {
            System.out.println(userId + "    ,   I'm Ok.  My version   " + " times " );
            return true;
        }
        return false;
    }

    private CASValue readByCas(String key) {
        return memcachedClient.gets(key);
    }

    private boolean setWithCas(String key, Integer value, Long casNo) {
        CASResponse casResponse = memcachedClient.cas(key, casNo, value);
        if (casResponse.equals(CASResponse.OK)) {
            return true;
        }
        return false;
    }

    private void setNoCas(String key, Integer value) {
        memcachedClient.set(key, 1000000, value);
    }

}
