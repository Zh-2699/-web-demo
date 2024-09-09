package com.example.room_back.Entity;

import lombok.Data;
import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "study_contents")
@Data
public class StudyContents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contentId;

    @Column(nullable = false)
    private Integer userId;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp createAt;
}
