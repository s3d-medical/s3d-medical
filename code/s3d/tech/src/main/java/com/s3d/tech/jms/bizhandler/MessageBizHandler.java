package com.s3d.tech.jms.bizhandler;

import java.io.Serializable;
import java.util.Map;

/**
 * Handle the messages from consumer.
 * Do your real business logic process.
 * 
 * @since 2015-09-25
 * @author chenzhigang
 */
public interface MessageBizHandler {

	/**
	 * handle message of queue in string format or json.
	 * @param message
	 */
	void execute(String message);

	/**
	 * handle message of queue in map format.
	 * @param message
	 */
	void execute(Map<String, Object> message);

	/**
	 * handle message of queue in byte[] format.
	 * @param message
	 */
	void execute(byte[] message);

	/**
	 * handle serializable message. 
	 * @param message
	 */
	void execute(Serializable message);
	
}
