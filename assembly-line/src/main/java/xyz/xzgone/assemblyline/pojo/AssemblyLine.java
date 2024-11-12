package xyz.xzgone.assemblyline.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @TableName assembly_line
 */
@Setter
@Getter
@TableName(value ="assembly_line")
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

    private Integer version;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

}