package com.xgz.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xgz.common.Result;
import com.xgz.entity.Dk;
import com.xgz.mapper.DkMapper;
import com.xgz.service.DkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/dk")
public class DkController {

    @Resource
    private DkService dkService;

    @GetMapping("/get")
    public Result getDk(@RequestParam String empno){
        System.out.println(dkService.getDk(empno));
        return Result.success(dkService.getDk(empno));
    }

    @GetMapping("/find")
    public Result findDk(@RequestParam("start") String star,
                         @RequestParam("end") String end,
                         @RequestParam("empno") String empno) {
        DateUtil.parse(star,"yyyy-MM-dd HH:mm:ss");
        DateUtil.parse(end,"yyyy-MM-dd HH:mm:ss");
        QueryWrapper<Dk> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("empno",empno);
        queryWrapper.between("time",star,end);
        if (dkService.getOne(queryWrapper)!=null){
            System.out.println(dkService.getOne(queryWrapper));
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @GetMapping("/addDk")
    public Result addDk(@RequestParam String empno,
                        @RequestParam String time){
        QueryWrapper<Dk> queryWrapper = new QueryWrapper<>();
        Dk dk = new Dk();
        dk.setEmpno(empno);
        dk.setTime(DateUtil.parse(time,"yyyy-MM-dd HH:mm:ss"));
        dk.setStatus(1);
        System.out.println(DateUtil.parse(time,"yyyy-MM-dd HH:mm:ss"));
        if (dkService.addDk(dk) == 1){
            return Result.success();
        }else {
            return Result.error();
        }
    }

}
