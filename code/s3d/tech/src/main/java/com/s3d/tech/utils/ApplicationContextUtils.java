package com.s3d.tech.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * holder application content for none web environment visiting
 * @author wind.chen
 *
 */
public class ApplicationContextUtils implements ApplicationContextAware {
	private static Log log = LogFactory.getLog(ApplicationContextUtils.class);
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		synchronized (ApplicationContextUtils.class) {
			ApplicationContextUtils.applicationContext = applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

    public static <T> T getBean(Class<T> clazz) {
        return ApplicationContextUtils.getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String beanName) {
        return (T)ApplicationContextUtils.getApplicationContext().getBean(beanName);
    }

}
