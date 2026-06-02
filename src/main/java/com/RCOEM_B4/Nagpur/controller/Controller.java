package com.RCOEM_B4.Nagpur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.RCOEM_B4.Nagpur.entity.Student;
import com.RCOEM_B4.Nagpur.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    public StudentService service;

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {

        service.deleteStudentById(id);

        return "redirect:/students";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("students") Student student) {

        Student existingStudent = service.getById(id);

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        service.saveStudent(existingStudent);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {

        model.addAttribute("student", service.getById(id));

        return "edit-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {

        service.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        Student student = new Student();

        model.addAttribute("student", student);

        return "create-student";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){

        model.addAttribute("students", service.getAllStudents());

        return "students";
    }

    @GetMapping("/home")
    public String home() {

        return "home";
    }
}