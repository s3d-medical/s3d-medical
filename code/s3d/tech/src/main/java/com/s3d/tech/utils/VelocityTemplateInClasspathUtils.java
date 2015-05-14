package com.s3d.tech.utils;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.*;

/**
 * This class is a tool used to load template in classpath and generate string by merging data into the template.
 * @author  Wind.Chen
 * @date 2015/1/29.
 */
public class VelocityTemplateInClasspathUtils {
    private static VelocityEngine velocityEngine;
    private static String VELOCITY_PROPERTIES_FILE_NAME = "velocity-dwcore";
    private static ResourceBundle rb;

    static {
        initialize();
    }

    /**
     * Initialize velocity engine.
     */
    private static void initialize() {
        try {
            velocityEngine = new VelocityEngine();
            Properties properties = getProperties();
            velocityEngine.init(properties);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    private static Properties getProperties(){
        Properties properties = getPropertiesByConfigFile();
        if(properties == null){
            properties = initPropertiesDefault();
        }
        return properties;
    }

    private  static Properties getPropertiesByConfigFile(){
        Properties properties = null;
        ResourceBundle rb = ResourceBundle.getBundle(VELOCITY_PROPERTIES_FILE_NAME);
        Set<String> keys =  rb.keySet();
        if(keys != null && keys.size() >0){
            properties = new Properties();
            for(Iterator<String> iterator = keys.iterator() ; iterator.hasNext(); ){
                String key = iterator.next();
                properties.put(key, rb.getString(key));
            }
        }
        return properties;
    }

    private static Properties initPropertiesDefault(){
        Properties properties = new Properties();
        // properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, ""); // absolute path.
        properties.setProperty(Velocity.RUNTIME_LOG, "/opt/nfs/metricsreports/velocity.log");
        properties.setProperty(Velocity.RESOURCE_LOADER, "class"); // class represents reading from class path. file means read from file.
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //properties.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true"); // whether enable cache.
        //properties.setProperty("file.resource.loader.modificationCheckInterval", "3600"); // set cached time.
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        return properties;
    }

    /**
     * Generate string by specified template in classpath.
     * @param relativePackagePath      Package path in class path which be like this pattern. sql/files/ or /sql/files/ . character '/' is needed at the end the path.
     * @param templateFileName         Velocity template file name.
     * @param dataModel                 variables to be used in template.
     * @return                            Generated sql.
     */
    public static String generateStringByTemplate(String relativePackagePath, String templateFileName, Map dataModel) {
        StringWriter writer = new StringWriter();
        try {
            VelocityContext variableContext = new VelocityContext(dataModel);
            Template template = velocityEngine.getTemplate(relativePackagePath + templateFileName);  //
            template.merge(variableContext, writer);
            String sql =  writer.toString();
            return sql;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }

    /**
     * Generate file by specified velocity template in classpath.
     * @param relativePackagePath        Package path in class path which be like this pattern. sql/files/ or /sql/files/ . character '/' is needed at the end the path.
     * @param templateFileName           Velocity template file name.
     * @param dataModel                   Variables to be used in template.
     * @param targetFilePathName         A file holds the generated content from the template.
     * @return                              The value is equal to  targetFilePathName
     */
    public static String generateFileByTemplate(String relativePackagePath, String templateFileName, Map dataModel, String targetFilePathName) {

        BufferedWriter bufferedWriter = null;
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(targetFilePathName);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            VelocityContext variableContext = new VelocityContext(dataModel);
            Template template = velocityEngine.getTemplate(relativePackagePath + templateFileName);  //
            template.merge(variableContext, bufferedWriter);
            return bufferedWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(outputStreamWriter);
            IOUtils.closeQuietly(fileOutputStream);
        }
    }
}
