package cn.bdqn.mapper;

import cn.bdqn.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-23
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuList(List<Integer> menuIds);
}
