package com.xgz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xgz.common.Constants;
import com.xgz.entity.Emp;
import com.xgz.entity.dto.EmpDto;
import com.xgz.entity.dto.PasswordDto;
import com.xgz.exception.ServiceException;
import com.xgz.mapper.EmpMapper;
import com.xgz.service.EmpService;
import com.xgz.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    private static final Log LOG = Log.get();

    @Resource EmpMapper empMapper;

    @Override
    public EmpDto login(EmpDto empDto) {
        Emp one = getEmpInfo(empDto);
        if ( one != null){
            BeanUtil.copyProperties(one,empDto,true);
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            empDto.setToken(token);
            return empDto;
        }else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public void updatePassword(PasswordDto passwordDto) {
        int update = empMapper.updatePassword(passwordDto);
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "密码错误");
        }
    }

    private Emp getEmpInfo(EmpDto empDto) {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("empno", empDto.getEmpno());
        queryWrapper.eq("password", empDto.getPassword());
        Emp one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }

}
