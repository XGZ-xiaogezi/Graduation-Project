package com.xgz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xgz.entity.Todo;
import com.xgz.mapper.TodoMapper;
import com.xgz.service.TodoService;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl extends ServiceImpl<TodoMapper, Todo> implements TodoService {
}
