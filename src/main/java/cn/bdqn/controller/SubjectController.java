package cn.bdqn.controller;


import cn.bdqn.common.lang.Result;
import cn.bdqn.entity.Subject;
import cn.bdqn.service.ISubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-19
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @GetMapping
    public Result getSubjects(){
        List<Subject> list = subjectService.getAll();
        return Result.succ(null, list);
    }

    @PostMapping
    public Result addSubject(Subject subject){
        boolean flag;
        flag = subjectService.save(subject);
        return Result.succ(flag?"添加成功":"添加失败",null);
    }
}
