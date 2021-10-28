package cn.bdqn.mapper;

import cn.bdqn.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-19
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<Integer> getCodeIdBySno(String sno);
    List<String> getCodeBySno(String sno);
    List<String> getAllSno();
}
