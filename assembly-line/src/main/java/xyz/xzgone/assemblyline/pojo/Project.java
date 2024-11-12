package xyz.xzgone.assemblyline.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @TableName project
 */
@Data
@TableName(value = "project")
public class Project implements Serializable {
    @TableId
    private Integer pid;

    private String title;
    @Version
    private Integer version;

    private Integer isDeleted;


}