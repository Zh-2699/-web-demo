package com.example.room_back.Dao;

import com.example.room_back.Entity.Groups;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.room_back.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsDao {
    // 查询特定群组的所有成员
    List<User> findAllGroupMembers(@Param("groupId") int groupId);

    // 查询用户参与的所有群组
    List<Groups> findAllGroupsByUser(@Param("userId") int userId);
}

