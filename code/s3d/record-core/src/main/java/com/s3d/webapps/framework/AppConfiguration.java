package com.s3d.webapps.framework;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;

import com.s3d.webapps.framework.mail.MailTemplate;
import com.s3d.webapps.framework.mail.MailTemplateKey;
import com.s3d.webapps.framework.timer.TaskFactory;

public class AppConfiguration {

	private static AppConfiguration appConf = null;
	private Configuration conf = null;
	private Map<String, MailTemplate> mailTemplateMap = null;

	private AppConfiguration() {
	}

	public static AppConfiguration getInstance() {
		if (appConf == null) {

			throw new NullPointerException(
					"AppConfiguration has not been inited.");
		}

		return appConf;
	}

	public static synchronized void init(String configFile)
			throws ConfigurationException {
		System.out.println("configFile " + configFile);

		if (appConf == null) {
			appConf = new AppConfiguration();
			ConfigurationFactory factory = new ConfigurationFactory(configFile);
			appConf.conf = factory.getConfiguration();

			int pIndex = configFile.lastIndexOf("/");
			if (pIndex == -1)
				pIndex = configFile.lastIndexOf("\\");
			String basePath = configFile.substring(0, pIndex);
			// this.fetchSearchSetting(basePath);
			
			appConf.fetchTimerTask(basePath);
			appConf.fetchMailTemplateSetting();
		}
	}

	private void fetchTimerTask(String basePath) {
		String path = this.conf.getString("app.timer.task.config");
		File file = new File(basePath + path);
		if(file.exists()) {
			TaskFactory factory = TaskFactory.getFactory();
			factory.initTasks(basePath + path);
			factory.startAllTasks();
		}
	}
	
	private void fetchMailTemplateSetting() {

		Object oNames = this.conf.getProperty("vm-template.name");
		Collection<String> names = null;
		if (!(oNames instanceof Collection)) {
			names = new ArrayList<String>();
			names.add((String) oNames);
		} else {
			names = (Collection<String>) oNames;
		}

		this.mailTemplateMap = new HashMap<String, MailTemplate>();

		int i = 0;
		for (String name : names) {
			String subject = this.conf.getString("vm-template(" + i
					+ ").subject");
			String body = this.conf.getString("vm-template(" + i + ").body");

			MailTemplate template = new MailTemplate(name, subject, body);
			this.mailTemplateMap.put(name, template);

			i++;
		}
	}
	
	public MailTemplate getMailTemplate(String name) {
		MailTemplate template = null;
		if (this.mailTemplateMap == null) {
			return null;
		}

		template = this.mailTemplateMap.get(name);

		if (template == null || template.getBody() == null) {
			template = this.mailTemplateMap
					.get(MailTemplateKey.defaultVm);
		}

		return template;
	}
	
	public void clear() {
		if (this.mailTemplateMap != null) {
			this.mailTemplateMap.clear();
			this.mailTemplateMap = null;
		}
		if (this.conf != null) {
			this.conf.clear();
			this.conf = null;
		}
	}

	public String getStaticServer() {
		return this.conf.getString("app.server.static");
	}

	public String getWebServer() {
		return this.conf.getString("app.server.www");
	}

	public String getStaticRootPath() {
		return this.conf.getString("app.server.static.root.path");
	}

	public String getStaticContentPath() {
		return getStaticRootPath() + getStaticContentUri();
	}
	public String getStaticContentUri() {
		return this.conf.getString("app.server.static.content.uri");
	}

	public String getBaseReaderPath() {
		return getStaticContentPath() + "/reader";
	}
	public String getBaseReaderUri() {
		return getStaticContentUri() + "/reader";
	}
	public String getBaseUploadPath() {
		return getStaticContentPath() + "/upload";
	}
	public String getBaseUploadUri() {
		return getStaticContentUri() + "/upload";
	}
	
	public String getBookRootPath() {
		return this.conf.getString("app.server.book.root.path");
	}

	public String getTempPath() {
		return this.conf.getString("app.temp.path");
	}

	public String getDomain() {
		return this.conf.getString("app.server.domain");
	}
	
	public String getSolrServer(){
		return this.conf.getString("app.solr.server");
	}

	public boolean containsKey(String arg0) {
		return this.conf.containsKey(arg0);
	}

	public BigDecimal getBigDecimal(String arg0) {
		return this.conf.getBigDecimal(arg0);
	}

	public BigDecimal getBigDecimal(String arg0, BigDecimal arg1) {
		return this.conf.getBigDecimal(arg0, arg1);
	}

	public BigInteger getBigInteger(String arg0) {
		return this.conf.getBigInteger(arg0);
	}

	public BigInteger getBigInteger(String arg0, BigInteger arg1) {
		return this.conf.getBigInteger(arg0, arg1);
	}

	public boolean getBoolean(String arg0) {
		return this.conf.getBoolean(arg0);
	}

	public boolean getBoolean(String arg0, boolean arg1) {
		return this.conf.getBoolean(arg0, arg1);
	}

	public Boolean getBoolean(String arg0, Boolean arg1) {
		return this.conf.getBoolean(arg0, arg1);
	}

	public byte getByte(String arg0) {
		return this.conf.getByte(arg0);
	}

	public byte getByte(String arg0, byte arg1) {
		return this.conf.getByte(arg0, arg1);
	}

	public Byte getByte(String arg0, Byte arg1) {
		return this.conf.getByte(arg0, arg1);
	}

	public double getDouble(String arg0) {
		return this.conf.getDouble(arg0);
	}

	public double getDouble(String arg0, double arg1) {
		return this.conf.getDouble(arg0, arg1);
	}

	public Double getDouble(String arg0, Double arg1) {
		return this.conf.getDouble(arg0, arg1);
	}

	public float getFloat(String arg0) {
		return this.conf.getFloat(arg0);
	}

	public float getFloat(String arg0, float arg1) {
		return this.conf.getFloat(arg0, arg1);
	}

	public Float getFloat(String arg0, Float arg1) {
		return this.conf.getFloat(arg0, arg1);
	}

	public int getInt(String arg0) {
		return this.conf.getInt(arg0);
	}

	public int getInt(String arg0, int arg1) {
		return this.conf.getInt(arg0, arg1);
	}

	public Integer getInteger(String arg0, Integer arg1) {
		return this.conf.getInteger(arg0, arg1);
	}

	public Iterator getKeys() {
		return this.conf.getKeys();
	}

	public Iterator getKeys(String arg0) {
		return this.conf.getKeys(arg0);
	}

	public List getList(String arg0) {
		return this.conf.getList(arg0);
	}

	public List getList(String arg0, List arg1) {
		return this.conf.getList(arg0, arg1);
	}

	public long getLong(String arg0) {
		return this.conf.getLong(arg0);
	}

	public long getLong(String arg0, long arg1) {
		return this.conf.getLong(arg0, arg1);
	}

	public Long getLong(String arg0, Long arg1) {
		return this.conf.getLong(arg0, arg1);
	}

	public Properties getProperties(String arg0) {
		return this.conf.getProperties(arg0);
	}

	public Object getProperty(String arg0) {
		return this.conf.getProperty(arg0);
	}

	public short getShort(String arg0) {
		return this.conf.getShort(arg0);
	}

	public short getShort(String arg0, short arg1) {
		return this.conf.getShort(arg0, arg1);
	}

	public Short getShort(String arg0, Short arg1) {
		return this.conf.getShort(arg0, arg1);
	}

	public String getString(String arg0) {
		return this.conf.getString(arg0);
	}

	public String getString(String arg0, String arg1) {
		return this.conf.getString(arg0, arg1);
	}

	public String[] getStringArray(String arg0) {
		return this.conf.getStringArray(arg0);
	}

	public boolean isEmpty() {
		return this.conf.isEmpty();
	}

	public Configuration subset(String arg0) {
		return this.conf.subset(arg0);
	}

}
