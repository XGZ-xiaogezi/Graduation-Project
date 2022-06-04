package com.xgz.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xgz.common.Result;
import com.xgz.entity.Emp;
import com.xgz.entity.Meeting;
import com.xgz.service.EmpService;
import com.xgz.service.MeetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Resource
    private MeetingService meetingService;
    @Resource
    private EmpService empService;

    @GetMapping("/getMeeting")
    public Result getMeeting(@RequestParam String empno) {
        return Result.success(meetingService.getMeetingsAndSendName(empno));
    }

    //批量发布会议
    @GetMapping("/addMeeting")
    public Result addMeeting(@RequestParam String title,
                             @RequestParam String loc,
                             @RequestParam String time,
                             @RequestParam String empno,
                             @RequestParam String deptno) {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno",deptno);
        List<Emp> list = empService.list(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            Meeting meeting = new Meeting();
            meeting.setTitle(title);
            meeting.setLoc(loc);
            meeting.setTime(DateUtil.parse(time));
            meeting.setSendId(empno);
            meeting.setReceiveId(list.get(i).getEmpno());
            meetingService.save(meeting);
        }
        return Result.success();
    }
}
