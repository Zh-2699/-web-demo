package com.example.room_back.Dao;

import com.example.room_back.Entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.room_back.Entity.DailyChecks;
import com.example.room_back.Entity.StudyGoals;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    // 查询用户的每日学习时间
    List<DailyChecks> findDailyStudyTimes(@Param("userId") int userId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    // 查询用户尚未达成的学习目标
    List<StudyGoals> findPendingStudyGoals(@Param("userId") int userId);

    // 查询用户全部信息——id
    User findUserById(@Param("uid") int uid);

    //注册
    void insertUser(User user);

    //查询用户--userName
    User findUserByUserName(@Param("userName") String userName);



}
