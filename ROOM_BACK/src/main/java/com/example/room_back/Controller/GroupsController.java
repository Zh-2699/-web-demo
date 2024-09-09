package com.example.room_back.Controller;

import com.example.room_back.Entity.CommonResult;
import com.example.room_back.Entity.Groups;
import com.example.room_back.Entity.User;
import com.example.room_back.Service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupsController {
    private final GroupsService groupsService;

    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    // 查询群成员
    @GetMapping("/{groupId}/members")
    public ResponseEntity<?> getAllGroupMembers(@PathVariable int groupId) {
        List<User> members = groupsService.findAllGroupMembers(groupId);
        return ResponseEntity.ok(CommonResult.success("查询成功", members));
    }

    // 查询用户创建的群
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllGroupsByUser(@PathVariable int userId) {
        List<Groups> groups = groupsService.findAllGroupsByUser(userId);
        return ResponseEntity.ok(CommonResult.success("查询成功", groups));
    }
}
