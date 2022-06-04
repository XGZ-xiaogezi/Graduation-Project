package com.xgz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

/**
 * 员工表
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("emp")
public class Emp {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String empno;

    private String ename;

    private String sex;

    private Integer age;

    private String password;

    private String job;

    private String sal;

    private String mgr;

    private String deptno;

    private String avatarUrl;

    private String role;

    private String email;

    private String address;

}
