package controllers;

import exceptions.AlreadyExistsException;
import models.Student;
import service.interfaces.IStudentService;

import java.util.List;

public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService){
        this.studentService = studentService;
    }

    public void saveStudent(Student student) throws AlreadyExistsException {
        Student studentFromDb = studentService.getByName(student.getName());

        if(studentFromDb != null){
            throw new AlreadyExistsException("Student already exists");
        }

        studentService.save(student);
    }

    public Student getStudentByName(String name){
        return studentService.getByName(name);
    }

    public Student getStudentById(int id){
        return studentService.getById(id);
    }

    public List<Student> getAllStudents(){
        return studentService.getAll();
    }
}
