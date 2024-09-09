package com.example.room_back.ServiceImp;

import com.example.room_back.Dao.GroupsDao;
import com.example.room_back.Entity.Groups;
import com.example.room_back.Entity.User;
import com.example.room_back.Service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsServiceImp implements GroupsService {
    private final GroupsDao groupsDao;

    @Autowired
    public GroupsServiceImp(GroupsDao groupsDao) {
        this.groupsDao = groupsDao;
    }
    @Override
    public List<User> findAllGroupMembers(int groupId){
        return groupsDao.findAllGroupMembers(groupId);
    }

    @Override
    public List<Groups> findAllGroupsByUser(int userId){
        List<Groups> groups = groupsDao.findAllGroupsByUser(userId);
        System.out.println("查询结果: " + groups);
        return groups;
    }

}
