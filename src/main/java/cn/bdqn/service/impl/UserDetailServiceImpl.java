package cn.bdqn.service.impl;

import cn.bdqn.entity.Student;
import cn.bdqn.mapper.StudentMapper;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @title:UserDetailService
 * @Author SwayJike
 * @Date:2021/9/4 18:20
 * @Version 1.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if(StrUtil.isEmpty(s)){
            throw new RuntimeException("学号不能为空....");
        }
        Student student;
        student = studentMapper.selectOne(new QueryWrapper<Student>().eq("StudentNo", s));
        if (student == null) {
            throw new UsernameNotFoundException(String.format("%s这个学号不存在",s));
        }
        return new User(s,passwordEncoder.encode(student.getLoginpwd()),getGrantedAuthoritiesBySno(s));
    }

    //通过学号获得角色信息并添加到权限认证列表
    public List<GrantedAuthority> getGrantedAuthoritiesBySno(String sno){
        List<GrantedAuthority> authorities=new ArrayList<>();
        List<String> codeBySno = studentMapper.getCodeBySno(sno);
        codeBySno.forEach((code)->{
            authorities.add(new SimpleGrantedAuthority(code));
        });
        return authorities;
    }


}
