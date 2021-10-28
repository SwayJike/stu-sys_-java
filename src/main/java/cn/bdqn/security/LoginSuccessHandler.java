package cn.bdqn.security;

import cn.bdqn.common.lang.Result;
import cn.bdqn.util.JwtUtils;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @title:LoginSuccessHandler
 * @Author SwayJike
 * @Date:2021/9/19 21:21
 * @Version 1.0
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //生成jwt,放到请求头中
        String jwt = jwtUtils.generateToken(authentication.getName());
        response.setHeader(jwtUtils.getHeader(),jwt);
        Result result = Result.succ(200,"登录成功","");
        writer.write(JSONUtil.toJsonStr(result));
        writer.flush();
        writer.close();
    }
}
