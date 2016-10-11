package com.s3d.tech.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public final class StringUtil
{
  private static String SEPARATOR = ",";

  public static String listToString(List<?> list)
  {
    return listToString(list, SEPARATOR);
  }

  public static String listToString(List<?> list, String separator)
  {
    if ((list == null) || (list.isEmpty()) || (separator == null))
    {
      return "";
    }
    StringBuilder result = new StringBuilder();
    for (Iterator i$ = list.iterator(); i$.hasNext(); ) { Object obj = i$.next();

      result.append(obj);
      result.append(separator);
    }
    return result.toString();
  }

  public static List<Integer> stringToIntegerList(String content)
  {
    return stringToIntegerList(content, SEPARATOR);
  }

  public static List<Integer> stringToIntegerList(String content, String separator)
  {
    if ((content == null) || ("".equals(content)) || (separator == null))
    {
      return new ArrayList();
    }
    String[] strings = content.split(separator);
    List result = new ArrayList();
    for (String string : strings)
    {
      Integer item = new Integer(string.trim());
      if (item == null)
        continue;
      result.add(item);
    }

    return result;
  }

  public static List<String> stringToStringList(String content)
  {
    return stringToStringList(content, SEPARATOR);
  }

  public static List<String> stringToStringList(String content, String separator)
  {
    if ((content == null) || ("".equals(content)) || (separator == null))
    {
      return new ArrayList();
    }
    String[] strings = content.split(separator);
    List result = new ArrayList();
    for (String string : strings)
    {
      if ("".equals(string))
        continue;
      result.add(string);
    }

    return result;
  }
  
  public static boolean isNumeric(String str){
	  Pattern pattern=Pattern.compile("[0-9]*");
	  return pattern.matcher(str).matches();
  }
  public static Set<String> stringToSet(String src){
      Set<String> set = new HashSet<String>();
      if(src != null){
          String[] values = src.split(",");
          if(values != null){
              for(String value : values){
                  set.add(value);
              }
          }
      }
      return set;
  }
  
  /**
   * change list to string ,
   * if there is null or "" elements in list, this element will not be included in the built string.
   * @param list
   * @param separator
   * @return
   */
  public static String listToStrNoEmpty(List<?> list, String separator)
  {
    if ((list == null) || (list.isEmpty()) || (separator == null))
    {
      return "";
    }
    StringBuilder result = new StringBuilder();
    for (Iterator i$ = list.iterator(); i$.hasNext(); ) { Object obj = i$.next();
      if(obj==null ||"".equals(obj.toString())){
    	  continue;
      }      
      result.append(obj);
      result.append(separator);
    }
    return result.toString();
  }
  /**
   * This method is used to format element in a list to a string  in which elements are connected by "," 
   * , what's more, there is no comma in the end.
   * @return
   */
  public static String listToStrLinkedByComma(List<?> source){
	  String connectedStr=StringUtil.listToStrNoEmpty(source,",");
	  if(connectedStr ==null || "".equals(connectedStr)){
		  return connectedStr;
	  }
	  // remove the end "," from the string.
	  if(connectedStr.length()-1==connectedStr.lastIndexOf(",")){
		  connectedStr=connectedStr.substring(0, connectedStr.length()-1);
	  }
	  return connectedStr;
  }

   public static String trimHtmlTag(String source){
        return   source.replaceAll("\\<.*?\\>", "");
   }

    public static String trimBlanks(String source){
        Pattern p = Pattern.compile("\\*|\t|\r|\n");
        Matcher m = p.matcher(source);
        return  m.replaceAll("");
    }

     public static String htmlEncode(String source) {
        if (source == null) {
            return "";
        }
        String html = "";
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);

            switch (c) {
            case '<':
                buffer.append("&lt;");

                break;

            case '>':
                buffer.append("&gt;");

                break;
            default:
                buffer.append(c);
            }
        }

        html = buffer.toString();

        return html;
    }

    public static boolean equals(String src, String des){
        if(src != null){
            return src.equals(des);
        }
        if(des != null){
            return des.equals(src);
        }
        return false;
    }
}

