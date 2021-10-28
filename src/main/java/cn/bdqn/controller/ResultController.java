package cn.bdqn.controller;


import cn.bdqn.common.lang.Result;
import cn.bdqn.service.IResultService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-19
 */
@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private IResultService resultService;

    @GetMapping("/{SubjectId}")
    public Result getResultList(@PathVariable(value = "SubjectId")Integer subjectid){
        return Result.succ(null,resultService.getAll(subjectid));
    }

    @PostMapping
    public Result addResult(cn.bdqn.entity.Result result){
        boolean flag = resultService.save(result);
        return Result.succ(flag?"添加成功":"添加失败",null);
    }

}
