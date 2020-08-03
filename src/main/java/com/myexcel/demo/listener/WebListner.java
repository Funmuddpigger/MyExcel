package com.myexcel.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.myexcel.demo.domain.Student;
import com.myexcel.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope("prototype")
public class WebListner extends AnalysisEventListener<Student> {
    @Autowired
    StudentService studentService;

    //ArrayList<Student> students = new ArrayList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(WebListner.class);
    private static final int BATCH_COUNT = 5;
    List<Student> students = new ArrayList<Student>();
    //private StudentService studentService;

    public WebListner(StudentService studentService){
        super();
        this.studentService = studentService;
    }

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(student));
        students.add(student);
        if(students.size()  >= 2){
            //saveData();
            studentService.save(students);
            students.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //saveData();
        studentService.save(students);
        LOGGER.info("所有数据解析完成！");
    }
    /**
     * 加上存储数据库
     */

//    private void saveData() {
//        StudentService studentService = null;
//        LOGGER.info("{}条数据，开始存储数据库！", students.size());
//        for (Student student : students) {
//            System.out.println("list里的："+student);
//            studentService.addStudent(students);
//        }
//        LOGGER.info("存储数据库成功！");
//    }

}
