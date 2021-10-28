package cn.bdqn.controller;

import cn.bdqn.common.lang.Const;
import cn.bdqn.common.lang.Result;
import cn.bdqn.entity.Menu;
import cn.bdqn.entity.Role;
import cn.bdqn.entity.Student;
import cn.bdqn.mapper.RoleMapper;
import cn.bdqn.service.IMenuService;
import cn.bdqn.service.IRoleService;
import cn.bdqn.service.IStudentService;
import cn.bdqn.service.impl.RoleServiceImpl;
import cn.bdqn.util.RedisUtil;
import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.code.kaptcha.Producer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * @title:AuthController
 * @Author SwayJike
 * @Date:2021/9/19 19:00
 * @Version 1.0
 */
@RestController
public class AuthController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private Producer producer;

    //获得验证码
    @GetMapping("/captcha")
    public Result captcha() throws IOException {

        //生成key,code保存到redis
        String key = UUID.randomUUID().toString();
        String code = producer.createText();
        redisUtil.hset(Const.CAPTCHA_KEY,key,code,120);

        //把图片写到输出流
        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image,"png",outputStream);

        //将图片转成base64格式
        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/png;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray());

        //返回key和图片
        return Result.succ(200,
                null,
                MapUtil.builder()
                .put("key",key)
                .put("base64Img",base64Img)
                .build()
        );
    }

    //通过用户学号获得用户信息
    @GetMapping("/getAuthInfo")
    public Result getAuthInfo(Principal principal){
        return Result.succ(null,studentService.getOne(new QueryWrapper<Student>().eq("studentNo",principal.getName())));
    }

    //获得菜单列表
    @GetMapping("/getMenuList")
    public Result getMenuList(Principal principal){
        List<Integer> code_ids = studentService.getCodeIdBuSno(principal.getName());
        List<Integer> menuIds = roleService.getMenuIdByCodeId(code_ids);
        List<Menu> menus = menuService.getMenuList(menuIds);
        return Result.succ(null,menus);
    }

    //更新个人信息
    @PutMapping("/update")
    public Result updateStu(Student stu,Principal principal){
        studentService.update(stu, new UpdateWrapper<Student>().eq("studentno", principal.getName()));
        return Result.succ("修改成功",null);
    }

    @PutMapping("/updatePwd")
    public Result updatePwd(@RequestParam("oldPass") String pwd, @RequestParam("newPass") String newPwd , Principal principal){
        int count = studentService.count(new QueryWrapper<Student>().eq("loginpwd",pwd).eq("studentno",principal.getName()));
        if (count==0){
            return Result.fail("您输入的密码不正确");
        }
        boolean update = studentService.update().set("loginpwd", newPwd).eq("studentno", principal.getName()).update();
        if (update){
            return Result.succ("修改成功",null);
        }
        return Result.fail("修改失败");
    }

}
