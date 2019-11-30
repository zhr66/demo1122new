package com.mybatisplus.demo.controller;

import com.mybatisplus.demo.config.jwt.JwtUtils;
import com.mybatisplus.demo.entity.Student;
import com.mybatisplus.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentservice;
    @GetMapping(value = "/queryById")
    public Student findById(@RequestParam(value = "id") Integer id ) {

        return studentservice.findStudentById(id);
    }
    @GetMapping(value = "/queryAll")
    public List<Student> findAll() {

        return studentservice.findStudentAll();
    }
    @GetMapping(value = "/deleteById")
    public boolean deleteById(@RequestParam(value = "id") Integer id ) {

        return studentservice.delet(id);
    }
    @PostMapping(value = "/insert")
    public int insert(@RequestParam(value = "id") Integer id, @RequestParam(value = "name",required = false) String name, @RequestParam(value = "sex",required = false) String sex, @RequestParam(value = "age",required = false) int age) {
        return studentservice.insert(id, name, sex, age);

    }

    @PostMapping(value = "/update")
    public int update(@RequestParam(value = "id") Integer id, @RequestParam(value = "name",required = false) String name, @RequestParam(value = "sex",required = false) String sex, @RequestParam(value = "age",required = false) int age) {
        return studentservice.updateId(id, name, sex, age);

    }
    @GetMapping(value = "/queryOne")
    public Student query(@RequestParam(value = "name") String name) {
        return studentservice.selectOne(name);
    }

    @PostMapping(value = "/sign-in")
    public String  signIn(@RequestParam(value = "username") String username, @RequestParam(value = "password") Integer password){
      /*  //System.out.println("登录接口===="+ JSON.toJSONString(sysUser));
       if(username.equals("username")&&password.equals("password")) {
           String token= JwtUtils.getToken(username);
           System.out.println("生成token=="+token);
           //System.out.println("返回数据="+ResponseResult.e(ResponseCode.SIGN_IN_OK,((JwtToken) SecurityUtils.getSubject().getPrincipal()).getToken()));

           return token;

       }
       else {
           return "fail";
       }*/
      // 和数据库做验证
         Student student = studentservice.findStudentById(password);
          Student student2 = studentservice.selectOne(username);
        if(student == null || student2 == null) {
            return "fail";
        }
        else if(!student.equals(student2)) {
            return "fail";
        }
        else {
            String token= JwtUtils.getToken(username);
            return token;
        }

    }

    @GetMapping(value = "/check")
    public void check(String Token) throws ServletException {
        JwtUtils.checkToken(Token);

    }












}
