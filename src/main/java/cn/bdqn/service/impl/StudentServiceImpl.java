package cn.bdqn.service.impl;

import cn.bdqn.entity.Role;
import cn.bdqn.entity.Student;
import cn.bdqn.mapper.StudentMapper;
import cn.bdqn.service.IStudentService;
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
 * @since 2021-09-19
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<String> getCodeBuSno(String sno){
        return studentMapper.getCodeBySno(sno);
    }

    @Override
    public List<Integer> getCodeIdBuSno(String sno) {
        return studentMapper.getCodeIdBySno(sno);
    }

    @Override
    public List<String> getAllSno() {
        return studentMapper.getAllSno();
    }
}
