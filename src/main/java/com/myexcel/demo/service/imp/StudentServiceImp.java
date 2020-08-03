package com.myexcel.demo.service.imp;

import com.myexcel.demo.dao.StudentDao;
import com.myexcel.demo.domain.Student;
import com.myexcel.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    //private StudentDao studentDao;

//    public void setStudentDao(StudentDao studentDao){
//        this.studentDao = studentDao;
//    }
    @Autowired
    private StudentDao studentDao;

    @Override
    public void save(List<Student> students) {
        studentDao.save(students);
    }

//    @Override
////    public int addStudent(Student student) {
////        int i = studentDao.save(student);
////        System.out.println(i);
////        System.out.println(student);
////        return i;
////    }

}
