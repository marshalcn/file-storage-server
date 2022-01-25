package com.github.marshalcn.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author madechao
 * @menu
 * @description
 * @createTime 16:14 2022/1/14
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -6347354223896103499L;

    /** 创建人id */
    private Long createUserId;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
