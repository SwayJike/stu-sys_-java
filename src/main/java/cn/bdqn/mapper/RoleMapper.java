package cn.bdqn.mapper;

import cn.bdqn.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-20
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Integer> getMenuIdByCodeId(List<Integer> id);
}
