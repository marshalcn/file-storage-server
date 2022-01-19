package com.github.marshalcn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author madechao
 * @menu
 * @description
 * @createTime 15:39 2022/1/14
 */
@Data
@TableName("fs_file_chunk")
public class FileChunkEntity implements Serializable {
    private static final long serialVersionUID = -3841803643922980874L;

    /** id */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /** 文件Hash */
    @TableField("identifier")
    private String identifier;
    /** 分片序号 */
    @TableField("chunk_no")
    private Integer chunkNo;
    /** 分片大小 */
    @TableField("chunk_size")
    private Long chunkSize;
}
