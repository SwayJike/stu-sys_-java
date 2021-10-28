package cn.bdqn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId("id")
    private int id;

    /**
     * 项目位置
     */
    @TableField("url")
    private String url;

    /**
     * 菜单URL
     */
    @TableField("path")
    private String path;

    @TableField("component")
    private String component;

    @TableField("name")
    private String name;

    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 父菜单ID，一级菜单为0
     */
    @TableField("parentid")
    private Integer parentid;

    @TableField(exist = false)
    private List<Menu> children;

}
