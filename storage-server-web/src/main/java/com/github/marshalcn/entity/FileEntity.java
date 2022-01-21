package com.github.marshalcn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("fs_file")
public class FileEntity implements Serializable {
    private static final long serialVersionUID = 4576559581515852515L;

    /** id */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /** 文件名 */
    @TableField("file_name")
    private String fileName;
    /** 文件路径 */
    @TableField("file_path")
    private String filePath;
    /** 文件大小 */
    @TableField("file_size")
    private Long fileSize;
    /** 识别码 */
    @TableField("identifier")
    private String identifier;
    /** 存储位置 */
    private Integer locate;
    /** 文件来源 */
    @TableField("`source`")
    private Integer source;
    /** 文件状态 */
    @TableField("status")
    private Integer status;
    /** 创建时间 */
    @TableField("create_time")
    private Date createTime;
}
