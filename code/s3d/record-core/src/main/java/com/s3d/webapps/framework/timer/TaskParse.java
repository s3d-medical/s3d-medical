package com.s3d.webapps.framework.timer;

import java.util.Collection;

public interface TaskParse {
	
	Collection<TaskUnit> getTaskUnits();
	
	TaskUnit getTaskUnit(String name);

}
