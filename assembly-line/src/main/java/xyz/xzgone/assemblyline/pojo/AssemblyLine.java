package xyz.xzgone.assemblyline.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @TableName assembly_line
 */
@Setter
@Getter
@TableName(value = "assembly_line")
public class AssemblyLine implements Serializable {
    private Integer id;

    private String projectId;

    private String projectName;

    private String docId;

    private String docName;

    private String docLink;

    private String lineId;

    private String lineName;

    private String lineLink;

    private String sheetId;
    @Version
    private Integer version;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

}