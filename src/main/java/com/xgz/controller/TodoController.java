package com.xgz.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xgz.common.Result;
import com.xgz.entity.Emp;
import com.xgz.entity.Meeting;
import com.xgz.entity.Todo;
import com.xgz.service.EmpService;
import com.xgz.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Resource
    private TodoService todoService;
    @Resource
    private EmpService empService;

    //查询状态为0的并分页
    @GetMapping("/page")
    public Result page(@RequestParam Integer pageNum,
                       @RequestParam Integer pageSize,
                       @RequestParam String empno){
        QueryWrapper<Todo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_abled",0);
        queryWrapper.eq("receive_id",empno);
        return Result.success(todoService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }

    //更改工作任务状态为1
    @GetMapping("/updateTodo")
    public Result updateTodo(@RequestParam String empno,
                             @RequestParam Integer id){
        UpdateWrapper<Todo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("receive_id",empno);
        updateWrapper.eq("id",id);
        Todo todo = new Todo();
        todo.setIsAbled(1);
        if (todoService.update(todo,updateWrapper)){
            return  Result.success(todoService.update(todo,updateWrapper));
        }else {
            return Result.error();
        }
    }
    //批量发布会议
    @GetMapping("/addTodo")
    public Result addMeeting(@RequestParam String body,
                             @RequestParam String createTime,
                             @RequestParam String lastTime,
                             @RequestParam String createId,
                             @RequestParam String deptno) {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno",deptno);
        List<Emp> list = empService.list(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            Todo todo = new Todo();
            todo.setBody(body);
            todo.setCreateTime(DateUtil.parse(createTime));
            todo.setLastTime(DateUtil.parse(lastTime));
            todo.setCreateId(createId);
            todo.setReceiveId(list.get(i).getEmpno());
            todo.setIsAbled(0);
            todoService.save(todo);
        }
        return Result.success();
    }

}
