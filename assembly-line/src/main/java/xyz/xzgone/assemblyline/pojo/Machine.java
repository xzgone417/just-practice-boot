package xyz.xzgone.assemblyline.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName machine
 */
@TableName(value = "machine")
@Data
public class Machine implements Serializable {
    private Integer id;

    private String projectId;

    private String projectName;

    private String docId;

    private String docName;

    private String docLink;
    @Version
    private Integer version;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}