package cn.bdqn.service.impl;

import cn.bdqn.entity.Subject;
import cn.bdqn.mapper.SubjectMapper;
import cn.bdqn.service.ISubjectService;
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
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    public List<Subject> getAll(){
        return subjectMapper.getAll();
    }
}
