-- # 1.user_table
create table user_table
(
    uid         int auto_increment comment 'user id'
        primary key,
    userName    char(20) not null comment 'user name',
    password    char(16) not null comment 'user password',
    email       char(50) not null comment 'user email',
    picture     blob     not null comment 'user picture',
    phoneNumber int      not null
);

-- # 2.friendships
create table friendships
(
    friendship_id int auto_increment comment '关系id'
        primary key,
    user_id1      int                          not null comment '1号id',
    user_id2      int                          not null comment '2号id',
    status        enum ('pending', 'accepted') not null comment '状态: 等待，接受',
    created_at    timestamp                    not null,
    constraint user_id1
        foreign key (user_id1) references user_table (uid),
    constraint user_id2
        foreign key (user_id2) references user_table (uid)
)
    comment '用户关系表';
-- #3. groups
create table `groups`
(
    group_id   int auto_increment comment '群组id'
        primary key,
    group_name varchar(20) not null comment '群组名称',
    create_by  int         not null comment '群主',
    constraint create_by
        foreign key (create_by) references user_table (uid)
)
    comment '群组表';

-- #4. group_member
create table group_member
(
    member_id int auto_increment comment '组员id'
        primary key,
    group_id  int       not null comment '群组id',
    user_id   int       not null comment '用户id',
    joined_at timestamp not null comment '加入时间',
    constraint group_id
        foreign key (group_id) references `groups` (group_id),
    constraint user_id
        foreign key (user_id) references user_table (uid)
)
    comment '群成员';

-- #5. daily_checks
create table daily_checks
(
    check_id   int auto_increment comment '打卡记录id'
        primary key,
    check_date date not null comment '打卡日期',
    study_time int  not null comment '暂时不确定打卡的内容,以时间填充',
    user_id    int  not null comment '用户id',
    constraint daily_checks_user_table_uid_fk
        foreign key (user_id) references user_table (uid)
)
    comment '打卡记录表';

-- #6. study_contents
create table study_contents
(
    content_id int auto_increment comment '内容id'
        primary key,
    user_id    int       not null comment '用户id',
    content    text      not null comment '学习内容，暂时用text代替',
    create_at  timestamp not null comment '创建时间',
    constraint study_contents_user_table_uid_fk
        foreign key (user_id) references user_table (uid)
)
    comment '学习内容表';

-- #7. study_goals
create table study_goals
(
    goal_id     int auto_increment comment '目标id'
        primary key,
    user_id     int  not null comment '用户id',
    description text not null comment '描述',
    target_date date not null comment '设立时间',
    constraint study_goals_user_table_uid_fk
        foreign key (user_id) references user_table (uid)
)
    comment '学习目标表';