package com.example.room_back.Service;

import com.example.room_back.Entity.User;
import com.example.room_back.Entity.DailyChecks;
import com.example.room_back.Entity.StudyGoals;
import java.util.List;

public interface UserService {
    List<DailyChecks> getDailyStudyTimes(int userId, String startDate, String endDate);
    List<StudyGoals> getPendingStudyGoals(int userId);
    User getUserById(int uid);
    void insertUser(User user);
    User getUserByUserName(String userName);

    boolean validateUserLogin(String userName, String password);

    String generateToken(String userName);
}

