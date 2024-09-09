package com.example.room_back.Service;

import com.example.room_back.Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendService {
    List<User> findAllFriends(int userId);
    List<User> findPendingFriendRequests(int userId);
}
