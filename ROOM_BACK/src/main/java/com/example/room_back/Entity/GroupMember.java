package com.example.room_back.Entity;

import lombok.Data;
import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "group_member")
@Data
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    @Column(nullable = false)
    private Integer groupId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Timestamp joinedAt;
}
