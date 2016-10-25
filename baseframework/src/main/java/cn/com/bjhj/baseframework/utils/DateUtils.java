package cn.com.bjhj.baseframework.utils;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 日期时间工具类
 * Created by huiyao huang on 2016/7/18.
 */
public class DateUtils  extends android.text.format.DateUtils {

    public final static int DATE_EARLY = 2; //早
    public final static int DATE_EQUALS = 1; //相等
    public final static int DATE_LATE = 3; //晚

    /**
     * The enum Difference mode.
     */
    public enum DifferenceMode {
        Second,
        Minute,
        Hour,
        Day
    }

    /**
     * Calculate different second long.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the long
     */
    public static long calculateDifferentSecond(Date startDate, Date endDate) {
        return calculateDifference(startDate, endDate, DifferenceMode.Second);
    }

    /**
     * Calculate different minute long.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the long
     */
    public static long calculateDifferentMinute(Date startDate, Date endDate) {
        return calculateDifference(startDate, endDate, DifferenceMode.Minute);
    }

    /**
     * Calculate different hour long.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the long
     */
    public static long calculateDifferentHour(Date startDate, Date endDate) {
        return calculateDifference(startDate, endDate, DifferenceMode.Hour);
    }

    /**
     * Calculate different day long.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the long
     */
    public static long calculateDifferentDay(Date startDate, Date endDate) {
        return calculateDifference(startDate, endDate, DifferenceMode.Day);
    }

    /**
     * Calculate different second long.
     *
     * @param startTimeMillis the start time millis
     * @param endTimeMillis   the end time millis
     * @return the long
     */
    public static long calculateDifferentSecond(long startTimeMillis, long endTimeMillis) {
        return calculateDifference(startTimeMillis, endTimeMillis, DifferenceMode.Second);
    }

    /**
     * Calculate different minute long.
     *
     * @param startTimeMillis the start time millis
     * @param endTimeMillis   the end time millis
     * @return the long
     */
    public static long calculateDifferentMinute(long startTimeMillis, long endTimeMillis) {
        return calculateDifference(startTimeMillis, endTimeMillis, DifferenceMode.Minute);
    }

    /**
     * Calculate different hour long.
     *
     * @param startTimeMillis the start time millis
     * @param endTimeMillis   the end time millis
     * @return the long
     */
    public static long calculateDifferentHour(long startTimeMillis, long endTimeMillis) {
        return calculateDifference(startTimeMillis, endTimeMillis, DifferenceMode.Hour);
    }

    /**
     * Calculate different day long.
     *
     * @param startTimeMillis the start time millis
     * @param endTimeMillis   the end time millis
     * @return the long
     */
    public static long calculateDifferentDay(long startTimeMillis, long endTimeMillis) {
        return calculateDifference(startTimeMillis, endTimeMillis, DifferenceMode.Day);
    }

    /**
     * Calculate difference long.
     *
     * @param startTimeMillis the start time millis
     * @param endTimeMillis   the end time millis
     * @param mode            the mode
     * @return the long
     */
    public static long calculateDifference(long startTimeMillis, long endTimeMillis, DifferenceMode mode) {
        return calculateDifference(new Date(startTimeMillis), new Date(endTimeMillis), mode);
    }

    /**
     * Calculate difference long.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @param mode      the mode
     * @return the long
     */
    public static long calculateDifference(Date startDate, Date endDate, DifferenceMode mode) {
        long[] different = calculateDifference(startDate, endDate);
        if (mode.equals(DifferenceMode.Minute)) {
            return different[2];
        } else if (mode.equals(DifferenceMode.Hour)) {
            return different[1];
        } else if (mode.equals(DifferenceMode.Day)) {
            return different[0];
        } else {
            return different[3];
        }
    }

    /**
     * Calculate difference long [ ].
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the long [ ]
     */
    public static long[] calculateDifference(Date startDate, Date endDate) {
        return calculateDifference(endDate.getTime() - startDate.getTime());
    }

    /**
     * Calculate difference long [ ].
     *
     * @param differentMilliSeconds the different milli seconds
     * @return the long [ ]
     */
    public static long[] calculateDifference(long differentMilliSeconds) {
        long secondsInMilli = 1000;//1s==1000ms
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        long elapsedDays = differentMilliSeconds / daysInMilli;
        differentMilliSeconds = differentMilliSeconds % daysInMilli;
        long elapsedHours = differentMilliSeconds / hoursInMilli;
        differentMilliSeconds = differentMilliSeconds % hoursInMilli;
        long elapsedMinutes = differentMilliSeconds / minutesInMilli;
        differentMilliSeconds = differentMilliSeconds % minutesInMilli;
        long elapsedSeconds = differentMilliSeconds / secondsInMilli;
        L.d(String.format(Locale.CHINA, "different: %d ms, %d days, %d hours, %d minutes, %d seconds",
                differentMilliSeconds, elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds));
        return new long[]{elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds};
    }

    /**
     * Calculate days in month int.
     *
     * @param month the month
     * @return the int
     */
    public static int calculateDaysInMonth(int month) {
        return calculateDaysInMonth(0, month);
    }

    /**
     * Calculate days in month int.
     *
     * @param year  the year
     * @param month the month
     * @return the int
     */
    public static int calculateDaysInMonth(int year, int month) {
        // 添加大小月月份并将其转换为list,方便之后的判断
        String[] bigMonths = {"1", "3", "5", "7", "8", "10", "12"};
        String[] littleMonths = {"4", "6", "9", "11"};
        List<String> bigList = Arrays.asList(bigMonths);
        List<String> littleList = Arrays.asList(littleMonths);
        // 判断大小月及是否闰年,用来确定"日"的数据
        if (bigList.contains(String.valueOf(month))) {
            return 31;
        } else if (littleList.contains(String.valueOf(month))) {
            return 30;
        } else {
            if (year <= 0) {
                return 29;
            }
            // 是否闰年
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                return 29;
            } else {
                return 28;
            }
        }
    }

    /**
     * 月日时分秒，0-9前补0
     *
     * @param number the number
     * @return the string
     */
    @NonNull
    public static String fillZero(int number) {
        return number < 10 ? "0" + number : "" + number;
    }

    /**
     * 功能：判断日期是否和当前date对象在同一天。
     * 参见：http://www.cnblogs.com/myzhijie/p/3330970.html
     *
     * @param date 比较的日期
     * @return boolean 如果在返回true，否则返回false。
     * @author 沙琪玛 QQ：862990787 Aug 21, 2013 7:15:53 AM
     */
    public static boolean isSameDay(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        }
        Calendar nowCalendar = Calendar.getInstance();
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(date);
        return (nowCalendar.get(Calendar.ERA) == newCalendar.get(Calendar.ERA) &&
                nowCalendar.get(Calendar.YEAR) == newCalendar.get(Calendar.YEAR) &&
                nowCalendar.get(Calendar.DAY_OF_YEAR) == newCalendar.get(Calendar.DAY_OF_YEAR));
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss字符串转换成日期<br/>
     *
     * @param dateStr    时间字符串
     * @param dataFormat 当前时间字符串的格式。
     * @return Date 日期 ,转换异常时返回null。
     */
    public static Date parseDate(String dateStr, String dataFormat) {
        try {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat dateFormat = new SimpleDateFormat(dataFormat);
            Date date = dateFormat.parse(dateStr);
            return new Date(date.getTime());
        } catch (Exception e) {
            L.w(e);
            return null;
        }
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss字符串转换成日期<br/>
     *
     * @param dateStr yyyy-MM-dd HH:mm:ss字符串
     * @return Date 日期 ,转换异常时返回null。
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化时间
     * @param date
     * @param dataFormat
     * @return
     */
    public static String getDate(long date , String dataFormat){
        SimpleDateFormat formatter = new SimpleDateFormat(dataFormat);
        return  formatter.format(date);
    }

    /**
     * 比较两个时间戳 早晚
     * @param date1 被比较时间
     * @param date2 参照时间
     * @return 1 - 两个时间相等   2- date1比date2晚  3-date1比date2早
     */
    public static int compareDate(long date1 , long date2){
        if(date1 == date2){
            return DATE_EQUALS;
        }else if( date1 > date2){
            return DATE_LATE;
        }else{
            return DATE_EARLY;
        }
    }

    /**
     * 比较一个时间和当前时间大小
     * @param date1 this date
     * @return 1 - 两个时间相等   2- date1比现在晚  3-date1比现在早
     */
    public static int compareDate(long date1){
        long date2 = System.currentTimeMillis();
        return compareDate(date1 , date2);
    }

    /**
     * 将时间戳转为代表 “距现在多久之前” 的字符串
     * @param t 时间戳
     * @return
     */
    public static String getStandardDate(long t) {
        StringBuffer sb = new StringBuffer();

        long time = System.currentTimeMillis() - (t);
        long mill = (long) Math.ceil(time /1000);//秒前

        long minute = (long) Math.ceil(time/60/1000.0f);// 分钟前

        long hour = (long) Math.ceil(time/60/60/1000.0f);// 小时

        long day = (long) Math.ceil(time/24/60/60/1000.0f);// 天前
        //L.i("time == " + time +"   mill == " +mill +"   minute == "+ minute +"   hour == " + hour+"   day == " +day);
        if (day - 28 >0) {
            sb.append(getDate(t , "yyyy-MM-dd HH:mm"));
        }else if (day - 1 > 0) {
            sb.append(day + "天");
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天");
            } else {
                sb.append(hour + "小时");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时");
            } else {
                sb.append(minute + "分钟");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟");
            } else {
                sb.append(mill + "秒");
            }
        } else {
            sb.append("刚刚");
        }
        if (!sb.toString().equals("刚刚") && !(day-28>0)) {
            sb.append("前");
        }
        //L.i("sb.toString " + sb.toString());
        return sb.toString();
    }
}
