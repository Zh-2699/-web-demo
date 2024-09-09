package com.example.room_back.Dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.room_back.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendDao {
    // 查询用户的全部好友
    List<User> findAllFriends(@Param("userId") int userId);

    // 查询用户收到的未处理的好友请求
    List<User> findPendingFriendRequests(@Param("userId") int userId);

    //添加好友请求
    // 发送好友请求
    int sendFriendRequest(@Param("userId1") int userId1, @Param("userId2") int userId2);
}
