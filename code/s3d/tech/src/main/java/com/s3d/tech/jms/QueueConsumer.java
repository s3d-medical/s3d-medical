package com.s3d.tech.jms;


import java.io.Serializable;
import java.util.Map;

import javax.jms.TextMessage;

public interface QueueConsumer {

	void handleMessage(TextMessage message);

	void handleMessage(String message);

	void handleMessage(Map<String, Object> message);

	void handleMessage(byte[] message);

	void handleMessage(Serializable message);
}
