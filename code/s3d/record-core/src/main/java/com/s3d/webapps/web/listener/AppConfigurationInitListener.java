package com.s3d.webapps.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.configuration.ConfigurationException;

import com.s3d.webapps.framework.AppConfiguration;

/**
 * Web application configuration files including mail template, parameters.
 */
public class AppConfigurationInitListener implements ServletContextListener,
		HttpSessionListener {

	private static final String	ETC_FILE	= "etc_file";

	public AppConfigurationInitListener() {

	}

	public void contextDestroyed(ServletContextEvent event) {

		AppConfiguration.getInstance().clear();
	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String configFile = context.getInitParameter(ETC_FILE);

		try {
			AppConfiguration.init(context.getRealPath(configFile));
		} catch (ConfigurationException e) {
			event.getServletContext().log("ConfigurationException: ", e);
		}
	}

	public void sessionCreated(HttpSessionEvent event) {
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		
	}

}
