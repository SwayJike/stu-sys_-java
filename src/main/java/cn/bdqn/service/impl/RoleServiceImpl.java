package cn.bdqn.service.impl;

import cn.bdqn.entity.Role;
import cn.bdqn.mapper.RoleMapper;
import cn.bdqn.service.IRoleService;
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
 * @since 2021-09-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Integer> getMenuIdByCodeId(List<Integer> ids) {
        return roleMapper.getMenuIdByCodeId(ids);
    }
}
