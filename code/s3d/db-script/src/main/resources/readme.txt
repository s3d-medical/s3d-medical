config jndi in tomcat context.xml to run liquidbase db.

<Resource name="jdbc/medicaldb"
	  auth="Container"
	  type="javax.sql.DataSource"
	  factory="org.logicalcobwebs.proxool.ProxoolDataSource"
	  proxool.alias="medicaldb"
	  user="root"
	  password="123456"
	  delegateProperties="foo=1,bar=true"
	  proxool.driver-url="jdbc:mysql://127.0.0.1:3306/medical?useUnicode=true&amp;characterEncoding=UTF-8"
	  proxool.driver-class="com.mysql.jdbc.Driver"
	  proxool.house-keeping-sleep-time="900000"
	  proxool.minimum-connection-count="10"
	  proxool.maximum-connection-count="100"
	  proxool.house-keeping-test-sql="select 1 from dual"
	  proxool.test-before-use="true"/>
