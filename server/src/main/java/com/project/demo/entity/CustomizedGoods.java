package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 定制商品：(CustomizedGoods)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CustomizedGoods")
public class CustomizedGoods implements Serializable {

    // CustomizedGoods编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customized_goods_id")
    private Integer customized_goods_id;

    // 商品名称
    @Basic
    private String trade_name;
    // 库存
    @Basic
    private Integer stock;
    // 附件
    @Basic
    private String enclosure;
    // 图片
    @Basic
    private String picture;
    // 视频
    @Basic
    private String video;
    // 音频
    @Basic
    private String audio_frequency;
    // 备注
    @Basic
    private String remarks;
    // 卖家账号
    @Basic
    private Integer seller_account_number;
    // 商品类别
    @Basic
    private String commodity_category;
    // 价格
    @Basic
    private Integer price;
    // 详情
    @Basic
    private String details;
    // 生产时间
    @Basic
    private Timestamp production_time;
    // 日期
    @Basic
    private Timestamp date;
    // 是否特价
    @Basic
    private String special_price_or_not;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;

    // 审核状态
    @Basic
    private String examine_state;



	// 扫码状态
	@Basic
	private String qrcode_img;

	// 二维码标题
	@Basic
	private String qrcode_title;

	// 计时器标题
	@Basic
	private String timer_title;
	
	// 计时开始时间
	@Basic
	private Timestamp timing_start_time;
	
	// 计时结束时间
	@Basic
	private Timestamp timing_end_time;

	// 限制次数
	@Basic
	private Integer limit_times;

    // 限制次数类型
    @Basic
    private Integer limit_type;





    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
