package cn.bdqn.service.impl;

import cn.bdqn.entity.Menu;
import cn.bdqn.mapper.MenuMapper;
import cn.bdqn.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-23
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> getMenuList(List<Integer> menuIds){
        return menuMapper.getMenuList(menuIds);
    }

}
