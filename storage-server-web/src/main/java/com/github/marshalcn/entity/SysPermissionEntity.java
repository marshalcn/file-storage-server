package com.github.marshalcn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_permission")
public class SysPermissionEntity implements Serializable {
    private static final long serialVersionUID = 649617705008075191L;
    private Integer id;
    private String code;
    private String name;
}
