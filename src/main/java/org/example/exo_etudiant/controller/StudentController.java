package org.example.exo_etudiant.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.exo_etudiant.model.Student;
import org.example.exo_etudiant.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Controller
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @RequestMapping("/list")
    public String listStudents(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/form")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/form")
    public String submitContact(@ModelAttribute("student") Student student) {
        studentService.createStudent(student);
        return "redirect:/list";
    }

    @GetMapping("/search/{id}")
    public String showContact(@PathVariable Long id , Model model) {
        Student student = studentService.findById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "detail";
        } else {
            return "home";
        }
    }

    @GetMapping("/search")
    public String showContact(@RequestParam (value="studentFirstName" )String name, Model model) {
        Student student = studentService.findStudentByName(name);
        if (student != null) {
            model.addAttribute("student", student);
            return "detail";
        } else {
            return "home";
        }
    }

    @GetMapping("/update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getAllStudents().stream().filter(s -> s.getId() == (id)).findFirst().orElse(null);
        if (student != null) {
            model.addAttribute("student", student);
            return "update";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/list";
    }
}