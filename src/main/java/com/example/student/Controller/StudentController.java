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
        return new ApiResponse(" Student Addedd");
    }


    @GetMapping("/get-name/{index}") // return name by index
    public String getName( @PathVariable int index) {
        return students.get(index).getName();
//        for (Student student : students) {
//            if (student.getName().equals(name)) {
//                return getName(name);
//            }
//        } return name;

    }


    @GetMapping("/get-age/{index}") // return age by index
    public int getAge( @PathVariable int index ) {
        return students.get(index).getAge();
//        for (Student student : students) {
//            if (student.getAge() == age) {
//                return age;
//            }else {
//                return 0;
//            }
//        } return age;
    }

    @GetMapping("/get-degree/{index}") // return degree by index
    public String getDegree( @PathVariable int index ) {
        return students.get(index).getDegree();
//        for (Student student : students) {
//            if (degree.equals("bachelor") || degree.equals("diploma") || degree.equals("master")) {
//                return students.get(index).getDegree();
//            }
//        }
//        return degree;
    }

    @GetMapping("/get-status/{index}") // return True if graduated , return False if not graduates
    public String getStudy_Status( @PathVariable int index ) {
        for (Student student : students) {
            if (student.getStudy_status().equals("graduated")){
                return "true";
            } else if (student.getStudy_status().equals("not graduated")) {
                return "false";
            }
        }
        return null;
    }


}
