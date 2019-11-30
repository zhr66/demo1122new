package com.mybatisplus.demo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.demo.entity.Student;
import com.mybatisplus.demo.mapper.StudentMapper;
import com.mybatisplus.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl <StudentMapper, Student> implements StudentService  {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentById(Integer id) {

        QueryWrapper<Student> entityWrapper = new QueryWrapper<>();
        entityWrapper.eq("id", id);

       Student student= this.getOne(entityWrapper);
       return  student;
    }

    @Override
    public List<Student> findStudentAll() {
        QueryWrapper<Student> entityWrapper = new QueryWrapper<>();
        List<Student> student= this.list();
         return  student;
    }

    @Override
    public boolean delet(Serializable id) {
        boolean num = this.removeById(id);
        return num;

    }

    @Override
    public int insert(Integer id, String name, String sex, int age) {
        Student student = new Student(id , name, sex, age);
        int num = studentMapper.insert(student);
        return num;

    }

    @Override
    public int updateId(Integer id, String name, String sex, int age) {
        Student student = new Student(id , name, sex, age);
        int num = studentMapper.updateById(student);
        return num;
    }

    @Override
    public Student selectOne(String name) {
        QueryWrapper<Student> entityWrapper = new QueryWrapper<>();
        entityWrapper.eq("name", name);

        Student student= this.getOne(entityWrapper);
        return  student;
    }


}
