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
 * @createTime 10:09 2022/1/17
 */
@Data
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {
    private static final long serialVersionUID = 2262794209858118310L;

    /** id */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /** 用户名 */
    @TableField("`user_name`")
    private String userName;
    /** 盐 */
    @TableField("`salt`")
    private String salt;
    /** 登录名 */
    @TableField("`login_name`")
    private String loginName;
    /** 密码 */
    @TableField("`passwd`")
    private String passwd;
    /** 邮件 */
    @TableField("`mail`")
    private String mail;
    /** 手机 */
    @TableField("`phone`")
    private String phone;
}
