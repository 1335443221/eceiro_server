package com.timber.eceiro.common.utils;


import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DateUtil {
		// ==格式到年==
		/**
		 * 日期格式，年份，例如：2004，2008
		 */
		public   String DATE_FORMAT_YYYY = "yyyy";
		
		// ==格式到年月 ==
		/**
		 * 日期格式，年份和月份，例如：200707，200808
		 */
		public   String DATE_FORMAT_YYYYMM = "yyyyMM";
		/**
		 * 日期格式，年份和月份，例如：200707，2008-08
		 */
		public   String DATE_FORMAT_YYYY_MM = "yyyy-MM";

		// ==格式到年月日== 
		/**
		 * 日期格式，年月日，例如：050630，080808
		 */
		public   String DATE_FORMAT_YYMMDD = "yyMMdd";
		/**
		 * 日期格式，年月日，用横杠分开，例如：06-12-25，08-08-08
		 */
		public   String DATE_FORMAT_YY_MM_DD = "yy-MM-dd";
	 
		/**
		 * 日期格式，年月日，例如：20050630，20080808
		 */
		public  final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
		
		/**
		 * 日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
		 */
		public  String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
		public  String DATE_FORMAT_00 = " 00:00:00";
		
		/**
		 * 日期格式，年月日，例如：2016.10.05
		 */
		public  String DATE_FORMAT_POINTYYYYMMDD = "yyyy.MM.dd";
		
		/**
		 * 日期格式，年月日，例如：2016年10月05日
		 */
		public  String DATE_FORMAT_YYYY年MM月DD日 = "yyyy年MM月dd日";
		
		
		// ==格式到年月日 时分 == 
		
		/**
		 * 日期格式，年月日时分，例如：200506301210，200808081210
		 */
		public  String DATE_FORMAT_YYYYMMDDHHmm = "yyyyMMddHHmm";
	 
		/**
		 * 日期格式，年月日时分，例如：20001230 12:00，20080808 20:08
		 */
		public  String DATE_FORMAT_YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";
		
		/**
		 * 日期格式，年月日时分，例如：2000-12-30 12:00，2008-08-08 20:08
		 */
		public  String DATE_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";
		
		
		// ==格式到年月日 时分秒== 
		/**
		 * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
		 */
		public  String DATE_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";
		
		/**
		 * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开
		 * 例如：2005-05-10 23：20：00，2008-08-08 20:08:08
		 */
		public  String DATE_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
		public  String DATE_FORMAT_YYYY_MM_DD_HH_MI_SS_SS = "dd-MMM-yyyy HH:mm:ss:SSS";

		
		// ==格式到年月日 时分秒 毫秒== 
		/**
		 * 日期格式，年月日时分秒毫秒，例如：20001230120000123，20080808200808456
		 */
		public  String DATE_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";
	    
		
		// ==特殊格式==
		/**
		 * 日期格式，月日时分，例如：10-05 12:00
		 */
		public  String DATE_FORMAT_MMDDHHMI = "MM-dd HH:mm";
	 
		
		/* ************工具方法***************   */
		
		/** 
	     * 获取某日期的年份
	     * @param date 
	     * @return 
	     */
		public  Integer getYear(Date date) {
	   	 	Calendar cal = Calendar.getInstance();
	   	 	cal.setTime(date);
			return cal.get(Calendar.YEAR);
		}  
		
		/**
		 * 获取某日期的月份
		 * @param date
		 * @return
		 */
		public  Integer getMonth(Date date) {
			Calendar cal = Calendar.getInstance();
	   	 	cal.setTime(date);
			return cal.get(Calendar.MONTH) + 1;
		}
		
		/**
		 * 获取某日期的日数
		 * @param date
		 * @return
		 */
		public  Integer getDay(Date date){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			 int day=cal.get(Calendar.DATE);//获取日
			 return day;
		}
		
	    /**
	     * 格式化Date时间
	     * @param time Date类型时间
	     * @param timeFromat String类型格式
	     * @return 格式化后的字符串
	     */
	    public  String parseDateToStr(Date time, String timeFromat){
	    	DateFormat dateFormat=new SimpleDateFormat(timeFromat);
	    	return dateFormat.format(time);
	    }
	    
	    /**
	     * 格式化Timestamp时间
	     * @param timestamp Timestamp类型时间
	     * @param timeFromat
	     * @return 格式化后的字符串
	     */
	    public  String parseTimestampToStr(Timestamp timestamp,String timeFromat){
	    	SimpleDateFormat df = new SimpleDateFormat(timeFromat);
	    	return df.format(timestamp);
	    }
	    
	    /**
	     * 格式化Date时间
	     * @param time Date类型时间
	     * @param timeFromat String类型格式
	     * @param defaultValue 默认值为当前时间Date
	     * @return 格式化后的字符串
	     */
	    public  String parseDateToStr(Date time, String timeFromat, final Date defaultValue){
	    	try{
	    		DateFormat dateFormat=new SimpleDateFormat(timeFromat);
	        	return dateFormat.format(time);
	    	}catch (Exception e){
	    		if(defaultValue!=null){
					return parseDateToStr(defaultValue, timeFromat);
				}else{
					return parseDateToStr(new Date(), timeFromat);
				}
		}
	    }
	    
	    /**
	     * 格式化Date时间
	     * @param time Date类型时间
	     * @param timeFromat String类型格式
	     * @param defaultValue 默认时间值String类型
	     * @return 格式化后的字符串
	     */
	    public  String parseDateToStr(Date time, String timeFromat, final String defaultValue){
	    	try{
	    		DateFormat dateFormat=new SimpleDateFormat(timeFromat);
	        	return dateFormat.format(time);
	    	}catch (Exception e){
	    		return defaultValue;
	    	}
	    }
	    
	    /**
	     * 格式化String时间
	     * @param time String类型时间
	     * @param timeFromat String类型格式
	     * @return 格式化后的Date日期
	     */
	    public  Date parseStrToDate(String time, String timeFromat) {
	    	if (time == null || time.equals("")) {
	    		return null;
	    	}
	    	
	    	Date date=null;
	    	try{
		    	DateFormat dateFormat=new SimpleDateFormat(timeFromat);
		    	date=dateFormat.parse(time);
	    	}catch(Exception e){
	    		
	    	}
	    	return date;
	    }


	    /**
	     * 格式化String时间
	     * @param time Date类型时间
	     * @param oldFromat  旧的String类型格式
	     * @param newFromat  旧的新的类型格式
	     * @return 格式化后的Date日期
	     */
	    public  Date parseDateToDate(Date time, String oldFromat,String newFromat) {
	    	if (time == null || time.equals("")) {
	    		return null;
	    	}
	    	String date=null;
			DateFormat dateFormat=null;
	    	try{
		    	dateFormat=new SimpleDateFormat(oldFromat);
		    	date=dateFormat.format(time);
				dateFormat=new SimpleDateFormat(newFromat);
				time=dateFormat.parse(date);
	    	}catch(Exception e){
	    	}
	    	return time;
	    }
			/**
			 * 格式化String时间
			 * @param time String类型时间
			 * @param oldFromat  旧的String类型格式
			 * @param newFromat  旧的新的类型格式
			 * @return 格式化后的Date日期
			 */
			public  String parseStrToStr(String time, String oldFromat,String newFromat) {
				if (time == null || time.equals("")) {
					return null;
				}
				Date date=null;
				DateFormat dateFormat=null;
				try{
					dateFormat=new SimpleDateFormat(oldFromat);
					date=dateFormat.parse(time);
				}catch(Exception e){
				}
				dateFormat=new SimpleDateFormat(newFromat);
				return dateFormat.format(date);
			}

				/**
				 * 获取二十四小时之后的时间
				 * @param time String类型时间
				 * @param timeFromat  String类型格式
				 * @return 格式化后的Date日期
				 */
				public  String getLastDayOfTime(String time, String timeFromat) {
					Calendar c = Calendar.getInstance();
					Date date=null;
					try {
						date = new SimpleDateFormat(timeFromat).parse(time);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					c.setTime(date);
					int day=c.get(Calendar.DATE);
					c.set(Calendar.DATE,day+1);
					String dayAfter=new SimpleDateFormat(timeFromat).format(c.getTime());
					return dayAfter;
				}


				/**
				 * 获取二十四小时之前的时间
				 * @param time String类型时间
				 * @param timeFromat  String类型格式
				 * @return 格式化后的Date日期
				 */
				public  String getBeforeDayOfTime(String time, String timeFromat) {
					Calendar c = Calendar.getInstance();
					Date date=null;
					try {
						date = new SimpleDateFormat(timeFromat).parse(time);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					c.setTime(date);
					int day=c.get(Calendar.DATE);
					c.set(Calendar.DATE,day-1);
					String dayAfter=new SimpleDateFormat(timeFromat).format(c.getTime());
					return dayAfter;
				}





	public  String formatStr(String time, String timeFromat) {
		return parseDateToStr(	parseStrToDate(time,timeFromat),timeFromat);

	}
	    /**
	     * 格式化String时间
	     * @param strTime String类型时间
	     * @param timeFromat String类型格式
	     * @param defaultValue 异常时返回的默认值
	     * @return
	     */
	    public  Date parseStrToDate(String strTime, String timeFromat,
				Date defaultValue) {
			try {
				DateFormat dateFormat = new SimpleDateFormat(timeFromat);
				return dateFormat.parse(strTime);
			} catch (Exception e) {
				return defaultValue;
			}
		}
	    
	    /**
	     * 当strTime为2008-9时返回为2008-9-1 00:00格式日期时间，无法转换返回null.
	     * @param strTime
	     * @return
	     */
	    public  Date strToDate(String strTime) {
	    	if(strTime==null || strTime.trim().length()<=0){
				return null;
			}
			Date date = null;
			List<String> list = new ArrayList<String>(0);
			
			list.add(DATE_FORMAT_YYYY_MM_DD_HH_MI_SS);
			list.add(DATE_FORMAT_YYYYMMDDHHMISSSSS);
			list.add(DATE_FORMAT_YYYY_MM_DD_HH_MI);
			list.add(DATE_FORMAT_YYYYMMDD_HH_MI);
			list.add(DATE_FORMAT_YYYYMMDDHHMISS);
			list.add(DATE_FORMAT_YYYY_MM_DD);
			//list.add(DATE_FORMAT_YY_MM_DD);
			list.add(DATE_FORMAT_YYYYMMDD);
			list.add(DATE_FORMAT_YYYY_MM);
			list.add(DATE_FORMAT_YYYYMM);
			list.add(DATE_FORMAT_YYYY);
			
			
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				String format = (String) iter.next();
				if(strTime.indexOf("-")>0 && format.indexOf("-")<0)
					continue;
				if(strTime.indexOf("-")<0 && format.indexOf("-")>0){
					continue;
				}

				if(strTime.length()>format.length()){
					continue;
				}
				date = parseStrToDate(strTime, format);
				if (date != null){
					break;
				}
			}
	 
			return date;
		}
	    
	    /**
		 * 解析两个日期之间的所有月份
		 * @param beginDateStr 开始日期，至少精确到yyyy-MM
		 * @param endDateStr 结束日期，至少精确到yyyy-MM
		 * @return yyyy-MM日期集合
		 */  
	    public  List<String> getMonthListOfDate(String beginDateStr, String endDateStr) {  
	        // 指定要解析的时间格式  
	        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");  
	        // 返回的月份列表  
	        String sRet = "";  
	  
	        // 定义一些变量  
	        Date beginDate = null;  
	        Date endDate = null;  
	  
	        GregorianCalendar beginGC = null;  
	        GregorianCalendar endGC = null;  
	        List<String> list = new ArrayList<String>();  
	  
	        try {  
	            // 将字符串parse成日期  
	            beginDate = f.parse(beginDateStr);  
	            endDate = f.parse(endDateStr);  
	  
	            // 设置日历  
	            beginGC = new GregorianCalendar();  
	            beginGC.setTime(beginDate);  
	  
	            endGC = new GregorianCalendar();  
	            endGC.setTime(endDate);  
	  
	            // 直到两个时间相同  
	            while (beginGC.getTime().compareTo(endGC.getTime()) <= 0) {  
	                sRet = beginGC.get(Calendar.YEAR) + "-"  
	                        + (beginGC.get(Calendar.MONTH) + 1);  
	                list.add(sRet);  
	                // 以月为单位，增加时间  
	                beginGC.add(Calendar.MONTH, 1);  
	            }  
	            return list;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	  
	    /** 
	     * 解析两个日期段之间的所有日期
	     * @param beginDateStr 开始日期  ，至少精确到yyyy-MM-dd
	     * @param endDateStr 结束日期  ，至少精确到yyyy-MM-dd
	     * @return yyyy-MM-dd日期集合
	     */  
	    public  List<String> getDayListOfDate(String beginDateStr, String endDateStr) {  
	        // 指定要解析的时间格式  
	        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");  
	  
	        // 定义一些变量  
	        Date beginDate = null;  
	        Date endDate = null;  
	  
	        Calendar beginGC = null;  
	        Calendar endGC = null;  
	        List<String> list = new ArrayList<String>();  
	  
	        try {  
	            // 将字符串parse成日期  
	            beginDate = f.parse(beginDateStr);  
	            endDate = f.parse(endDateStr);  
	  
	            // 设置日历  
	            beginGC = Calendar.getInstance();  
	            beginGC.setTime(beginDate);  
	  
	            endGC = Calendar.getInstance();  
	            endGC.setTime(endDate);  
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	  
	            // 直到两个时间相同  
	            while (beginGC.getTime().compareTo(endGC.getTime()) <= 0) {  
	  
	                list.add(sdf.format(beginGC.getTime()));  
	                // 以日为单位，增加时间  
	                beginGC.add(Calendar.DAY_OF_MONTH, 1);  
	            }  
	            return list;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	  
	    /**
	     * 获取当下年份指定前后数量的年份集合
	     * @param before 当下年份前年数
	     * @param behind 当下年份后年数
	     * @return 集合
	     */
	    public  List<Integer> getYearListOfYears(int before,int behind) {
	    	if (before<0 || behind<0) {
				return null;
			}
	        List<Integer> list = new ArrayList<Integer>();  
	        Calendar c = null;  
	        c = Calendar.getInstance();  
	        c.setTime(new Date());  
	        int currYear = Calendar.getInstance().get(Calendar.YEAR);  
	  
	        int startYear = currYear - before;  
	        int endYear = currYear + behind;  
	        for (int i = startYear; i < endYear; i++) {  
	            list.add(Integer.valueOf(i));  
	        }  
	        return list;  
	    }
	    
	    /** 
	     * 获取当前日期是一年中第几周 
	     * @param date 
	     * @return 
	     */  
	    public  Integer getWeekthOfYear(Date date) {  
	        Calendar c = new GregorianCalendar();  
	        c.setFirstDayOfWeek(Calendar.MONDAY);  
	        c.setMinimalDaysInFirstWeek(7);  
	        c.setTime(date);  
	  
	        return c.get(Calendar.WEEK_OF_YEAR);  
	    } 
	 
	    /**
		 * 获取某一年各星期的始终时间
		 * 实例：getWeekList(2016)，第52周(从2016-12-26至2017-01-01)
		 * @param 
		 * @return
		 */  
	    public  HashMap<Integer,String> getWeekTimeOfYear(int year) {  
	        HashMap<Integer,String> map = new LinkedHashMap<Integer,String>();  
	        Calendar c = new GregorianCalendar();  
	        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);  
	        int count = getWeekthOfYear(c.getTime());  
	  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	        String dayOfWeekStart = "";  
	        String dayOfWeekEnd = "";  
	        for (int i = 1; i <= count; i++) {  
	            dayOfWeekStart = sdf.format(getFirstDayOfWeek(year, i));  
	            dayOfWeekEnd = sdf.format(getLastDayOfWeek(year, i));  
	            map.put(Integer.valueOf(i), "第"+i+"周(从"+dayOfWeekStart + "至" + dayOfWeekEnd+")");  
	        }  
	        return map;  
	  
	    }  
	      
	    /** 
	     * 获取某一年的总周数 
	     * @param year 
	     * @return 
	     */  
	    public  Integer getWeekCountOfYear(int year){  
	        Calendar c = new GregorianCalendar();  
	        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);  
	        int count = getWeekthOfYear(c.getTime());  
	        return count;  
	    }  
	    
	    /** 
	     * 获取指定日期所在周的第一天 
	     * @param date 
	     * @return 
	     */  
	    public  Date getFirstDayOfWeek(Date date) {  
	        Calendar c = new GregorianCalendar();  
	        c.setFirstDayOfWeek(Calendar.MONDAY);  
	        c.setTime(date);  
	        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday  
	        return c.getTime();  
	    }  
	  
	    /** 
	     * 获取指定日期所在周的最后一天 
	     * @param date 
	     * @return 
	     */  
	    public  Date getLastDayOfWeek(Date date) {
			Calendar c = new GregorianCalendar();
			c.setFirstDayOfWeek(Calendar.MONDAY);
			c.setTime(date);
			c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
			return c.getTime();
		}
	  
	    /** 
	     * 获取某年某周的第一天 
	     * @param year 目标年份
	     * @param week 目标周数
	     * @return 
	     */  
	    public  Date getFirstDayOfWeek(int year, int week) {  
	        Calendar c = new GregorianCalendar();  
	        c.set(Calendar.YEAR, year);  
	        c.set(Calendar.MONTH, Calendar.JANUARY);  
	        c.set(Calendar.DATE, 1);  
	  
	        Calendar cal = (GregorianCalendar) c.clone();
	        cal.add(Calendar.DATE, week * 7);  
	  
	        return getFirstDayOfWeek(cal.getTime());  
	    }  
	  
	    /** 
	     * 获取某年某周的最后一天 
	     * @param year 目标年份
	     * @param week 目标周数
	     * @return 
	     */  
	    public  Date getLastDayOfWeek(int year, int week) {  
	        Calendar c = new GregorianCalendar();  
	        c.set(Calendar.YEAR, year);  
	        c.set(Calendar.MONTH, Calendar.JANUARY);  
	        c.set(Calendar.DATE, 1);  
	  
	        Calendar cal = (GregorianCalendar) c.clone();  
	        cal.add(Calendar.DATE, week * 7);  
	  
	        return getLastDayOfWeek(cal.getTime());  
	    }  
	      
	    /** 
	     * 获取某年某月的第一天 
	     * @param year 目标年份
	     * @param month 目标月份
	     * @return 
	     */  
	    public  Date getFirstDayOfMonth(int year,int month){  
	        month = month-1;  
	        Calendar   c   =   Calendar.getInstance();     
	        c.set(Calendar.YEAR, year);  
	        c.set(Calendar.MONTH, month);  
	          
	        int day = c.getActualMinimum(c.DAY_OF_MONTH);  
	  
	        c.set(Calendar.DAY_OF_MONTH, day);
	        c.set(Calendar.HOUR_OF_DAY, 0);
	        c.set(Calendar.MINUTE, 0);
	        c.set(Calendar.SECOND, 0);
	        c.set(Calendar.MILLISECOND, 0);
	        return c.getTime();
	    }  
	      
	    /** 
	     * 获取某年某月的最后一天 
	     * @param year 目标年份
	     * @param month 目标月份
	     * @return 
	     */  
	    public  Date getLastDayOfMonth(int year,int month){  
	        month = month-1;  
	        Calendar   c   =   Calendar.getInstance();     
	        c.set(Calendar.YEAR, year);  
	        c.set(Calendar.MONTH, month);  
	        int day = c.getActualMaximum(c.DAY_OF_MONTH);  
	        c.set(Calendar.DAY_OF_MONTH, day);
	        c.set(Calendar.HOUR_OF_DAY, 23);
	        c.set(Calendar.MINUTE, 59);
	        c.set(Calendar.SECOND, 59);
	        c.set(Calendar.MILLISECOND, 999);
	        return c.getTime();  
	    }  
	  
	    /** 
	     * 获取某个日期为星期几 
	     * @param date 
	     * @return String "星期*"
	     */  
	    public  String getDayWeekOfDate1(Date date) {  
	    	 String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	    	 Calendar cal = Calendar.getInstance();
	         cal.setTime(date);
	 
	         int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	         if (w < 0){
				 w = 0;
			 }
	         return weekDays[w];
	    }  
	    
	    /**
		 * 获得指定日期的星期几数
		 * @param date
		 * @return int 
		 */ 
	    public  Integer getDayWeekOfDate2(Date date){  
	    	Calendar aCalendar = Calendar.getInstance();  
	    	aCalendar.setTime(date);     
	    	int weekDay = aCalendar.get(Calendar.DAY_OF_WEEK);     
	    	return weekDay;
	    }
	    

		/**
		 * 将指定日期的时分秒格式为零
		 * @param date
		 * @return
		 */
		public  Date formatHhMmSsOfDate(Date date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime();
		}
		
		/**
		 * 获得指定时间加减参数后的日期(不计算则输入0) 
		 * @param date 指定日期
		 * @param year 年数，可正可负
		 * @param month 月数，可正可负
		 * @param day 天数，可正可负
		 * @param hour 小时数，可正可负
		 * @param minute 分钟数，可正可负
		 * @param second 秒数，可正可负
		 * @param millisecond 毫秒数，可正可负
		 * @return 计算后的日期
		 */
		public  Date addDate(Date date,int year,int month,int day,int hour,int minute,int second,int millisecond){
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.YEAR, year);//加减年数
			c.add(Calendar.MONTH, month);//加减月数
			c.add(Calendar.DATE, day);//加减天数
			c.add(Calendar.HOUR,hour);//加减小时数
			c.add(Calendar.MINUTE, minute);//加减分钟数
			c.add(Calendar.SECOND, second);//加减秒
			c.add(Calendar.MILLISECOND, millisecond);//加减毫秒数
			
			return c.getTime();
		}
		
		/**
		 * 获得两个日期的时间戳之差
		 * @param startDate
		 * @param endDate
		 * @return
		 */
		public  Long getDistanceTimestamp(Date startDate,Date endDate){
			long daysBetween=(endDate.getTime()-startDate.getTime()+1000000)/(3600*24*1000);
			return daysBetween;
		}
		

	    public  long[] getDistanceTime(String str1, String str2) { 
	        DateFormat df = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MI_SS); 
	        Date one; 
	        Date two; 
	        long day = 0; 
	        long hour = 0; 
	        long min = 0; 
	        long sec = 0; 
	        try { 
	            one = df.parse(str1); 
	            two = df.parse(str2); 
	            long time1 = one.getTime(); 
	            long time2 = two.getTime(); 
	            long diff ; 
	            if(time1<time2) { 
	                diff = time2 - time1; 
	            } else { 
	                diff = time1 - time2; 
	            } 
	            day = diff / (24 * 60 * 60 * 1000); 
	            hour = (diff / (60 * 60 * 1000) - day * 24); 
	            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60); 
	            sec = (diff/1000-day*24*60*60-hour*60*60-min*60); 
	        } catch (ParseException e) { 
	            e.printStackTrace(); 
	        } 
	        long[] times = {day, hour, min, sec}; 
	        return times; 
	    } 
	    
	    /** 
	     * 两个时间之间相差距离多少天 
	     * @param one 时间参数 1： 
	     * @param two 时间参数 2： 
	     * @return 相差天数 
	     */ 

		/**
		 * 获取指定时间的那天 23:59:59.999 的时间
		 * @param date
		 * @return
		 */
		public  Date getDayEndTime(final Date date) {
		        Calendar c = Calendar.getInstance();
		        c.setTime(date);
		        c.set(Calendar.HOUR_OF_DAY, 23);
		        c.set(Calendar.MINUTE, 59);
		        c.set(Calendar.SECOND, 59);
		        c.set(Calendar.MILLISECOND, 999);
		        return c.getTime();
		}
		/**
		 * 获取指定格式时间字符串
		 * @param
		 * @return
		 */
		public  String getFormateDateStr(Calendar cla,String formate) {
			SimpleDateFormat sj = new SimpleDateFormat(formate);
	        return  sj.format(cla.getTime());
		}
	   
	    
	    public  void main(String [] args){
			try {
				DateUtil dateUtil = new DateUtil();
				System.out.println();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
}
