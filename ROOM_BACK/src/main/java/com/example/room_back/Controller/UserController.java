package com.example.room_back.Controller;

import com.example.room_back.Entity.DailyChecks;
import com.example.room_back.Entity.StudyGoals;
import com.example.room_back.Entity.User;
import com.example.room_back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.room_back.Entity.CommonResult;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 获取指定用户在给定日期范围内的每日学习时间
    @GetMapping("/{userId}/daily-times")
    public ResponseEntity<CommonResult> getDailyStudyTimes(@PathVariable int userId, @RequestParam String startDate, @RequestParam String endDate) {
        System.out.println(startDate);
        System.out.println(endDate);

        List<DailyChecks> dailyTimes = userService.getDailyStudyTimes(userId, startDate, endDate);
        System.out.println(dailyTimes);
        return ResponseEntity.ok(CommonResult.success("查询成功", dailyTimes));
    }

    // 获取指定用户的未完成学习目标
    @GetMapping("/{userId}/pending-goals")
    public ResponseEntity<CommonResult> getPendingStudyGoals(@PathVariable int userId) {
        List<StudyGoals> goals = userService.getPendingStudyGoals(userId);
        if (goals.isEmpty()) {
            return ResponseEntity.ok(CommonResult.success("当前没有未完成的学习目标"));
        }
        return ResponseEntity.ok(CommonResult.success("查询成功", goals));
    }

    // 通过用户 ID 获取用户信息
    @GetMapping("/{uid}")
    public ResponseEntity<CommonResult> getUserById(@PathVariable int uid) {
        User user = userService.getUserById(uid);
        if (user != null) {
            return ResponseEntity.ok(CommonResult.success("查询成功", user));
        } else {
            return ResponseEntity.ok(CommonResult.error("用户不存在"));
        }
    }

    // 注册用户，插入信息
    @PostMapping("/register")
    public ResponseEntity<CommonResult> insertUser(@RequestBody User user){
        //异常
        if ( user.getUserName() == null || user.getUserName().isEmpty()) {
            return ResponseEntity.ok(CommonResult.error("用户名不能为空"));
        }
        if ( user.getEmail() == null || user.getEmail().isEmpty() ){
            return ResponseEntity.ok(CommonResult.error("用户邮箱不能为空"));
        }
        if ( user.getPassword() == null || user.getPassword().isEmpty() ){
            return  ResponseEntity.ok(CommonResult.error("密码不能为空"));
        }
        //查询用户名是否重复
        if (userService.getUserByUserName(user.getUserName()) != null){
            return ResponseEntity.ok(CommonResult.error("用户名重复"));
        }

        //正常情况
        userService.insertUser(user);
        //获取存入用户的id
        return ResponseEntity.ok(CommonResult.success("用户注册成功", userService.getUserByUserName(user.getUserName()).getUid() ));
    }

    //登录
    @PostMapping("/login")
    public ResponseEntity<CommonResult> userLogin(@RequestBody User loginRequest) {
        if ( loginRequest.getUserName() == null || loginRequest.getUserName().isEmpty() ){
            return ResponseEntity.ok(CommonResult.error("用户名不能为空"));
        }
        if ( loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty() ){
            return ResponseEntity.ok(CommonResult.error("请输入密码"));
        }

        //正常情况
        boolean isValidUser = userService.validateUserLogin(loginRequest.getUserName(), loginRequest.getPassword());

        if ( isValidUser ){
            String token = userService.generateToken(loginRequest.getUserName());

            return ResponseEntity.ok(CommonResult.success("登陆成功", token));
        }
        return ResponseEntity.ok(CommonResult.error("用户名或密码错误"));
    }

    //查询好友
    @PostMapping("/search_friend")
    public ResponseEntity<CommonResult> searchFriend(@RequestBody User searchRequest) {
        if (searchRequest.getUserName() == null || searchRequest.getUserName().isEmpty()) {
            return ResponseEntity.ok(CommonResult.error("请输入用户名"));
        }

        User user = userService.getUserByUserName(searchRequest.getUserName());

        if (user != null) {
            user.setPassword(null);
            return ResponseEntity.ok(CommonResult.success("查询成功", user));
        }

        return ResponseEntity.ok(CommonResult.error("未查询到用户"));
    }



}
