package com.xgz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xgz.entity.Dk;

import java.util.List;

public interface DkService extends IService<Dk> {

    List<Dk> getDk(String empno);

    Integer addDk(Dk dk);
}
