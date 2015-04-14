package com.s3d.webapps.component.queue;

/**
 * 入队方式
 */
public interface PutMethod {

	public boolean allowPut(BaseQueue<Object> queue, Object o);

}
