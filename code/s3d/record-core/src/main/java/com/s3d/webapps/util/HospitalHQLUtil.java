package com.s3d.webapps.util;

import java.util.ArrayList;
import java.util.List;

import com.s3d.webapps.constant.HospitalOrgConstant;
import com.s3d.webapps.da.customer.persistence.DaCustomerHospital;

public class HospitalHQLUtil implements HospitalOrgConstant {

	public static String buildWhereBlock(int rtnType, String whereBlock,
			String orgProperty) {
		String m_where = null;
		String filter = null;

		int orgFlag = rtnType;
		
		if ((orgFlag & HSP_TYPE_HOSPITAL) == HSP_TYPE_HOSPITAL)
			filter = orgProperty + ".fdOrgType=" + HSP_TYPE_HOSPITAL;
		if ((orgFlag & HSP_TYPE_PROJECT) == HSP_TYPE_PROJECT)
			filter = StringUtil.linkString(filter, " or ", orgProperty
					+ ".fdOrgType=" + HSP_TYPE_PROJECT);
		if ((orgFlag & HSP_TYPE_LABEL) == HSP_TYPE_LABEL)
			filter = StringUtil.linkString(filter, " or ", orgProperty
					+ ".fdOrgType=" + HSP_TYPE_LABEL);
		
		m_where = StringUtil.isNull(filter) ? null : "(" + filter + ")";
		
		return StringUtil.linkString(StringUtil.isNull(whereBlock) ? null : "("
				+ whereBlock + ")", " and ", m_where);
	}


	public static String buildAllChildrenWhereBlock(DaCustomerHospital hospital,
			String whereBlock, String orgProperty) {
		return StringUtil.linkString(StringUtil.isNull(whereBlock) ? null : "("
				+ whereBlock + ")", " and ", "substring(" + orgProperty
				+ ".fdHierarchyId,1," + hospital.getFdHierarchyId().length()
				+ ")='" + hospital.getFdHierarchyId() + "'");
	}

	public static String buildAllChildrenWhereBlock(List<DaCustomerHospital> orgElements,
			String whereBlock, String orgProperty) {
		if (orgElements.isEmpty())
			return whereBlock;
		List<String> hierarchyIds = new ArrayList<String>();
		StringBuffer personIds = new StringBuffer();
		for (int i = 0; i < orgElements.size(); i++) {
			DaCustomerHospital element =  orgElements.get(i);
			/*int orgType = element.getFdOrgType().intValue();
			if (orgType == ORG_TYPE_GROUP || orgType == ORG_TYPE_POST)
				throw new WebappsRuntimeException(
						new WebappsMessage(
								"sys-organization:SysOrgHQLUtil.error.cannotincludegroupandpost"));
			else if (orgType == ORG_TYPE_PERSON)
				personIds.append(",'" + element.getFdId() + "'");
			else */
				
			hierarchyIds.add(element.getFdHierarchyId());
		}
		hierarchyIds = formatHierarchyIdList(hierarchyIds);
		StringBuffer whereBf = new StringBuffer();
		if (personIds.length() > 0)
			whereBf.append(" or ").append(orgProperty).append(".fdId in (")
					.append(personIds.substring(1)).append(")");
		for (int i = 0; i < hierarchyIds.size(); i++) {
			String hId = hierarchyIds.get(i).toString();
			whereBf.append(" or substring(" + orgProperty + ".fdHierarchyId,1,"
					+ hId.length() + ")='" + hId + "'");
		}
		return StringUtil.linkString(StringUtil.isNull(whereBlock) ? null : "("
				+ whereBlock + ")", " and ", whereBf.length() > 0 ? "("
				+ whereBf.substring(4) + ")" : null);
	}

	public static List<String> formatHierarchyIdList(List<String> srcList) {
		List<String> rtnList = new ArrayList<String>();
		outloop: for (int i = 0; i < srcList.size(); i++) {
			String insertHid = (String) srcList.get(i);
			for (int j = 0; j < rtnList.size(); j++) {
				String hid = (String) rtnList.get(j);
				if (hid.startsWith(insertHid)) {
					rtnList.set(j, insertHid);
					continue outloop;
				} else if (insertHid.startsWith(hid)) {
					continue outloop;
				} else if (insertHid.compareTo(hid) > 0)
					break;
			}
			rtnList.add(insertHid);
		}
		return rtnList;
	}
}