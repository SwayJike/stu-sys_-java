package cn.bdqn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SubjectId", type = IdType.AUTO)
    private Integer subjectid;

    @TableField("SubjectName")
    private String subjectname;

    @TableField("ClassHour")
    private Integer classhour;

    @TableField("GradeId")
    private Integer gradeid;

    @TableField(exist = false)
    private Grade grade;

}
