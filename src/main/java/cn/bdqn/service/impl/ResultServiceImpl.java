package cn.bdqn.service.impl;

import cn.bdqn.entity.Result;
import cn.bdqn.mapper.ResultMapper;
import cn.bdqn.service.IResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SwayJike
 * @since 2021-09-19
 */
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result> implements IResultService {

    @Autowired
    private ResultMapper resultMapper;

    @Override
    public List<Result> getAll(int id) {
        return resultMapper.getAll(id);
    }
}
