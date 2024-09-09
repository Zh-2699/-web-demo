package com.example.room_back.Service;

import com.example.room_back.Entity.Groups;
import com.example.room_back.Entity.User;

import java.util.List;

public interface GroupsService {
    List<User> findAllGroupMembers(int groupId);
    List<Groups> findAllGroupsByUser(int userId);

}
