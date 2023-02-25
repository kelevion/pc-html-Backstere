package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 分类信息：(ClassificationInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ClassificationInformation")
public class ClassificationInformation implements Serializable {

    // ClassificationInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classification_information_id")
    private Integer classification_information_id;

    // 商品类别
    @Basic
    private String commodity_category;
    // 类别
    @Basic
    private String category;
    // 定制类别
    @Basic
    private String custom_category;













    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
