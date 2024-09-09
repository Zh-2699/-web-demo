#查询1号用户的全部好友
SELECT
    CASE
        WHEN friendships.user_id1 = 1 THEN user2.uid
        ELSE user1.uid
        END AS friend_uid,
    CASE
        WHEN friendships.user_id1 = 1 THEN user2.username
        ELSE user1.username
        END AS friend_name
FROM
    Friendships
        JOIN
    user_table AS user1 ON Friendships.user_id1 = user1.uid
        JOIN
    user_table AS user2 ON Friendships.user_id2 = user2.uid
WHERE
    (Friendships.user_id1 = 1 OR Friendships.user_id2 = 1)
  AND Friendships.status = 'accepted';

# 查询特定群组的所有成员
SELECT *

FROM
    group_member
        JOIN
    user_table ON group_member.user_id = user_table.uid
WHERE
        group_member.group_id = 1;

#查询用户的每日学习时间
SELECT
    user_id, check_date, SUM(study_time) AS total_study_time
FROM
    daily_checks
WHERE
        user_id = 1
  AND check_date BETWEEN '2023-01-01' AND '2023-01-31'
GROUP BY
    check_date;

#查询用户尚未达成的学习目标
SELECT
    user_id, description, target_date
FROM
    study_goals
WHERE
        user_id = 1
  AND target_date > CURRENT_DATE;

# 查询用户收到的未处理的好友请求
SELECT
    user_table.username AS friend_request_from
FROM
    Friendships
        JOIN
    user_table ON Friendships.user_id1 = user_table.uid
WHERE
        Friendships.user_id2 = 1
  AND Friendships.status = 'pending';

# 查询用户参与的所有群组
SELECT
    `groups`.group_name
FROM
    group_member
        JOIN
    `groups` ON group_member.group_id = `groups`.group_id
WHERE
        group_member.user_id = 2;