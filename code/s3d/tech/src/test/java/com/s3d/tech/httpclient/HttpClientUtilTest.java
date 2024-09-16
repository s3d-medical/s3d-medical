package com.s3d.tech.httpclient;

import com.s3d.tech.restapi.result.ResponseDto;
import com.s3d.tech.utils.DateUtils;
import com.s3d.tech.utils.JacksonParser;
import com.s3d.tech.utils.httpclient.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.Runner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author wind.chen
 * @since 2016/9/27.
 */
public class HttpClientUtilTest {
    private static ExecutorService taskExecutor = Executors.newFixedThreadPool(100);

    @Test
    public void postJsonStr() throws InterruptedException {
        Runnable  runner = new Runnable() {
            @Override
            public void run() {
                Map<String, String> param = new HashMap<String, String>();
                param.put("startTime", "2016-09-01 00:00:00");
                param.put("endTime", "2016-09-20 00:00:00");
                String result = HttpClientUtil.postJsonObj("http://1testapi.nahuasuan.com/activity/searchActivityNewUser", param);
                System.out.println(result);
                //ResponseDto responseDto = JacksonParser.convertObj(result, ResponseDto.class);
            }
        };
        for(int i=0; i< 1000 ; i++){
            taskExecutor.execute(runner);
        }
        Thread.sleep(100000L);
    }

}
