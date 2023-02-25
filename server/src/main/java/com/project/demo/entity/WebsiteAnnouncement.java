package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 网站公告：(WebsiteAnnouncement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "WebsiteAnnouncement")
public class WebsiteAnnouncement implements Serializable {

    // WebsiteAnnouncement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "website_announcement_id")
    private Integer website_announcement_id;

    // 标题
    @Basic
    private String title;
    // 发布人
    @Basic
    private String publisher;
    // 发布时间
    @Basic
    private Timestamp release_time;
    // 相关附件
    @Basic
    private String relevant_accessories;
    // 详情
    @Basic
    private String details;

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
