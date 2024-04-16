package org.example.relationsex1.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.relationsex1.API.ApiResponse;
import org.example.relationsex1.Model.Student;
import org.example.relationsex1.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(studentService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid  Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("Student Updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student Deleted"));
    }
    @PutMapping("/assign/{student_id}/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id , @PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Student Assigned to Course"));
    }

    @PutMapping("/major/{id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id , @PathVariable String major){
        studentService.changeMajor(id,major);
        return ResponseEntity.status(200).body(new ApiResponse("Student Major Changed"));
    }
}
