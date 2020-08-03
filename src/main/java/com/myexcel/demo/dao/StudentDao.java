package com.myexcel.demo.dao;


import com.myexcel.demo.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface StudentDao {
    int save(@Param("students") List<Student> students);
}
