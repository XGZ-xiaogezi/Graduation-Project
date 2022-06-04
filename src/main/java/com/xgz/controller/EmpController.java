package com.xgz.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xgz.common.Constants;
import com.xgz.common.Result;
import com.xgz.entity.Emp;
import com.xgz.entity.dto.EmpDto;
import com.xgz.entity.dto.PasswordDto;
import com.xgz.service.EmpService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Resource
    private EmpService empService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody EmpDto empDto){
        String empno = empDto.getEmpno();
        String password = empDto.getPassword();
        if(StrUtil.isBlank(empno) || StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        EmpDto dto = empService.login(empDto);
        return Result.success(dto);
    }

    //根据姓名查询员工
    @GetMapping("/ename/{ename}")
    public Result findByEname(@PathVariable String ename) {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ename", ename);
        return Result.success(empService.getOne(queryWrapper));
    }
    //分页查询
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String ename,
                           @RequestParam(defaultValue = "") String email,
                           @RequestParam(defaultValue = "") String address) {

        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        if (!"".equals(ename)) {
            queryWrapper.like("ename", ename);
        }
        if (!"".equals(email)) {
            queryWrapper.like("email", email);
        }
        if (!"".equals(address)) {
            queryWrapper.like("address", address);
        }
        return Result.success(empService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(empService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(empService.removeByIds(ids));
    }

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        return Result.success(empService.saveOrUpdate(emp));
    }

    //查询所有role为ROLE_MGR的员工
    @GetMapping("/mgr")
    public Result findMgr() {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role", "ROLE_MGR");
        queryWrapper.or().eq("role", "ROLE_ADMIN");
        return Result.success(empService.list(queryWrapper));
    }
    //导出接口
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Emp> list = empService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id", "id");
        writer.addHeaderAlias("ename", "用户名");
        writer.addHeaderAlias("empno", "员工编号");
        writer.addHeaderAlias("sex", "性别");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("password", "密码");
        writer.addHeaderAlias("job", "职位");
        writer.addHeaderAlias("sal", "薪水");
        writer.addHeaderAlias("mgr", "领导");
        writer.addHeaderAlias("deptno", "部门编号");
        writer.addHeaderAlias("avatarUrl", "头像");
        writer.addHeaderAlias("email", "邮箱");
        writer.addHeaderAlias("role", "角色");
        writer.addHeaderAlias("address", "地址");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("员工信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }
//导入接口
    @PostMapping("/import")
    public Result imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
//        List<User> list = reader.readAll(User.class);

        // 方式2：忽略表头的中文，直接读取表的内容
        List<List<Object>> list = reader.read(1);
        List<Emp> emps = CollUtil.newArrayList();
        for (List<Object> row : list) {
            Emp emp = new Emp();
            emp.setEname(row.get(0).toString());
            emp.setEmpno(row.get(1).toString());
            emp.setSex(row.get(2).toString());
            emp.setAge(Integer.valueOf(row.get(3).toString()));
            emp.setPassword(row.get(4).toString());
            emp.setJob(row.get(5).toString());
            emp.setSal(row.get(6).toString());
            emp.setMgr(row.get(7).toString());
            emp.setDeptno(row.get(8).toString());
            emp.setAvatarUrl(row.get(9).toString());
            emp.setEmail(row.get(10).toString());
            emp.setRole(row.get(11).toString());
            emp.setAddress(row.get(12).toString());
            emp.setId(null);
            emps.add(emp);
        }
        empService.saveBatch(emps);
        return Result.success(true);
    }
    //分页查询本部门员工
    @GetMapping("/pagebydept")
    public Result pagebyDept(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String ename,
                           @RequestParam(defaultValue = "") String email,
                           @RequestParam(defaultValue = "") String address,
                             @RequestParam String deptno){

        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno",deptno);
        if (!"".equals(ename)) {
            queryWrapper.like("ename", ename);
        }
        if (!"".equals(email)) {
            queryWrapper.like("email", email);
        }
        if (!"".equals(address)) {
            queryWrapper.like("address", address);
        }
        return Result.success(empService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
    @PostMapping("/password")
    public Result password(@RequestBody PasswordDto passwordDto) {
        empService.updatePassword(passwordDto);
        return Result.success();
    }
}
