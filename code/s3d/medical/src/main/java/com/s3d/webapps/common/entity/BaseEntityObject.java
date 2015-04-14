package com.s3d.webapps.common.entity;

import java.lang.reflect.Method;

import net.sf.cglib.transform.impl.InterceptFieldCallback;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.s3d.webapps.util.ModelUtil;

public abstract class BaseEntityObject implements EntityObject {
	private transient InterceptFieldCallback $CGLIB_READ_WRITE_CALLBACK;

	protected String fdId = null;

	public String getFdId() {
		return fdId;
	}

	public void setFdId(String id) {
		this.fdId = id;
	}
	
	private static final long serialVersionUID = 8489377152416733605L;
	
	public void recalculateFields() {

	}
	
	@Override
	public String toString() {
		try {
			Method[] methodList = this.getClass().getMethods();
			ToStringBuilder rtnVal = new ToStringBuilder(this,
					ToStringStyle.MULTI_LINE_STYLE);
			for (int i = 0; i < methodList.length; i++) {
				String methodName = methodList[i].getName();
				if (methodList[i].getParameterTypes().length > 0
						|| !methodName.startsWith("get")
						|| methodName.equals("getClass"))
					continue;
				methodName = methodList[i].getReturnType().toString();
				if ((methodName.startsWith("class") || methodName
						.startsWith("interface"))
						&& !(methodName.startsWith("class java.lang.") || methodName
								.startsWith("interface java.lang.")))
					continue;
				try {
					rtnVal.append(methodList[i].getName().substring(3),
							methodList[i].invoke(this, null));
				} catch (Exception e) {
				}
			}
			return rtnVal.toString().replaceAll("@[^\\[]+\\[\\r\\n", "[\r\n");
		} catch (Exception e) {
			return super.toString();
		}
	}

	public InterceptFieldCallback getInterceptFieldCallback() {
		return $CGLIB_READ_WRITE_CALLBACK;
	}

	public void setInterceptFieldCallback(
			InterceptFieldCallback interceptfieldcallback) {
		$CGLIB_READ_WRITE_CALLBACK = interceptfieldcallback;
	}
	
	/**
	 * 判断当前是否为新业务对象，没有被持久化
	 */
	public boolean isNew() {
		if (this.getFdId() == null) {
			return true;
		}
		return false;
	}
	
	/* 
	 * 重载equals，用来判断业务对象是否相同
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		
		boolean typeable = obj instanceof EntityObject;
		if (! typeable )
		{
			return false;
		}
		EntityObject bo = (EntityObject)obj;
		if (this.isNew() || bo.isNew())
		{
			return false;
		}
		
		if (this.getFdId().equals(bo.getFdId()))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 覆盖hashCode方法，通过模型中类名和ID构建哈希值
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		HashCodeBuilder rtnVal = new HashCodeBuilder(-426830461, 631494429);
		rtnVal.append(ModelUtil.getModelClassName(this));
		rtnVal.append(getFdId());
		return rtnVal.toHashCode();
	}
	
	protected Object readLazyField(String fieldName, Object oldValue) {
		if (getInterceptFieldCallback() == null) {
			return oldValue;
		}
		return getInterceptFieldCallback()
				.readObject(this, fieldName, oldValue);
	}

	protected Object writeLazyField(String fieldName, Object oldValue,
			Object newValue) {
		if (getInterceptFieldCallback() == null) {
			return newValue;
		}
		return getInterceptFieldCallback().writeObject(this, fieldName,
				oldValue, newValue);
	}
}
