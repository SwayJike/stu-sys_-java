package cn.bdqn.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

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
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "学号")
    @TableId("StudentNo")
    private String studentno;

    @TableField("LoginPwd")
    private String loginpwd;

    @Excel(name = "学生姓名")
    @TableField("StudentName")
    private String studentname;

    @Excel(name = "性别")
    @TableField("Sex")
    private String sex;

    @Excel(name = "年级")
    @TableField("GradeId")
    private Integer gradeid;

    @Excel(name = "电话")
    @TableField("Phone")
    private String phone;

    @Excel(name = "地址")
    @TableField("Address")
    private String address;

    @Excel(name = "生日")
    @TableField("BornDate")
    private Date borndate;

    @Excel(name = "邮箱")
    @TableField("Email")
    private String email;


}
