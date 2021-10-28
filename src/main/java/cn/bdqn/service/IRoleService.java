package cn.bdqn.service;

import cn.bdqn.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-20
 */
public interface IRoleService extends IService<Role> {

    List<Integer> getMenuIdByCodeId(List<Integer> ids);

}
