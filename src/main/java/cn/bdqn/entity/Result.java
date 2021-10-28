package cn.bdqn.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id",type = IdType.AUTO)
    private Integer id;

    @TableField("StudentNo")
    private String studentno;

    @TableField("SubjectId")
    private Integer subjectid;

    @TableField("StudentResult")
    private Integer studentresult;

    @TableField("ExamDate")
    private Date examdate;

    @TableField(exist = false)
    private Subject subject;

    @TableField(exist = false)
    private Student student;

}
