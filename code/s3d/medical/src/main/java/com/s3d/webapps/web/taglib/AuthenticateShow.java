package com.s3d.webapps.web.taglib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

import com.s3d.webapps.util.ArrayUtils;
import com.s3d.webapps.util.UserUtil;

public class AuthenticateShow extends BodyTagSupport {
	private static String SPLIT_STR = "\\s*[;,]\\s*";

	private String roles;

	private String baseOrgIds;

	private List baseOrgElements;

	private String extendOrgIds;

	private List extendOrgElements;

	private boolean baseEmptyShow = false;

	public int doStartTag() {
		List idList = getIdListByString(getBaseOrgIds());
		if (ArrayUtils.isEmpty(idList)
				&& ArrayUtils.isEmpty(getBaseOrgElements()) && isBaseEmptyShow())
			return EVAL_BODY_INCLUDE;

		if (!StringUtils.isEmpty(getRoles()))
			if (UserUtil.checkRoles(Arrays.asList(getRoles().trim().split(
					SPLIT_STR))))
				return EVAL_BODY_INCLUDE;

		if (UserUtil.checkUserIds(idList))
			return EVAL_BODY_INCLUDE;

		if (UserUtil.checkUserIds(getIdListByString(getExtendOrgIds())))
			return EVAL_BODY_INCLUDE;

		if (!ArrayUtils.isEmpty(getBaseOrgElements()))
			if (UserUtil.checkUserModels(getBaseOrgElements()))
				return EVAL_BODY_INCLUDE;

		if (!ArrayUtils.isEmpty(getExtendOrgElements()))
			if (UserUtil.checkUserModels(getExtendOrgElements()))
				return EVAL_BODY_INCLUDE;

		return SKIP_BODY;
	}

	public boolean isBaseEmptyShow() {
		return baseEmptyShow;
	}

	public void setBaseEmptyShow(boolean baseEmptyShow) {
		this.baseEmptyShow = baseEmptyShow;
	}

	public List getBaseOrgElements() {
		return baseOrgElements;
	}

	public void setBaseOrgElements(List baseOrgElements) {
		this.baseOrgElements = baseOrgElements;
	}

	public String getBaseOrgIds() {
		return baseOrgIds;
	}

	public void setBaseOrgIds(String baseOrgIds) {
		this.baseOrgIds = baseOrgIds;
	}

	public List getExtendOrgElements() {
		return extendOrgElements;
	}

	public void setExtendOrgElements(List extendOrgElements) {
		this.extendOrgElements = extendOrgElements;
	}

	public String getExtendOrgIds() {
		return extendOrgIds;
	}

	public void setExtendOrgIds(String extendOrgIds) {
		this.extendOrgIds = extendOrgIds;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	private List getIdListByString(String orgIds) {
		List idList = new ArrayList();
		if (!StringUtils.isEmpty(orgIds)) {
			String[] ids = orgIds.trim().split(SPLIT_STR);
			for (int i = 0; i < ids.length; i++) {
				if (!StringUtils.isEmpty(ids[i]))
					idList.add(ids[i]);
			}
		}
		return idList;
	}
}
