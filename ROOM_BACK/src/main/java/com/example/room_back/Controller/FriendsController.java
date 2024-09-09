package com.example.room_back.Controller;

import com.example.room_back.Entity.CommonResult;
import com.example.room_back.Entity.User;
import com.example.room_back.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsController {
    private final FriendService friendService;

    @Autowired
    public FriendsController(FriendService friendService) {
        this.friendService = friendService;
    }

    //获取全部好友
    @GetMapping("/{userId}/all")
    public ResponseEntity<?> getAllFriends(@PathVariable int userId) {
        List<User> friends = friendService.findAllFriends(userId);
        if (friends.isEmpty()){
            return ResponseEntity.ok(CommonResult.success("该用户无好友"));
        }
        return ResponseEntity.ok(CommonResult.success("查询成功", friends));
    }

    //获取待接收好友列表
    @GetMapping("/{userId}/pending-requests")
    public ResponseEntity<?> getPendingFriendRequests(@PathVariable int userId) {
        List<User> pendingRequests = friendService.findPendingFriendRequests(userId);
        if (pendingRequests.isEmpty()){
            return ResponseEntity.ok(CommonResult.success("该用户无待处理的好友请求"));
        }
        return ResponseEntity.ok(CommonResult.success("查询成功", pendingRequests));
    }
}
