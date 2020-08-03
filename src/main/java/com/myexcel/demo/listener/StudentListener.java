package com.myexcel.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myexcel.demo.domain.Student;

public class StudentListener extends AnalysisEventListener<Student> {
    /**
     *  每读取一行,都会调用一次invoke,在invoke里可以操作使用读取到的数据
     * @param student  每次读取到的数据封装对象
     * @param analysisContext
     */
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        System.out.println("student="+student);
    }

    /**
     *  读取完整个文档之后调用的方法
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
