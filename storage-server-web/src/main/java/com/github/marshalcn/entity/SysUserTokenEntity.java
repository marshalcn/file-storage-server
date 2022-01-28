package com.github.marshalcn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("`sys_user_token`")
public class SysUserTokenEntity extends BaseEntity {
    private static final long serialVersionUID = 4377014830067438944L;
    /** id **/
    private Long id;
    /** userId **/
    @TableField("user_id")
    private Long userId;
    /** token 令牌 **/
    private String token;
    /** 过期时间 **/
    @TableField("expire_time")
    private Date expireTime;
}
