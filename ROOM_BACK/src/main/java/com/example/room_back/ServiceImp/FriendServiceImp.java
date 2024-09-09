package com.example.room_back.ServiceImp;

import com.example.room_back.Dao.FriendDao;
import com.example.room_back.Entity.User;
import com.example.room_back.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImp implements FriendService {

    private final FriendDao friendDao;

    @Autowired
    public FriendServiceImp(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    @Override
    public List<User> findAllFriends(int userId){
        return friendDao.findAllFriends(userId);
    }

    @Override
    public List<User> findPendingFriendRequests(int userId){
        return friendDao.findPendingFriendRequests(userId);
    }


}
