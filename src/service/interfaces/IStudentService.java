package service.interfaces;

import models.Student;

public interface IStudentService extends IBaseService<Student>{
    Student getByName(String name);
}
