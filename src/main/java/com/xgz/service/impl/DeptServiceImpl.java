package com.xgz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xgz.entity.Dept;
import com.xgz.mapper.DeptMapper;
import com.xgz.service.DeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}
