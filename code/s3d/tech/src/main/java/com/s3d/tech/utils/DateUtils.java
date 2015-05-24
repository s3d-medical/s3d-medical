package com.s3d.tech.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Format Date or Date in string to given timezone Date. Methods are named with prefix formatXXX.
 * Convert date to String or convert String to Date. Methods are named with prefix convertXXX.
 */
public class DateUtils {
    private static final Log log = LogFactory.getLog(DateUtils.class);
    public static final String TIMEZONE_GMT = "GMT";
    public static final String TIMEZONE_UTC = "UTC";

	public static final String DEFAULT_DATETIME_FORMAT="yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_HOUR_MINUTE ="yyyy-MM-dd HH:mm";

    public static final String DEFAULT_HOUR_MINUTE ="HH:mm";

    public static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd";
    public static final String DEFAULT_MONTH_YEAR_FORMAT= "MMMM, yyyy";


    public static final String COMPACT_DATETIME_FORMAT="yyyyMMddHHmmss";
    public static final String MONTH_DAY_DATE_FORMAT ="MMMMMMMMM-dd";


    /**
     * Convert date or date time to specified format pattern.
     * @param srcDateTime
     * @param targetFormatPattern
     * @param timeZone
     * @param locale
     * @return
     */
    private static String convertToStrDateTimeSpecifiedPattern(Date srcDateTime, String targetFormatPattern, String timeZone, Locale locale){
        if(srcDateTime == null ){
            return null;
        }

        SimpleDateFormat sdf = createAFormatter(targetFormatPattern,timeZone,locale);
        return sdf.format(srcDateTime);
    }
    private static Date convertToDateTimeSpecifiedPattern(String dateString, String targetFormatPattern, String timeZone, Locale locale) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        try {
            SimpleDateFormat formatter = createAFormatter(targetFormatPattern,timeZone,locale);
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse given string representing date.", e.getCause());
        }
    }

    private static SimpleDateFormat createAFormatter(String targetFormatPattern, String timeZone, Locale locale){
        String givenFormat = targetFormatPattern;
        if(StringUtils.isBlank(givenFormat) ){
            givenFormat = DEFAULT_DATETIME_FORMAT;
        }
        Locale givenLocale = locale;
        if(givenLocale == null){
            givenLocale = Locale.getDefault();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(givenFormat, givenLocale);
        if(StringUtils.isNotBlank(timeZone)){
            sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        }
        return sdf;
    }


    /**
     * Convert given a date or date time in string format to a simple format with only month and day. such as July-20
     * @param srcDateTime
     * @return
     */
    public static String convertToStrMonthDayInEnglish(String srcDateTime){
        Date dateTime = convertToDateTimeSpecifiedPattern(srcDateTime, DEFAULT_DATE_FORMAT, null, null);
        return convertToStrDateTimeSpecifiedPattern(dateTime, MONTH_DAY_DATE_FORMAT, null, Locale.ENGLISH);
    }

    /**
     * Get year , month by default locale and format.
     * @param srcDateTime
     * @return
     */
    public static String convertToStrYearMonthInEnglish(String srcDateTime){
        Date dateTime = convertToDateTimeSpecifiedPattern(srcDateTime, DEFAULT_DATE_FORMAT, null, null);
        return convertToStrDateTimeSpecifiedPattern(dateTime, DEFAULT_MONTH_YEAR_FORMAT, null, Locale.ENGLISH);
    }

    /**
     * convert date to string with time section in default pattern just like 2014-09-01 11:11:11
     * @param dateTime
     * @return  return a string holding a time part. like yyyy-MM-dd hh:mm:ss
     */
	public static String convertToStrDateTime(Date dateTime) {
        return convertToStrDateTimeSpecifiedPattern(dateTime, DEFAULT_DATETIME_FORMAT, null, null);
	}

    /**
     *  convert date to string without time section in default pattern 2014-09-01
     *  If you give  date time like this '2014-09-01 13:33:53' , the date result will be '2014-09-01'
     * @param dateTime
     * @return
     */
    public static String convertToStrDate(Date dateTime) {
        return convertToStrDateTimeSpecifiedPattern(dateTime, DEFAULT_DATE_FORMAT, null, null);
    }

    public static String convertToStrDate(Date dateTime, String dateFormatPattern) {
        return convertToStrDateTimeSpecifiedPattern(dateTime, dateFormatPattern, null, null);
    }

	/**
	 * return format yyyymmdd hhmmss 20140405 101122
	 * @param dateTime
	 * @return
	 */
	public static String convertToStrDateTimeCompressed(Date dateTime) {
		return  convertToStrDateTimeSpecifiedPattern(dateTime, COMPACT_DATETIME_FORMAT, null, null);
	}


    /**
     * Parse string to date, if there are non-zero time, it will be eliminated to 00:00:00
     * For example a given date string is '2014-01-01 23:33:45', the date value will be '2014-01-01 00:00:00'
     * @param srcDate
     * @return
     */
    public static Date convertToDate(String srcDate){
        if(StringUtils.isEmpty(srcDate)){
            return null;
        }
        return convertToDateTimeSpecifiedPattern(srcDate, DEFAULT_DATE_FORMAT, null, null);
    }

    public static Date convertToDate(Integer year, Integer month, Integer day){
        if(year != null && month != null && day != null ){
            StringBuilder sb = new StringBuilder();
            sb.append(year).append("-").append(month).append("-").append(day).append(" 00:00:00");
            return DateUtils.convertToDate(sb.toString());
        }
        return null;
    }

    /**
     * Convert a date which maybe has non-zero time part, the time will be reset to 00:00:00
     * For example  given date is '2014-01-01 23:33:45', the date value will be '2014-01-01 00:00:00'
     * @param dateTime
     * @return
     */
	public static Date convertToDate(Date dateTime){
        // convert to string
		String strDate = convertToStrDateTimeSpecifiedPattern(dateTime, DEFAULT_DATE_FORMAT, null, null);
        return convertToDateTimeSpecifiedPattern(strDate, DEFAULT_DATE_FORMAT, null, null);
	}

    public static Date convertToDateHourMinute(Integer year, Integer month, Integer day, String time){
        if(year != null && month != null && day != null ){
            StringBuilder sb = new StringBuilder();
            sb.append(year).append("-").append(month).append("-").append(day);
            if(time != null && !"".equals(time)){
                  sb.append(" ").append(time).append(":00:00");
            }
            return DateUtils.convertToDateTime(sb.toString(), DEFAULT_DATE_HOUR_MINUTE);
        }
        return null;
    }

	public static Date convertToDateTime(String dateString){
		return convertToDateTimeSpecifiedPattern(dateString, DEFAULT_DATETIME_FORMAT, null, null);
	}

    public static Date convertToDateTime(String dateString, String dateFormat){
        return convertToDateTimeSpecifiedPattern(dateString, dateFormat, null, null);
    }

	/**
	 * get the sunday of the given date 
	 * @param givenDate
	 * @return
	 */
	public static Date getLastDayOfWeek(Date givenDate ) {  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(givenDate);     
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);    
           return cal.getTime();
    }

	public static Date getLastDateOfMonth(Date givenDate) {
	    Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return cal.getTime();
	}
	
	public static Date getFirstDateOfMonth(Date givenDate) {
	    Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        int value = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return cal.getTime();
	}
	
	public static Date getFirstDateOfNextMonth(Date givenDate) {
	     Date lastDate = getLastDateOfMonth(givenDate);
	     return addDayToDate(lastDate, 1);
	}

    public static Integer getYear(Date dateTime){
        if(dateTime == null){
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        return cal.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date dateTime){
        if(dateTime == null){
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        return (cal.get(Calendar.MONTH) + 1);
    }

    public static Integer getDayInMonth(Date dateTime){
        if(dateTime == null){
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static String getHourMinute(Date dateTime){
        if(dateTime == null){
            return null;
        }
        return DateUtils.convertToStrDateTimeSpecifiedPattern(dateTime, DEFAULT_HOUR_MINUTE, null, null);
    }

    /**
     * get hour from date.
     * @param dateTime
     * @return
     */
    public static Integer getHourInt(Date dateTime) {
        if(dateTime == null){
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static Date addDayToDate(Date givenDate, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(givenDate);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}
	
	public static Date addHourToDate(Date givenDate, int hours) {
        if(givenDate == null){
            return null;
        }
		Calendar cal = Calendar.getInstance();
		cal.setTime(givenDate);
		cal.add(Calendar.HOUR_OF_DAY, hours);
		return cal.getTime();
	}

    public static Date addSecondsDateTime(Date sourceDateTime, int seconds){
        if(sourceDateTime == null){
            return sourceDateTime;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(sourceDateTime);
        cal.add(Calendar.SECOND, seconds);
        Date newDateTime = cal.getTime();
        return newDateTime;
    }

    public static long diffSeconds(Date beginDate, Date endDate){
        Assert.isTrue(beginDate != null, "beginDate can not be null");
        Assert.isTrue(endDate != null, "endDate can not be null");
        long diff = endDate.getTime() - beginDate.getTime();
        return (diff/1000);
    }

    /**
     * Convert the date of the time zone to UTC
     *
     * @param dateString date in string
     * @param timeZoneCode time zone code
     * @return UTC date
     */
    public static Date convertToUTC(String dateString, String timeZoneCode) {
        SimpleDateFormat localFormatter = new SimpleDateFormat(DateUtils.DEFAULT_DATETIME_FORMAT);
        localFormatter.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        try {
            Date localDate = localFormatter.parse(dateString);
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            cal.setTime(localDate);
            return cal.getTime();
        } catch (ParseException e) {
            log.error("Failed to parse '" + dateString + "' to Date object of time zone '" + timeZoneCode + "'.");
        }
        return null;
    }

    /**
     * convert UIC to special timezone.
     * @param srcDateTime
     * @param newTimeZone
     * @return
     */
    public static String convertFromUTC(Date srcDateTime, String newTimeZone) {
        DateFormat targetDateFormatter = new SimpleDateFormat(DateUtils.DEFAULT_DATETIME_FORMAT);
        targetDateFormatter.setTimeZone(TimeZone.getTimeZone(newTimeZone));
        return targetDateFormatter.format(srcDateTime);
    }

}

