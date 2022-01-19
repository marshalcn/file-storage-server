package com.github.marshalcn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author madechao
 * @menu
 * @description
 * @createTime 16:36 2022/1/14
 */
@Data
@TableName("fs_platform_source")
public class PlatformSourceEntity extends BaseEntity{
    private static final long serialVersionUID = -6605416428283708720L;
    /** id */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /** 来源名 */
    @TableField("`source`")
    private String source;
    /** 备注 */
    @TableField("`note`")
    private String note;
    /** validate token */
    @TableField("`key`")
    private String key;
}
