package com.example.room_back.Entity;

import lombok.Data;
import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "friendships")
@Data
public class Friendships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendshipId;

    @Column(nullable = false)
    private Integer userId1;

    @Column(nullable = false)
    private Integer userId2;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Timestamp createdAt;

    public enum Status {
        pending, accepted
    }
}
