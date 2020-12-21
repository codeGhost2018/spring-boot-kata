package com.tim.kata.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 度量表
 */
@Data
@TableName(value = "metric")
public class Metric implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 域账号
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 主度量
     */
    @TableField(value = "main_metric")
    private String mainMetric;

    /**
     * 度量项
     */
    @TableField(value = "sub_metric")
    private String subMetric;

    /**
     * 度量项内容
     */
    @TableField(value = "metric_item")
    private String metricItem;

    /**
     * 创建人
     */
    @TableField(value = "creator")
    private String creator;

    /**
     * 修改人
     */
    @TableField(value = "modifier")
    private String modifier;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted")
    private String isDeleted;

    @TableField(value = "`state`")
    private String state;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_MAIN_METRIC = "main_metric";

    public static final String COL_SUB_METRIC = "sub_metric";

    public static final String COL_METRIC_ITEM = "metric_item";

    public static final String COL_CREATOR = "creator";

    public static final String COL_MODIFIER = "modifier";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    public static final String COL_IS_DELETED = "is_deleted";

    public static final String COL_STATE = "state";
}