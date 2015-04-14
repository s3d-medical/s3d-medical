package com.s3d.webapps.component.forms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlUtil {
	
	private static String removeUnnecessaryBlankUsingRegex(String src,String regex){
		String replacement = "";
	    boolean stillhasblank = true;
	    Pattern p = Pattern.compile(regex);
	    String ret = src;
	    String toreplace="";
        while(stillhasblank){
        	stillhasblank = false;
        	Matcher m = p.matcher(ret);
        	while(m.find()){
        		if(m.group(1)!=null && ! m.group(1).equals(replacement)){
        			toreplace = m.group(1);
        			stillhasblank = true;
        			break;
        		}     		
        	}
        	ret = ret.replaceFirst(toreplace, replacement);
        }
        //StringBuffer s = new StringBuffer();
        //while (m.find()) m.appendReplacement(s, m.group().replaceFirst(m.group(1), replace));
        //return s.toString();
        return ret;
	}
	public static String removeUnnecessaryBlank(String src){
		String regex[] = {
			"<[^>]*>(\\s*)<[^>]*>",
			"<[^>]*>(\\s*)<span[^>]*>"
		};
	    for(String reg:regex){
	    	src = removeUnnecessaryBlankUsingRegex(src,reg);
	    }
	    return src;
	}
	public static String removeUnnecessaryTags(String src){
		return src;
	}
	public static String removeUnecessaryChars(String src){
		return src.replaceAll("[\\r][\\n]","");
	}
}
