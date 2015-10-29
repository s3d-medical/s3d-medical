package com.s3d.webapps.component.queue;

/**
 * 队列诊断信息接口
 * (此行为仅暴露给用于的用户)
 */
public interface DiagnoseQueue<E> {

	public int size();

	public int capacity();

	public boolean isFull();

	public boolean isPriorityQueue();

	public E[] toArray(E[] objs);

}
