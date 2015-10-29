package com.s3d.webapps.web.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;

import com.s3d.webapps.framework.spring.annotation.RequestMappingAuthority;
import com.s3d.webapps.util.UserUtil;

public class MethodAuthorityInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {

		if(invocation.getMethod().isAnnotationPresent(RequestMappingAuthority.class)){
			RequestMappingAuthority resource = AnnotationUtils.getAnnotation(invocation.getMethod(),RequestMappingAuthority.class);
			if(resource!=null){
				if(resource.roles()!=null && resource.roles().length>0){
					for (String role : resource.roles()) {
						if(UserUtil.checkRole(role)) break;
					}
					return null;
				}
			}
		}
		return invocation.proceed();
	}

}
