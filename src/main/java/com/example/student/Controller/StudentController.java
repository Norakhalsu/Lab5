package com.example.student.Controller;


import com.example.student.Api.ApiResponse;
import com.example.student.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("/get") // return Array of Students
    public ArrayList<Student> getStudent() {
        return students;
    }

    @PostMapping("/add") // creat new Student
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse(" Student Addedd successfully");
    }

    @DeleteMapping("/delete/{index}")// delete student
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse(" Student Deleted successfully");
    }

    @PutMapping("/update/{index}") // update student
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse(" Student Updated successfully");
    }

    @GetMapping("/get-name/{index}") // return name of student by index
    public String getName(@PathVariable int index) {
        return students.get(index).getName();

//        for (Student student : students) {
//            if (student.getName().equals(name)) {
//                return getName(name);
//            }
//        } return name;
    }

    @GetMapping("/get-age/{index}") // return age of student by index
    public int getAge(@PathVariable int index) {
        return students.get(index).getAge();
    }

    @GetMapping("/get-degree/{index}") // return degree of student by index
    public String getDegree(@PathVariable int index) {
        return students.get(index).getDegree();
//        for (Student student : students) {
//            if (degree.equals("bachelor") || degree.equals("diploma") || degree.equals("master")) {
//                return students.get(index).getDegree();
//            }}
//        return degree;
    }

    @GetMapping("/get-status/{index}") // return True if graduated , return False if not graduates by index
    public String getStudy_Status(@PathVariable int index) {

        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            if (student.getStudy_status().equals("not graduated")) {
                return "false";
            }
            if (student.getStudy_status().equals("graduated")) {
                return "true";
            }
        }
        return "invalid index";
    }


}
