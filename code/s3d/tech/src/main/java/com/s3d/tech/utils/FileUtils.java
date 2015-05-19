package com.s3d.tech.utils;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * help to manager file and dir.
 * @author wind.chen
 *
 */
public class FileUtils {
    private static final List<String> unfriendlyCharacters =
            Arrays.asList("|", "'", "/", "\"", "#", "&", "\\+", "\\^", "%", "@", "~", "\\?", "\\$", "\\^", "=",
                    "\\(", "\\)", "!", "\\$", "\\*", ",", ":", ";", "\\[", "\\]", "\\{", "\\}");

    public static String friendifyFileName(String fileName) {
        if (fileName == null || "".equals(fileName.trim())) {
            throw new RuntimeException("File name cannot be blank.");
        }

        for (String unfriendlyCharacter : unfriendlyCharacters) {
            fileName = fileName.replaceAll(unfriendlyCharacter, "");
            fileName = fileName.replaceAll("  ", " ");
        }
        return fileName.trim();
    }

    /**
     * Friendify file path.  make it end with / and make it pattern like this c:/ss/sdd/
     * @param filePath
     * @return
     */
    public static String friendifyFilePath(String filePath){
        if(filePath !=null){
            filePath = filePath.replaceAll("\\*", "/");
            filePath = filePath.replaceAll("///*", "/");
            if(!filePath.endsWith("/")){
                filePath = filePath + "/";
            }
        }
        return filePath;
    }

    public static boolean createFilePath(String filePath){
        int mkResult = mkDir(filePath);
        if(mkResult < 0) {
            return false;
        }
        return true;
    }

    private static int mkDir(String filePath){
    	File dir = new File(filePath);
    	if(dir.exists()){
    		if(dir.isFile()){
    			return -1;
    		}
    	} else {
    		if(!dir.mkdirs()) {    			
    			return -2;
    		}
    	}
    	return 1;
    }

    /**
     * check a file is exist.
     * @return
     */
    public static boolean isFileExists(String filePath){
        if(StringUtils.isBlank(filePath)){
            return false;
        }
        File file = new File(filePath);
        return file.exists();
    }
}
