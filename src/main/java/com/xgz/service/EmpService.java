package com.xgz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xgz.entity.Emp;
import com.xgz.entity.dto.EmpDto;
import com.xgz.entity.dto.PasswordDto;

public interface EmpService extends IService<Emp> {

    EmpDto login(EmpDto empDto);

    void updatePassword(PasswordDto passwordDto);
}
