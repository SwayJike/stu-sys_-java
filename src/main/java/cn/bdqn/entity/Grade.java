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
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "GradeId", type = IdType.AUTO)
    private Integer gradeid;

    @TableField("GradeName")
    private String gradename;


}
