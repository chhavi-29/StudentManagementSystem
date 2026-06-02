package com.RCOEM_B4.Nagpur.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RCOEM_B4.Nagpur.entity.Student;
import com.RCOEM_B4.Nagpur.repository.StudentRepository;

@Service
public class ServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {

        List<Student> list = studentRepository.findAll();

        return list;
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student getById(int id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudentById(int id) {

        studentRepository.deleteById(id);
    }
}
