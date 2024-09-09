package com.example.room_back.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "groups")
@Data
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    @Column(nullable = false, length = 20)
    private String groupName;

    @Column(nullable = false)
    private Integer createBy;
}
