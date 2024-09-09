package com.example.room_back.ServiceImp;

import com.example.room_back.Dao.UserDao;
import com.example.room_back.Entity.DailyChecks;
import com.example.room_back.Entity.StudyGoals;
import com.example.room_back.Entity.User;
import com.example.room_back.Service.UserService;
import com.example.room_back.Util.jwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;
    private final jwtUtil jwtUtil;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Autowired
    public UserServiceImp(UserDao userDao, jwtUtil jwtUtil) {
        this.userDao = userDao;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public List<DailyChecks> getDailyStudyTimes(int userId, String startDate, String endDate) {
        return userDao.findDailyStudyTimes(userId, startDate, endDate);
    }

    @Override
    public List<StudyGoals> getPendingStudyGoals(int userId) {
        return userDao.findPendingStudyGoals(userId);
    }

    @Override
    public User getUserById(int uid) {
        User user = userDao.findUserById(uid);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        User user = userDao.findUserByUserName(userName);
        if (user != null) {
            return user;
        }
        return null;
    }

    // 登录
    public boolean validateUserLogin(String userName, String password) {
        logger.debug("Validating user login for userName: {}", userName);

        if (userDao == null) {
            logger.error("userDao is not initialized");
            throw new NullPointerException("userDao is not initialized");
        }

        User user = userDao.findUserByUserName(userName);
        if (user == null) {
            logger.debug("User not found with userName: {}", userName);
            return false;
        }

        boolean isValid = user.getPassword().equals(password);
        logger.debug("User validation result: {}", isValid);
        return isValid;
    }

    // 生成Token
    public String generateToken(String userName) {
        logger.debug("Generating token for userName: {}", userName);

        if (jwtUtil == null) {
            logger.error("jwtUtil is not initialized");
            throw new NullPointerException("jwtUtil is not initialized");
        }

        return jwtUtil.generateToken(userName);
    }
}
