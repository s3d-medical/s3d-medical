package com.s3d.tech.utils;

/**
 * This class is responsible for converting gmt to specified time, or inverse.
 * @wind Wind.Chen
 * @date 2015/1/29.
 */
public class SQLDateTimeHelper {
    public static final String TIMEZONE_GMT = "GMT";
    public static final String TIMEZONE_UTC = "UTC";
    public static final String DEFAULT_DATE_HOUR_FORMAT = "%Y-%m-%d %H:00:00";
    public static final String DEFAULT_DATETIME_FORMAT="yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd";
    public static final String OBLIQUE_LINE_DATE_FORMAT = "MM/dd/yyyy";
    public static final String DEFAULT_MONTH_YEAR_FORMAT= "MMMM, yyyy";

    public static final long SECONDS_ONE_DAY = 24 * 60 * 60 ;
    public static final long SECONDS_ONE_MONTH =(24 * 60 * 60 ) * 31;
    public static final long SECONDS_HALF_YEAR =(24 * 60 * 60 ) * 31 * 6;
    public static final String COMPACT_DATETIME_FORMAT="yyyyMMddHHmmss";
    public static final String MONTH_DAY_DATE_FORMAT ="MMMMMMMMM-dd";

    /**
     * Real timezone code which can be recognized by mysql.
     */
    private String realZoneCode;

    /**
     * indicate the timezone can be recognized by mysql easily.
     * 1 means yes, 0 means no. If no, the realZoneCode is number to stand for the offset seconds from UTC0 or GMT0
     */
    private Integer isStandard;

    public SQLDateTimeHelper(String realTimeZoneCode, Integer isStandard) {
        this.realZoneCode = realTimeZoneCode;
        this.isStandard = isStandard;
    }

    /**
     * assemble mysql convert_tz function.
     * @param gmtDateTimeValue
     * @return
     */
    public String getDateTimeGMTToSpecified(String gmtDateTimeValue){
        StringBuilder sql = new StringBuilder();
        if(isStandard == null || realZoneCode == null){
            return gmtDateTimeValue;
        }
        else if(isStandard ==1){
            sql.append("  CONVERT_TZ(").append(gmtDateTimeValue).append(", ");
            sql.append("'").append(TIMEZONE_GMT).append("', ");
            sql.append("'").append(realZoneCode).append("') ");
        }else{
            sql.append("  DATE_ADD(").append(gmtDateTimeValue).append(", ");
            sql.append(" INTERVAL ").append(realZoneCode).append(" HOUR_MINUTE ) ");
        }
        return sql.toString();
    }

    //---------------------------------- get date hour with converting specified datetime to gmt.
    public String getDateTimeOfSpecifiedToGMT(String specifiedDateTimeValue){
        StringBuilder sql = new StringBuilder();
        if(isStandard == null || realZoneCode == null){
            return specifiedDateTimeValue;
        }
        else if(isStandard ==1){
            sql.append("  CONVERT_TZ(").append(specifiedDateTimeValue).append(", ");
            sql.append("'").append(realZoneCode).append("', ");
            sql.append("'").append(TIMEZONE_GMT).append("') ");
        }else{
            int timeDiffer = -1 * Integer.parseInt(realZoneCode);
            sql.append("  DATE_ADD(").append(specifiedDateTimeValue).append(", ");
            sql.append(" INTERVAL ").append(timeDiffer).append(" HOUR_MINUTE ) ");
        }

        String convertedValue = sql.toString();
        //  For current realization , specifiedDateTimeValue is the GMT Time. So need cover the above implementation logic.
        //  In the future, the passed parameter should be customized datetime based on timezone.
        convertedValue = specifiedDateTimeValue ;
        return convertedValue;
    }

}
