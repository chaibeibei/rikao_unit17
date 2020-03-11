package com.chaiyining.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateUtil {

	
	
	 //获取指定日期所在月份开始的时间
	public static String getMonthstart(String specifiedDay) throws java.text.ParseException {
        Date data = null;
        data = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        Calendar c = Calendar.getInstance();
        c.setTime(data);

        //设置为当月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至59
        c.set(Calendar.MINUTE, 0);
        //将秒至59
        c.set(Calendar.SECOND, 0);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 0);
        // 本月第一天的时间戳转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sdf.parse(sdf.format(new Date(new Long(c.getTimeInMillis()))));
            //Date date = sdf.parse(sdf.format(new Long(s)));// 等价于
            return sdf.format(date);
        } catch (NumberFormatException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return null;
    }
	
	
     //获取指定日期所在月份结束的时间
     
    public static String getMonthEnd(String specifiedDay) throws java.text.ParseException {
        Date data = null;
        data = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        Calendar c = Calendar.getInstance();
        c.setTime(data);

        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND, 59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 本月第一天的时间戳转换为字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sdf.parse(sdf.format(new Date(new Long(c.getTimeInMillis()))));
            //Date date = sdf.parse(sdf.format(new Long(s)));// 等价于
            return sdf.format(date);
        } catch (NumberFormatException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return null;
    }
    
   public static void main(String[] args) {
	
	   try {
		System.out.println(DateUtil.getMonthEnd("2019-02-11"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   try {
		System.out.println(DateUtil.getMonthstart("2019-02-11"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
    
}
