package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 商城用户：(MallUsers)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MallUsers")
public class MallUsers implements Serializable {

    // MallUsers编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mall_users_id")
    private Integer mall_users_id;

    // 用户编号
    @Basic
    private String user_number;
    // 姓名
    @Basic
    private String full_name;
    // 年龄
    @Basic
    private String age;
    // 性别
    @Basic
    private String gender;
    // 类别
    @Basic
    private String category;
    // 简历
    @Basic
    private String resume;
    // 备注
    @Basic
    private String remarks;











    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
