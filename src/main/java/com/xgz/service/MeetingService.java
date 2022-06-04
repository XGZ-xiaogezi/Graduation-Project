package com.xgz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xgz.entity.Meeting;

import java.util.List;

public interface MeetingService extends IService<Meeting> {

    List<Meeting> getMeetingsAndSendName(String empno);

}
