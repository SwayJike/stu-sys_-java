package cn.bdqn.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.bdqn.common.lang.Result;
import cn.bdqn.entity.Student;
import cn.bdqn.service.IResultService;
import cn.bdqn.service.IStudentService;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.nativesandbox.comm.Response;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IResultService resultService;

    @GetMapping("/test")
    public Result test(){
        return Result.succ("SwayJike");
    }


    @GetMapping("/getAllSno")
    public Result getAllSno(){
        return Result.succ(null,studentService.getAllSno());
    }

    @GetMapping("/getList")
    public Result list(@RequestParam("searchno")String searchno,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,@RequestParam(value = "pageSize",defaultValue = "0")int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentService.list(new QueryWrapper<Student>().like("studentno",searchno));
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Result.succ("查询成功",
                MapUtil.builder()
                .put("total",total)
                .put("pageInfo",pageInfo)
                .build()
        );
    }

    @DeleteMapping("/{sno}")
    public Result delete(@PathVariable("sno")String sno){
        resultService.remove(new QueryWrapper<cn.bdqn.entity.Result>().eq("StudentNo", sno));
        boolean flag = studentService.remove(new UpdateWrapper<Student>().eq("studentno", sno));
        return Result.succ("删除成功",null);
    }

    @PutMapping()
    public Result update(Student stu){
        boolean flag = studentService.update(stu, new UpdateWrapper<Student>().eq("studentno",stu.getStudentno()));
        return Result.succ("更新成功",null);
    }

    @PostMapping()
    public Result save(Student stu){
        boolean flag = studentService.save(stu);
        return Result.succ("添加成功",null);
    }

    @GetMapping("/isExists/{sno}")
    public Result isExists(@PathVariable("sno")String sno){
        int count = studentService.count(new QueryWrapper<Student>().eq("studentno", sno));
        return Result.succ(null,count);
    }

    @GetMapping(value = "/toExcel"/*,produces = "application/octet-stream"*/)
    public void toExcel(HttpServletResponse response) throws IOException, InterruptedException {
        List<Student> list = studentService.list();
        ExportParams params = new ExportParams("学生列表","学生列表", ExcelType.HSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params,Student.class,list);
        ServletOutputStream out = null;
        try {
            long s = System.currentTimeMillis();
            response.setHeader("Content-Type","application/octet-stream");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("学生列表"+s+".xls","utf-8"));
            out = response.getOutputStream();
            workbook.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (workbook != null) {
                workbook.write(out);
            }
            if (out != null) {
                out.close();
            }
        }
    }


}
