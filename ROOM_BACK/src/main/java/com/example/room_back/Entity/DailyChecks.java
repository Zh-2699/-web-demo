package com.example.room_back.Entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "daily_checks")
@Data
public class DailyChecks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer checkId;

    @Column(nullable = false)
    private Date checkDate;

    @Column(nullable = false)
    private Integer studyTime;

    @Column(nullable = false)
    private Integer userId;

}
