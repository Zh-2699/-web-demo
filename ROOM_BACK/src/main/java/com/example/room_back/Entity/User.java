package com.example.room_back.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(nullable = false, length = 20)
    private String userName;

    @Column(nullable = false, length = 16)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Lob
    @Column(nullable = false)
    private byte[] picture;

    @Column(nullable = false)
    private Integer phoneNumber;

    private Integer createBy;


}
