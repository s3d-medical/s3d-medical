package com.s3d.webapps.da.config;

import java.util.HashMap;
import java.util.Map;

public class ConfigSetConstants {
	public static final String[] ConfigSetType_FL = new String[]{"FL","病案分类","病案编码"};
	public static final String[] ConfigSetType_KS = new String[]{"KS","科室名称","科室编码"};
	public static final String[] ConfigSetType_GJ = new String[]{"GJ","国家名称","国家编码"};
	public static final String[] ConfigSetType_MZ = new String[]{"MZ","民族名称","民族编码"};
	public static final String[] ConfigSetType_ZJ = new String[]{"ZJ","证件名称","证件编码"};
	public static final String[] ConfigSetType_GX =new String[]{"GX","关系名称","关系编码"};
	public static final String[] ConfigSetType_HY = new String[]{"HY","婚姻状况描述","婚姻状况编码"};
	public static final String[] ConfigSetType_ZY = new String[]{"ZY","职业描述","职业编码"};
	public static final String[] ConfigSetType_SS = new String[]{"SS","省市县地址","省市县编码"};
	public static final String[] ConfigSetType_JB = new String[]{"JB","疾病名称","ICD编码"};
	public static final String[] ConfigSetType_RYTJ = new String[]{"RYTJ","入院途径","编码"};
	public static final String[] ConfigSetType_LYFS = new String[]{"LYFS","离院方式","编码"};
	public static final String[] ConfigSetType_RYJC = new String[]{"RYJC","入院病况等级","编码"};
	public static final String[] ConfigSetType_RYBQ = new String[]{"RYBQ","入院病情","编码"};
	public static final String[] ConfigSetType_CYQK = new String[]{"CYQK","出院情况","编码"};	

	public static final String[] ConfigSetType_SEX = new String[]{"SEX","性别","编码"};
	public static final String[] ConfigSetType_DOCTOR = new String[]{"DOCTOR","医生"};

	public static final Map<String, String[]> TypeMap = new HashMap<String, String[]>();
	static{
		TypeMap.put(ConfigSetType_FL[0], ConfigSetType_FL);
		TypeMap.put(ConfigSetType_KS[0], ConfigSetType_KS);
		TypeMap.put(ConfigSetType_GJ[0], ConfigSetType_GJ);
		TypeMap.put(ConfigSetType_MZ[0], ConfigSetType_MZ);
		TypeMap.put(ConfigSetType_ZJ[0], ConfigSetType_ZJ);
		TypeMap.put(ConfigSetType_GX[0], ConfigSetType_GX);
		TypeMap.put(ConfigSetType_HY[0], ConfigSetType_HY);
		TypeMap.put(ConfigSetType_ZY[0], ConfigSetType_ZY);
		TypeMap.put(ConfigSetType_SS[0], ConfigSetType_SS);
		TypeMap.put(ConfigSetType_JB[0], ConfigSetType_JB);
		TypeMap.put(ConfigSetType_RYTJ[0], ConfigSetType_RYTJ);
		TypeMap.put(ConfigSetType_LYFS[0], ConfigSetType_LYFS);
		TypeMap.put(ConfigSetType_RYJC[0], ConfigSetType_RYJC);
		TypeMap.put(ConfigSetType_RYBQ[0], ConfigSetType_RYBQ);
		TypeMap.put(ConfigSetType_CYQK[0], ConfigSetType_CYQK);
		TypeMap.put(ConfigSetType_SEX[0], ConfigSetType_SEX);
		TypeMap.put(ConfigSetType_DOCTOR[0], ConfigSetType_DOCTOR);
	}
	
}
