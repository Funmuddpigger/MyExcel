package com.myexcel.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.myexcel.demo.domain.Student;
import com.myexcel.demo.listener.WebListner;
import com.myexcel.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("student")
public class MyExcelController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyExcelController.class);
//    @Autowired
//    WebListner webListner;
    //private WebListner webListner;
    @Autowired
    StudentService studentService;

    @RequestMapping("read")
    @ResponseBody
    public String readexcel(@RequestParam(value = "uploadExcel") MultipartFile uploadExcel) {
        InputStream in = null;
        ExcelReader excelReader = null;
        try {
//            ExcelReaderBuilder readbook = EasyExcel.read(uploadExcel.getInputStream(),
//                    Student.class, webListner);

            in = uploadExcel.getInputStream();
            excelReader = EasyExcel.read(in,
                    Student.class, new WebListner(studentService)).build();
            //ExcelReaderSheetBuilder sheet = readbook.sheet();
            //sheet.doRead();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        } finally {
            close(in);

        }
    }
    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                LOGGER.error("Close io stream error", e);
            }
        }
    }
}
