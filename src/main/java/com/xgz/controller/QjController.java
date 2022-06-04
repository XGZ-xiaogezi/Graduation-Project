package com.xgz.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xgz.common.Result;
import com.xgz.entity.Qj;
import com.xgz.service.QjService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/qj")
public class QjController {

    @Resource
    private QjService qjService;

    @GetMapping("/addQj")
    public Result addQj(@RequestParam String empno,
                        @RequestParam String ename,
                        @RequestParam String deptno,
                        @RequestParam String createTime,
                        @RequestParam String endTime,
                        @RequestParam String description){
        //把请求参数插入数据库
        Qj qj = new Qj();
        qj.setEmpno(empno);
        qj.setEname(ename);
        qj.setDeptno(deptno);
        qj.setCreateTime(DateUtil.parse(createTime));
        qj.setEndTime(DateUtil.parse(endTime));
        qj.setDescription(description);
        qj.setIsAbled(0);
        qjService.save(qj);
        return Result.success();
    }

    @GetMapping("/page")
    public Result getQj(@RequestParam String empno,
                        @RequestParam Integer pageSize,
                        @RequestParam Integer pageNum){
        QueryWrapper<Qj> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("empno",empno);
        queryWrapper.orderByDesc("create_time");
        return Result.success(qjService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }

    @GetMapping("/delete")
    public Result deleteQj(@RequestParam Integer id){
        qjService.removeById(id);
        return Result.success();
    }

    @GetMapping("/update")
    public Result updateQj(@RequestParam Integer id,
                           @RequestParam String empno,
                           @RequestParam String createTime,
                           @RequestParam String endTime,
                           @RequestParam String description){
        Qj qj = qjService.getById(id);
        qj.setEmpno(empno);
        qj.setCreateTime(DateUtil.parse(createTime));
        qj.setEndTime(DateUtil.parse(endTime));
        qj.setDescription(description);
        qjService.updateById(qj);
        return Result.success();
    }
    //请假审批通过
    @GetMapping("/pass")
    public Result pass(@RequestParam Integer id){
        Qj qj = qjService.getById(id);
        qj.setIsAbled(1);
        qjService.updateById(qj);
        return Result.success();
    }
    //请假审批不通过
    @GetMapping("/unpass")
    public Result unpass(@RequestParam Integer id){
        Qj qj = qjService.getById(id);
        qj.setIsAbled(2);
        qjService.updateById(qj);
        return Result.success();
    }
    //查询当前部门待审批的请假
    @GetMapping("/getQjbyDeptno")
    public Result getQjbyDeptno(@RequestParam String deptno,
                                @RequestParam Integer pageSize,
                                @RequestParam Integer pageNum){
        QueryWrapper<Qj> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno",deptno);
        queryWrapper.orderByDesc("create_time");
        queryWrapper.eq("is_abled",0);
        return Result.success(qjService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }
}
