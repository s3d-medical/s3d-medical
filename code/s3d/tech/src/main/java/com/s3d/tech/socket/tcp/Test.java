package com.s3d.tech.socket.tcp;

import com.s3d.tech.utils.DateUtils;

import java.util.Date;

/**
 * Created by Administrator on 2015/7/15.
 */
public class Test {
    public static void main(String[] args){
        Client client = new Client();
        client.connect("127.0.0.1",55555, 50000);
        for(int i = 0; i< 100; i++){
            client.writeData(DateUtils.convertToStrDateTime(new Date()));
        }
    }
}
