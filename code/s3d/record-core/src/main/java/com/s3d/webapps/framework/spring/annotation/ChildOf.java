package com.s3d.webapps.framework.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

/**
 * Annotation for Bean definition Inheritance - must be processed by a
 * BeanFactoryPostProcessor prior to Instantiation of the Beans<br>
 * Indicates that this bean is ChildOf the named parent Bean and inherits all
 * (set) properties of the parent Class
 * 
 * @author HAUSER
 * @since 2009-05-12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ChildOf {
	/**
	 * The value may indicate a suggestion for a logical component name, to be
	 * turned into a Spring bean in case of an autodetected component.
	 * 
	 * @return the suggested component name, if any
	 */
	String value() default "";

	/**
	 * The name of the parent bean - must NOT be null
	 * 
	 * @return the parent beanname
	 */
	String parent() default "";
}