package com.timber.eceiro.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface RongCloudDao {

    public int chat_build(Map<String, Object> map);
    public int chat_delete(Map<String, Object> map);
    public int chat_update(Map<String, Object> map);
    public List<Map<String,Object>> chat_list(Map<String, Object> map);

    public Map<String,Object> user_detail(@Param("rong_user_id") String rong_user_id);


    public int group_insert(Map<String, Object> map);
    public Map<String,Object> group_select(@Param("rong_group_id") String rong_group_id, @Param("group_id") Integer group_id);
    public int group_user_insert(Map<String, Object> map);
    public int group_user_delete(Map<String, Object> map);
    public List<Map<String,Object>> group_user_select(Map<String, Object> map);
    public int group_update(Map<String, Object> map);

    public int group_notice_insert(Map<String, Object> map);
    public int group_notice_update(Map<String, Object> map);
    public  List<Map<String,Object>> group_notice_list(Map<String, Object> map);

    public List<Map<String,Object>> group_list_ByUser(Map<String, Object> map);
    public List<Map<String,Object>> user_list_ByGroup(Map<String, Object> map);
    public List<Map<String,Object>> user_list(Map<String, Object> map);

    public List<Map<String,Object>> work_type_list(Map<String, Object> map);
    public List<Map<String,Object>> work_remind_list(Map<String, Object> map);
    public List<Map<String,Object>> work_list_ByDate(Map<String, Object> map);
    public List<Map<String,Object>> work_list_ByUser(Map<String, Object> map);
    public int work_add(Map<String, Object> map);


    public List<Map<String,Object>> getUserByList(List<String> list);


    public Map<String,Object> getCompanyById(@Param("company_id") Integer company_id);
    public List<Map<String,Object>> getDepartmentById(@Param("department_id") Integer department_id, @Param("company_id") Integer company_id);
    public List<Map<String,Object>> getGroupById(@Param("group_id") Integer group_id, @Param("department_id") Integer department_id);


    public List<Map<String,Object>> getLimitRow(Map<String, Object> map);

    public List<Map<String,Object>> getAlmanac(Map<String, Object> map);
    public int insertAlmanac(Map<String, Object> map);
    public int updateAlmanac(Map<String, Object> map);


    List<Map<String,Object>> selectMalfunctionList(@Param("statusList") List<Integer> statusList,
                                                   @Param("userId") int userId,
                                                   @Param("pageSize") int pageSize,
                                                   @Param("creatAt") Integer createAt,
                                                   @Param("fixBys") List<Integer> fixBys,
                                                   @Param("departmentId") Integer departmentId,
                                                   @Param("isCharge") Integer isCharge,
                                                   @Param("companyId") Integer companyId);
    Integer selectMalfunctionListCount(@Param("statusList") List<Integer> statusList,
                                       @Param("userId") int userId,
                                       @Param("fixBys") List<Integer> fixBys,
                                       @Param("departmentId") Integer departmentId,
                                       @Param("isCharge") Integer isCharge,
                                       @Param("companyId") Integer companyId);

    public List<Map<String, Object>> supervision_list(Map<String, Object> map);
    public int supervision_count(Map<String, Object> map);


    /**
     *  ding消息
     */
    public List<Map<String, Object>> selectDingReceiveUser(Map<String, Object> map);
    public List<Map<String, Object>> selectDingInfo(Map<String, Object> map);
    public int insertDingUser(Map<String, Object> map);
    public int updateDingUser(Map<String, Object> map);

    public Map<String, Object> getUserInfoByRongId(@Param("rong_user_id") String rong_user_id);

    public String getUserNameById(@Param("user_id") Integer user_id,
                                  @Param("rong_user_id") String rong_user_id);

}
