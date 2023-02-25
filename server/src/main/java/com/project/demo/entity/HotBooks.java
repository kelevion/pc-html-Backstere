package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 热卖图书：(HotBooks)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "HotBooks")
public class HotBooks implements Serializable {

    // HotBooks编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hot_books_id")
    private Integer hot_books_id;

    // 图书编号
    @Basic
    private String book_number;
    // 图书名称
    @Basic
    private String book_name;
    // 封面
    @Basic
    private String cover;
    // 作者
    @Basic
    private String author;
    // 商品类别
    @Basic
    private String commodity_category;
    // 库存
    @Basic
    private String stock;
    // 价格
    @Basic
    private String price;
    // 简介
    @Basic
    private String brief_introduction;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;











    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
