package com.xgz.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xgz.common.Result;
import com.xgz.entity.Dk;
import com.xgz.entity.Emp;
import com.xgz.service.DkService;
import com.xgz.service.EmpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Resource
    private DkService dkService;
    @Resource
    private EmpService empService;

    @GetMapping("/getDkInfo")
    public Result getDkInfo() {
        int time1 = 0;
        int time2 = 0;
        int time3 = 0;
        int time4 = 0;
        int time5 = 0;
        List<Dk> list = dkService.list();
        for (Dk dk : list) {
            if (DateUtil.format(dk.getTime(),"HH:mm").compareTo("07:30")>=0&&DateUtil.format(dk.getTime(),"HH:mm").compareTo("08:00")<=0){
                time1++;
            }else if (DateUtil.format(dk.getTime(),"HH:mm").compareTo("08:00")>=0&&DateUtil.format(dk.getTime(),"HH:mm").compareTo("08:30")<=0){
                time2++;

            }else if (DateUtil.format(dk.getTime(),"HH:mm").compareTo("08:30")>=0&&DateUtil.format(dk.getTime(),"HH:mm").compareTo("09:00")<=0){
                time3++;
                System.out.println(DateUtil.format(dk.getTime(),"HH:mm").toString());
            }else if (DateUtil.format(dk.getTime(),"HH:mm").compareTo("09:00")>=0&&DateUtil.format(dk.getTime(),"HH:mm").compareTo("09:30")<=0){
                time4++;
            }else {
                time5++;
            }
        }
        return Result.success(new int[]{time1,time2,time3,time4,time5});
    }

    @GetMapping("/getTodayDk")
    public Result getTodayDk() {
        QueryWrapper<Dk> queryWrapper = new QueryWrapper<>();
        //查询今天的打卡记录
        queryWrapper.ge("time", DateUtil.beginOfDay(new Date()));
        queryWrapper.le("time", DateUtil.endOfDay(new Date()));
        int count = (int) dkService.count(queryWrapper);
        return Result.success(count);
    }
    //查询员工总数
    @GetMapping("/getEmpCount")
    public Result getEmpCount() {
        int count = (int) empService.count();
        return Result.success(count);
    }
    //查询各部门人数
    @GetMapping("/getDeptCount")
    public Result getDeptCount(){
        int count1 = (int) empService.count(new QueryWrapper<Emp>().eq("deptno","00"));
        int count2 = (int) empService.count(new QueryWrapper<Emp>().eq("deptno","01"));
        int count3 = (int) empService.count(new QueryWrapper<Emp>().eq("deptno","02"));
        int count4 = (int) empService.count(new QueryWrapper<Emp>().eq("deptno","03"));
        int count5 = (int) empService.count(new QueryWrapper<Emp>().eq("deptno","04"));
        return Result.success(new int[]{count1,count2,count3,count4,count5});
    }
    //查询当月打卡次数
    @GetMapping("/getMonthDkCount")
    public Result getMonthDkCount(@RequestParam String empno){
        int count = (int) dkService.count(new QueryWrapper<Dk>().eq("empno",empno).ge("time",DateUtil.beginOfMonth(new Date())));
        return Result.success(count);
    }
}
