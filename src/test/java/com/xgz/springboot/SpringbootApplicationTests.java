package com.xgz.springboot;

import cn.hutool.core.date.DateUtil;
import com.xgz.entity.Dk;
import com.xgz.entity.Meeting;
import com.xgz.mapper.MeetingMapper;
import com.xgz.service.DkService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private MeetingMapper meetingMapper;

    @Resource
    private DkService dkService;

    @Test
    void test() {
        List<Meeting> meetingsAndSendName = meetingMapper.getMeetingsAndSendName("0");
        for (Meeting meeting : meetingsAndSendName) {
            System.out.println(meeting);
        }
    }
    @Test
    void testDK(){
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
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println(time4);
        System.out.println(time5);
    }
}
