package com.RCOEM_B4.Nagpur.service;

import java.util.List;

import com.RCOEM_B4.Nagpur.entity.Student;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student saveStudent(Student student);

    public Student getById(int id);

    public void deleteStudentById(int id);
}