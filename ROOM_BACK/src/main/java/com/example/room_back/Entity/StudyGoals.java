package com.example.room_back.Entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "study_goals")
@Data
public class StudyGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goalId;

    @Column(nullable = false)
    private Integer userId;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date targetDate;
}
