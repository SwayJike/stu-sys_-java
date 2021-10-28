package cn.bdqn.service;

import cn.bdqn.entity.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-19
 */
public interface IResultService extends IService<Result> {

    List<Result> getAll(int id);
}
