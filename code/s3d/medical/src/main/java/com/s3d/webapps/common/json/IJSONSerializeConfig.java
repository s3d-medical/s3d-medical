package com.s3d.webapps.common.json;

import java.util.Map;

public interface IJSONSerializeConfig {
	String[] getPropertyFilterNames();
	Map<String, Object> getAdditionalProperties(Object item);
	String getDateFormat();
}
