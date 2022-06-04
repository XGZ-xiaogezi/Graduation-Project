package com.xgz.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dept")
public class Dept {
    @TableId(value = "deptno")
    private String deptno;

    private String dname;

    private String loc;

}
