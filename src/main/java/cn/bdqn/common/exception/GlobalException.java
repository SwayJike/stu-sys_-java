package cn.bdqn.common.exception;

import cn.bdqn.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @title:GlobleException
 * @Author SwayJike
 * @Date:2021/9/4 15:51
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {RuntimeException.class})
    public Result handler(RuntimeException e){
        log.error("运行时异常....",e);
        return Result.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = {AccessDeniedException.class})
    public Result handler(AccessDeniedException e){
        log.error("没有权限访问");
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public Result handler(DataAccessException e){
        log.error("不允许执行该操作");
        return Result.fail("不允许执行该操作");
    }



    /*@ExceptionHandler(value = {UsernameNotFoundException.class})
    public Result handler(UsernameNotFoundException e){
        return Result.fail(e.getMessage());
    }*/
}
