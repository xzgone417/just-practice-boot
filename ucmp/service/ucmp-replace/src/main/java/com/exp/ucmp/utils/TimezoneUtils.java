package com.exp.ucmp.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理时区工具类
 * @author qx
 */
public class TimezoneUtils {

    public final static String GMT_8 = "GMT+8";
    public final static String ASIA_SHANGHAI = "Asia/Shanghai";
    public final static String UTC = "UTC";

    /**
     * 时间戳秒长度
     */
    public static final int TIMSESTAMP_SECONDS_LENGTH = 10;

    /**
     * 时间戳毫秒长度
     */
    public static final int TIMSESTAMP_MILLISECOND_LENGTH = 13;

    /**
     * 0时区字符串,SQL可能用到
     */
    public static final String FROM_TZ = "+00:00";

//    /**
//     * 0时区和传入时区的偏移量，秒
//     * @param timezone 如 UTC+8,Asia/Shanghai等
//     * @return 返回偏移秒如东八区28800秒，西八区 -28800秒
//     */
//    public static int offsetFromUTC(String timezone) {
//        ZoneId zoneId = ZoneId.of(timezone);
//        ZoneOffset zoneOffset = zoneId.getRules().getOffset(Instant.now());
//        return zoneOffset.getTotalSeconds();
//    }

    /**
     * 根据传入时区获取当地日期格式, GMT代表的是时区， UTC 则是一个时间标准
     * @param timezone 时区 如 UTC+8,Asia/Shanghai等
     * @param timestamp UTC时间戳
     * @param dateFormat 日期格式,如：yyyy-MM-dd HH:mm:ss
     * @return 获取时间格式化字符串 2023-01-28 16:52:51
     */
    public static String formatTimestamp(String timezone, Long timestamp, String dateFormat) {
        if (null == timestamp) {
            return null;
        }
        int timestampLength = timestamp.toString().length();
        if (timestampLength != TimezoneUtils.TIMSESTAMP_SECONDS_LENGTH && timestampLength != TimezoneUtils.TIMSESTAMP_MILLISECOND_LENGTH) {
            throw new RuntimeException("Timestamp length error");
        }
        //如果长度是秒，则转毫秒
        if (timestampLength == TimezoneUtils.TIMSESTAMP_SECONDS_LENGTH) {
            timestamp = timestamp * 1000;
        }
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.of(timezone);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withZone(zoneId);
        return zonedDateTime.format(dateTimeFormatter);
    }

    /**
     * <p>
     * Description: 获取当前时间戳
     *         Instant 类的常用API ：
     * 　　     Instant 类的 getEpochSecond() : 获取的是秒
     * 　　     Instant 类的 toEpochMilli() : 获取的是毫秒，同 System.currentTimeMillis()
     * 　　     Instant 类的 getNano() : 获取的是纳秒，更精确了
     * </p>
     *
     * @return  * @return : java.lang.Long
     */
    public static Long getCurrentTimestamp() {
        return Instant.now().getEpochSecond();
    }

    /**
     * <p>
     * Description: 根据日期字符串获取对应时区的时间戳
     * </p>
     *
     * @param timezone : 时区
     * @param dateStr : 日期字符串:yyyy-MM-dd,yyyy-M-d,yyyy/M/d
     * @param dateFormat : 日期格式
     * @return  * @return : java.lang.Long
     */
    public static Long getTimestampSecondForDay(String timezone, String dateStr, String dateFormat) {
        ZoneId zoneId = ZoneId.of(timezone);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withZone(zoneId);
        return LocalDate.parse(dateStr, dateTimeFormatter).atTime(LocalTime.MIN).atZone(zoneId).toInstant().getEpochSecond();
    }
    /**
     * <p>
     * Description: 校验日期是否合法
     * </p>
     *
     * @param date : 日期字符串，格式yyyy-MM-dd|yyyy/M/D|yyyyMMdd
     * @return  * @return : boolean
     */
    public static boolean isValidDate(String date) {

        Pattern pattern = Pattern.compile("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])|[0-9]{4}/([1-9]|1[0-2])/([1-9]|[12][0-9]|3[01])|[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(date);
        if (!matcher.matches()) {
            return false;
        }
        String[] dayArray = null;
        if(date.contains("-")){//yyyy-MM-dd
            dayArray = date.split("-");
        }else if(date.contains("/")){//yyyy/M/D
            dayArray = date.split("/");
        }else{//yyyyMMdd
            return  isValidDay(Integer.parseInt(date.substring(0,4)), Integer.parseInt(date.substring(4,6)), Integer.parseInt(date.substring(6,8)));
        }
        return  isValidDay(Integer.parseInt(dayArray[0]), Integer.parseInt(dayArray[1]), Integer.parseInt(dayArray[2]));
    }

    /**
     * @Author ZhouWenJie
     * @Description
     * @Date 2023/9/8
     * @Param dateStr 时间字符串
     * @Param dateFormat 转换前时间格式
     * @Param converDateFormat 转换后时间格式
     * @return
     **/
    public static String convertTimeFormat(String dateStr,String dateFormat,String converDateFormat){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date = sdf.parse(dateStr);
            String returnDateStr = new SimpleDateFormat(converDateFormat).format(date);
            return returnDateStr;
        }catch (Exception e){
            return null;
        }

    }

    /**
     * 时间戳转换(到毫秒)
     * @param dateStr 时间字符串
     * @param dateFormat 时间格式
     * @param timeZone 时区
     * @return 时间戳
     */
    public static long convertTimeToTimestamp(String dateStr,String dateFormat, String timeZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(timeZone));
        long timestamp = zonedDateTime.toInstant().toEpochMilli();
        return timestamp;
    }

    /**
     * 时间戳转换(到秒)
     * @param dateStr 时间字符串
     * @param dateFormat 时间格式
     * @param timeZone 时区
     * @return 时间戳
     */
    public static long convertTimeToSecondTimestamp(String dateStr,String dateFormat, String timeZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(timeZone));
        long timestamp = zonedDateTime.toInstant().getEpochSecond();
        return timestamp;

    }

    /**
     * <p>
     * Description: 校验年月是否合法
     * </p>
     *
     * @param month : 年月 yyyy-MM|yyyyMM
     * @return  * @return : boolean
     */
    public static boolean isValidMonth(String month) {
        Pattern pattern = Pattern.compile("^[0-9]{4}-(0[1-9]|1[0-2])|[0-9]{4}(0[1-9]|1[0-2])$");
        Matcher matcher = pattern.matcher(month);
        if (!matcher.matches()) {
            return false;
        }
        String[] dayArray = month.split("-");
        return  isValidDay(Integer.parseInt(dayArray[0]), Integer.parseInt(dayArray[1]), 1);
    }

    /**
     * 判断指定年份是否是闰年
     *
     * @param year 年份
     * @return true：是闰年；false：不是闰年
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断指定整数是否为合法的日
     *
     * @param year  年份
     * @param month 月份
     * @param day   日
     * @return true：是合法的日；false：不是合法的日
     */
    public static boolean isValidDay(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                if (day >= 1 && day <= 29) {
                    return true;
                }
            } else {
                if (day >= 1 && day <= 28) {
                    return true;
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day >= 1 && day <= 30) {
                return true;
            }
        } else {
            if (day >= 1 && day <= 31) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Description: 获取某月向前/向后几个月
     * </p>
     *
     * @param monthStr : 月份字符串， yyyy-MM, yy-MM
     * @param monthFormat : 格式化
     * @param amountToAdd ： 增加月数
     * @return  * @return : java.lang.String
     */
    public static String plusMonth(String monthStr, String monthFormat, long amountToAdd) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(monthFormat);
        YearMonth yearMonth = YearMonth.parse(monthStr, dateTimeFormatter);

        return yearMonth.plus(amountToAdd, ChronoUnit.MONTHS).format(dateTimeFormatter);
    }


    public static void main(String[] args) {
        String timezone = "GMT+8";
        Long currentTimestamp = System.currentTimeMillis();
        System.out.println(formatTimestamp(timezone, currentTimestamp, "yyMM"));
        System.out.println(formatTimestamp(timezone, currentTimestamp, "yyyy-MM"));
        System.out.println(formatTimestamp(timezone, currentTimestamp, "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateFormatUtils.format(currentTimestamp, "yyyy-MM-dd HH:mm:ss",  TimeZone.getTimeZone( ZoneId.of(timezone))));
        timezone = "UTC";
        System.out.println(formatTimestamp(timezone, currentTimestamp, "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateFormatUtils.format(currentTimestamp, "yyyy-MM-dd HH:mm:ss",  TimeZone.getTimeZone( ZoneId.of(timezone))));

        System.out.println(plusMonth("23-07", "yy-MM", -1L));
        System.out.println(isValidDate("2023-02-29"));
        System.out.println(isValidMonth("2023-12"));

        System.out.println(getTimestampSecondForDay(ASIA_SHANGHAI, "2022-12-12 00:00:00", "yyyy-MM-dd HH:mm:ss"));

        long tmpDate = getTimestampSecondForDay(ASIA_SHANGHAI, "2022-12-12 00:00:00", "yyyy-MM-dd HH:mm:ss");
        timezone = "UTC";
        System.out.println(formatTimestamp(timezone, tmpDate, "yyyy-MM-dd HH:mm:ss"));


        long tmpDateOne = convertTimeToTimestamp("2022-12-12 10:10:00", "yyyy-MM-dd HH:mm:ss", ASIA_SHANGHAI);
        System.out.println(formatTimestamp(ASIA_SHANGHAI, tmpDateOne, "yyyy-MM-dd HH:mm:ss"));


    }
}
