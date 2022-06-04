package com.xgz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xgz.entity.Dk;
import com.xgz.mapper.DkMapper;
import com.xgz.service.DkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DkServiceImpl extends ServiceImpl<DkMapper, Dk> implements DkService {

    @Resource
    private DkMapper dkMapper;

    @Override
    public List<Dk> getDk(String empno) {
        return dkMapper.selectByEmpnoDk(empno);
    }

    @Override
    public Integer addDk(Dk dk) {

        return dkMapper.insert(dk);
    }
}
