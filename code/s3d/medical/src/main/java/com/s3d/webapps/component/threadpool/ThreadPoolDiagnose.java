package com.s3d.webapps.component.threadpool;

import com.s3d.webapps.component.threadpool.ThreadPool.ThreadDiagnose;

public interface ThreadPoolDiagnose {

	public boolean running();

	public int maxsize();

	public int size();

	public ThreadDiagnose[] getDiagnose();

}
