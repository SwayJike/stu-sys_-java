package cn.bdqn.controller;


import cn.bdqn.common.lang.Result;
import cn.bdqn.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-19
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private IGradeService gradeService;

    @GetMapping
    public Result getGrade(){
        return Result.succ(null,gradeService.list());
    }

}
