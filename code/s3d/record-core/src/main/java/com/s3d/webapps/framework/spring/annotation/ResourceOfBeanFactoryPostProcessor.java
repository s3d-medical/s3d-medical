package com.s3d.webapps.framework.spring.annotation;

import java.lang.reflect.Method;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.entity.BaseEntityObject;
import com.s3d.webapps.common.exception.WebAppsBeansException;
import com.s3d.webapps.framework.spring.ResourceHolder;

public class ResourceOfBeanFactoryPostProcessor implements
		BeanFactoryPostProcessor, PriorityOrdered {
	protected final Log logger = LogFactory.getLog(getClass());
	private int order = Ordered.LOWEST_PRECEDENCE; 

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}

	@SuppressWarnings("unchecked")
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {

		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (int i = 0; i < beanNames.length; i++) {
			String beanName = beanNames[i];
			BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
			String className = bd.getBeanClassName();
			if (!StringUtils.hasText(className)) {
				continue;
			}
			try {
				Class clazz = Class.forName(className);
				RequestMapping classMapping =AnnotationUtils.getAnnotation(clazz,RequestMapping.class);
				if (classMapping != null) {//必须要是requestMapping
					RequestMappingAuthority resourceOf = AnnotationUtils.getAnnotation(clazz,RequestMappingAuthority.class);
					if (resourceOf != null) {
						String[] antPath = resourceOf.antPath();
						if (ArrayUtils.isEmpty(antPath)) {
							antPath = classMapping.value();
						}
						ResourceHolder.regsiterResource(antPath,resourceOf.roles());
					}
					
					for (Method method : clazz.getMethods())
					{
					    if (method.isAnnotationPresent(RequestMapping.class) && method.isAnnotationPresent(RequestMappingAuthority.class))
					    {
					    	RequestMappingAuthority authority = AnnotationUtils.getAnnotation(method,RequestMappingAuthority.class);
					    	String[] antPath = authority.antPath();
							if (ArrayUtils.isEmpty(antPath)) {
								if(BaseController.class.isAssignableFrom(clazz)){
									if (!ArrayUtils.isEmpty(classMapping.value())) {
										RequestMapping mapping = AnnotationUtils.getAnnotation(method,RequestMapping.class);
										if (!ArrayUtils.isEmpty(mapping.value())) {
											String path = classMapping.value()[0];
											ResourceHolder.regsiterResource(path+mapping.value()[0],authority.roles());
											continue;
										}										
									}
						    	}
								throw new IllegalStateException("'RequestMappingAuthority' annotations Illegal use on ("+method.toString()+"), antPath must not be empty!");
							}
							ResourceHolder.regsiterResource(antPath,authority.roles());
					    }
					}
				}
			} catch (ClassNotFoundException e) {
				
			}catch(IllegalStateException e){
				throw new WebAppsBeansException(e.getMessage());
			}
		}
	}
}