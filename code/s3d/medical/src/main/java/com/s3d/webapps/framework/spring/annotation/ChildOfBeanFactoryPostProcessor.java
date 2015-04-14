package com.s3d.webapps.framework.spring.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

/**
 * BeanFactoryPostProcessor for Inheritance of Bean Properties via Annotations
 * {@link at.gv.brz.spring.beans.ChildOf @ChildOf}
 * 
 * @author HAUSER
 * @since 2009-05-12
 */
public class ChildOfBeanFactoryPostProcessor implements
		BeanFactoryPostProcessor, PriorityOrdered {
	protected final Log logger = LogFactory.getLog(getClass());
	private int order = Ordered.LOWEST_PRECEDENCE; // default: same as
													// non-Ordered

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}

	/**
	 * Modify the application context's internal bean factory after its standard
	 * initialization. All bean definitions will have been loaded, but no beans
	 * will have been instantiated yet. This allows for overriding or adding
	 * properties even to eager-initializing beans.
	 * 
	 * @param beanFactory
	 *            the bean factory used by the application context
	 * @throws org.springframework.beans.BeansException
	 *             in case of errors
	 */
	@SuppressWarnings("unchecked")
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (int i = 0; i < beanNames.length; i++) {
			String beanName = beanNames[i];
			BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
			String className = bd.getBeanClassName();
			// some classnames are nulls, why ?
			if (!StringUtils.hasText(className)) {
				continue;
			}
			try {
				Class clazz = Class.forName(className);
				ChildOf childOf = AnnotationUtils.findAnnotation(clazz,
						ChildOf.class);
				if (childOf != null) {
					String parentName = childOf.parent();
					if (!StringUtils.hasText(parentName)) {
						throw new FatalBeanException(
								"ChildOf Annotation of bean [" + beanName
										+ "] has no parent Value");
					}
					if (logger.isDebugEnabled()) {
						logger.debug("Found parentName [" + parentName
								+ "] for bean [" + beanName + "]");
					}
					// is there already a different parent ?
					String oldParentName = bd.getParentName();
					if (StringUtils.hasText(oldParentName)
							&& !parentName.equals(oldParentName)) {
						logger.warn("bean [" + beanName
								+ "] has already parent [" + oldParentName
								+ "] set - new annotated parent[" + parentName
								+ "] will be ignored");
					}
					// and set the parentName
					bd.setParentName(parentName);
				}
			} catch (ClassNotFoundException e) {
				logger.error("Bean [" + beanName + "] has invalid ClassName["
						+ bd.getBeanClassName()
						+ "] - Exception will be ignored");
			}
		}
	}
}