package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 卖家：(Seller)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Seller")
public class Seller implements Serializable {

    // Seller编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Integer seller_id;

    // 卖家账号
    @Basic
    private String seller_account_number;
    // 店铺名称
    @Basic
    private String store_name;



    // 审核状态
    @Basic
    private String examine_state;








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
