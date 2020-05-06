package com.timber.eceiro.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimePeriodUtil {
    /**
     * 根据日期查询本周或本月其起始时间
     * @param date
     * @param type 1本周 2本月
     * @return
     */
    public static Map<String,Long> getWeekOrMonthPeriod(Date date,int type){
        Map<String,Long> timePeriod = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date start = new Date();
        Date end = new Date();

        try {
            calendar.setTime(simpleDateFormat.parse(simpleDateFormat.format(date)));
            //type=1时，计算本周时间段;type=2时，计算本月时间段
            if(type==1){
                //本周周一

                //Calendar默认每周日为一个星期第一天，与中国传统习惯不同。所以需要判断当天是不是星期日
                if(calendar.get(Calendar.DAY_OF_WEEK)==1){
                    calendar.add(Calendar.WEEK_OF_MONTH,-1);
                }
                calendar.set(Calendar.DAY_OF_WEEK,2);
                start = simpleDateFormat.parse(sdf.format(calendar.getTime())+" 00:00:00");

                //本周周日
                calendar.add(Calendar.WEEK_OF_MONTH,1);
                calendar.set(Calendar.DAY_OF_WEEK,1);
                end = simpleDateFormat.parse(sdf.format(calendar.getTime())+" 23:59:59");

            }else if (type==2){
                //本月第一天
                calendar.add(Calendar.MONTH,0);
                calendar.set(Calendar.DAY_OF_MONTH,1);
                start = simpleDateFormat.parse(sdf.format(calendar.getTime())+" 00:00:00");

                //本月最后一天
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                end = simpleDateFormat.parse(sdf.format(calendar.getTime())+" 23:59:59");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long startTime = start.getTime()/1000;
        Long endTime = end.getTime()/1000;
        timePeriod.put("startTime",startTime);
        timePeriod.put("endTime",endTime);
        return timePeriod;
    }

    /**
     * 获取查询时间段 默认为当天时间段（每天08:00:00至第二天08:00:00为一个时间段）
     * @param params
     * @param timeNode 时间节点（默认一天的时间节点为00:00:00.本项目，巡检时间段的时间节点为08:00:00）
     * @return
     */
    public static Map<String, Long> getTimePeriod(Map<String,Object> params, String timeNode){
        Map<String,Long> timePeriod = new HashMap<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Date date = (params.get("date")!=null)?simpleDateFormat.parse((String)params.get("date")+" "+timeNode)
                    :simpleDateFormat.parse(sd.format(new Date())+" "+timeNode);
            Calendar calender = Calendar.getInstance();
            calender.setTime(date);
            long startTime = calender.getTimeInMillis()/1000;
            calender.add(Calendar.DAY_OF_MONTH,1);
            long endTime = calender.getTimeInMillis()/1000;
            timePeriod.put("startTime",startTime);
            timePeriod.put("endTime",endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timePeriod;
    }

    /**
     * patrol_type=1时，获取的为当天8：00至当天20：00的起始时间戳
     * patrol_type=2时，获取的为当天20:00至第二天早8:00的起始时间戳
     * @return
     */
    public static Map<String,Long> getHalfDayTime(Long clock,String alais){
        Map<String,Long> time = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        if(clock!=0L){
            date = new Date(clock*1000);
        }
        try {
            //当天早8点
            Date firstEight = simpleDateFormat.parse(sdf.format(date)+" 08:00:00");
            long firstEightTime = firstEight.getTime()/1000;
            //当天晚八点
            Date firstTwenty = simpleDateFormat.parse(sdf.format(date)+" 20:00:00");
            long firstTwentyTime = firstTwenty.getTime()/1000;
            //昨天日期
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH,-1);
            String lastTwentyString = sdf.format(calendar.getTime());
            //昨天晚八点日期
            Date lastTwenty = simpleDateFormat.parse(lastTwentyString+" 20:00:00");
            long lastTwentyTime = lastTwenty.getTime()/1000;

            //第二天日期
            calendar.add(Calendar.DAY_OF_MONTH,2);
            String secondEightString = sdf.format(calendar.getTime());
            //第二天早晨八点日期
            Date secondEight = simpleDateFormat.parse(secondEightString+" 08:00:00");
            long secondEightTime = secondEight.getTime()/1000;

            if(alais.equals("early")){
                time.put("startTime",firstEightTime);
                time.put("endTime",firstTwentyTime);
            }
            if(alais.equals("evening")){
                SimpleDateFormat hoursdf = new SimpleDateFormat("HH");
                int hour = Integer.parseInt(hoursdf.format(date));
                if(hour<=8){
                    time.put("startTime",lastTwentyTime);
                    time.put("endTime",firstEightTime);
                }
                if(hour>=20){
                    time.put("startTime",firstTwentyTime);
                    time.put("endTime",secondEightTime);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

}
