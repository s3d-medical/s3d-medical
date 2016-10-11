package com.s3d.tech.jms;


import java.util.List;

/**
 * Send message by mq. 
 * @author wind.chen
 *
 */
public interface QueueProducer {

	/**
	 * send string format message.
	 * 
	 * @param message
	 */
	public void sendSingleStr(String message);

	/**
	 * send strings in batch.
	 * 
	 * @param messages
	 */
	public void sendBatchStr(List<String> messages);

	/**
	 * send object which will be convert to json.
	 * 
	 * @param obj
	 */
	public void sendSingleObj(Object obj);

	/**
	 * send objects in batch which will be converted to jsons.
	 * 
	 * @param messages
	 */
	public void sendBatchObj(List<Object> messages);
	
}
