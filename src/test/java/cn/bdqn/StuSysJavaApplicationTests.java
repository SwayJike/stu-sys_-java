package cn.bdqn;

import cn.bdqn.entity.*;
import cn.bdqn.mapper.*;
import cn.bdqn.random.*;
import cn.bdqn.service.IStudentService;
import cn.bdqn.service.ISubjectService;
import cn.bdqn.service.impl.MenuServiceImpl;
import cn.bdqn.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.sql.DataSource;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class StuSysJavaApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private StudentRoleMapper studentRoleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private RedisUtil redis;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private ISubjectService subjectService;

    @Test
    void contextLoads() {
        PageHelper.startPage(2,1);
        gradeMapper.selectList(new QueryWrapper<>()).forEach(System.out::println);
    }

    @Test
    void test01(){
        redis.set("k1","Redis连接成功",60);
        System.out.println(redis.get("k1"));
    }

    @Test
    void test02() throws IOException {
        BufferedImage image = defaultKaptcha.createImage(defaultKaptcha.createText());
        //ImageIO.write(image,"png", new FileOutputStream(new File("F:\\Web_WorkSpace\\captcha")));
        System.out.println(image);
    }

    //添加学生表数据
    @Test
    void test03() throws Exception {
        for (int i = 1; i <= 500; i++) {
            Student student = new Student("s"+(10000+i),null, RandomChinese.nextRandomLength(2,3), RandomSex.next(),RandomNum.next(1, 3), RandomPhoneNum.nextPhoneNum(), RandomAddress.nextAddress(),RandomDateTime.nextDate("2000-01-01","2005-01-01"),RandomEmail.nextEmail());
            studentMapper.insert(student);
        }

    }

    //添加成绩表数据
    @Test
    void test04() throws Exception {
        Date[] dates = new Date[14];
        for (int i = 0; i < 14; i++) {
            dates[i] = RandomDateTime.nextDate("2021-06-01","2021-08-01");
        }
        for (int i = 0; i < 600; i++) {
            int next = RandomNum.next(1, 14);
            Result result = new Result(null,"s"+(10000+RandomNum.next(1,500)), next,RandomNum.next(30,100),dates[next-1],null,null);
            resultMapper.insert(result);
        }
    }

    //给部分学生添加角色
    @Test
    void test05(){
        for (int i = 1; i <= 5; i++) {
            //i+=RandomNum.next(0,5);
            StudentRole studentRole = new StudentRole("s"+(10000+i),1);
            studentRoleMapper.insert(studentRole);
        }
    }

    @Test
    void test06(){
        System.out.println(studentMapper.getCodeIdBySno("s10005"));
    }

   /* @Test
    void test07(){
        List list = new ArrayList();
        list.add(1);
        System.out.println(roleMapper.getMenuIdByCodeId(list));
        //menuMapper.getMenuList(null).forEach(System.out::println);
    }*/

    @Test
    void test08(){
        int count = studentService.count(new QueryWrapper<Student>().eq("studentno", "s102221"));
        System.out.println(count);
    }

    @Test
    void test09(){
        boolean update = studentService.update().set("loginpwd", 123).eq("studentno", "s10001").update();
        System.out.println(update);
    }

    @Test
    void test10(){
        System.out.println(resultMapper.getAll(1));
    }

}
