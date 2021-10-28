package cn.bdqn.service;

import cn.bdqn.entity.Subject;
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
public interface ISubjectService extends IService<Subject> {

    List<Subject> getAll();
}
