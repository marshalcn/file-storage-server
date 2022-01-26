package com.github.marshalcn.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysTokenEntity extends BaseEntity {
    private static final long serialVersionUID = 4377014830067438944L;
    /** id **/
    private Long id;
    /** userId **/
    private Long userId;
    /** token 令牌 **/
    private String token;
    /** 过期时间 **/
    private Date expireTime;
}
