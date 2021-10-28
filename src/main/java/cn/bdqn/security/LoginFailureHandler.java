package cn.bdqn.security;

import cn.bdqn.common.lang.Result;
import cn.hutool.json.JSONUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @title:LoginFailureHandler
 * @Author SwayJike
 * @Date:2021/9/19 21:10
 * @Version 1.0
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        Result result = Result.fail(e.getMessage());
        writer.write(JSONUtil.toJsonStr(result));
        writer.flush();
        writer.close();
    }
}
