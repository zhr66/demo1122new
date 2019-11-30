package com.mybatisplus.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatisplus.demo.entity.Student;

import java.io.Serializable;
import java.util.List;

public interface StudentService extends IService<Student> {
    // 按id查询
    Student findStudentById(Integer id);
    // 查询所有
    List<Student> findStudentAll();
    // 按id删除
    boolean delet(Serializable id);
    // 插入
    int insert(Integer id, String name, String sex, int age);
    //修改
    int updateId(Integer id, String name, String sex, int age);
    //查询一条实体
    Student selectOne(String name);


}
