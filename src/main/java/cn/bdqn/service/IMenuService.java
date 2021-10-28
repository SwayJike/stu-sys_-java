package cn.bdqn.service;

import cn.bdqn.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-23
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getMenuList(List<Integer> menuIds);
}
