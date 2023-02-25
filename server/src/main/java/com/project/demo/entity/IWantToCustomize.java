package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 我要定制：(IWantToCustomize)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "IWantToCustomize")
public class IWantToCustomize implements Serializable {

    // IWantToCustomize编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_want_to_customize_id")
    private Integer i_want_to_customize_id;

    // 商品名称
    @Basic
    private String trade_name;
    // 卖家账号
    @Basic
    private Integer seller_account;
    // 购买数量
    @Basic
    private Integer purchase_quantity;
    // 价格
    @Basic
    private String price;
    // 总金额
    @Basic
    private String total_amount;
    // 用户编号
    @Basic
    private Integer user_number;
    // 定制要求
    @Basic
    private String customized_requirements;
    // 相关图片
    @Basic
    private String related_pictures;
    // 完成时间
    @Basic
    private Timestamp completion_time;
    // 相关附件
    @Basic
    private String relevant_attachments;
    // 定制视频
    @Basic
    private String customized_video;
    // 定制音频
    @Basic
    private String customize_audio;
    // 要求日期
    @Basic
    private Timestamp required_date;
    // 定制类别
    @Basic
    private String custom_category;
    // 定制详情
    @Basic
    private String customization_details;
    // 取货类别
    @Basic
    private String picking_category;



    // 审核状态
    @Basic
    private String examine_state;

    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;

	// 选座状态
	@Basic
	private String seat;




    @Basic
    @Column(name = "user_id")
    private Integer userId;




    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
