package com.myexcel.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.myexcel.demo.domain.Student;
import com.myexcel.demo.listener.StudentListener;
import com.myexcel.demo.listener.WebListner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    String path = "E:\\IDEA.JAVA\\MyExcel\\";

    @Test
    void contextLoads() {
    }
    @Test
    void testWrite07() throws Exception {
        Workbook workbook = new XSSFWorkbook();
        //sheet
        Sheet sheet = workbook.createSheet("MyExcel");
        //row
        Row row = sheet.createRow(0);
        //cell
        Cell cell = row.createCell(0);
        cell.setCellValue("Class");

        FileOutputStream fileOutputStream = new FileOutputStream(path + "MyCla.xlsx");
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        System.out.println("OK");

    }
    @Test
    void testRead07() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(path + "MyCla.xlsx");

        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //索引
        Sheet sheetAt = workbook.getSheetAt(0);
        //表名
        //workbook.getSheet();
        Row row = sheetAt.getRow(0);
        Cell cell = row.getCell(0);

        System.out.println(cell.getStringCellValue());
        fileInputStream.close();

    }
    @Test
    void testEasyExcel07(){
        //获取工作簿对象
        ExcelReaderBuilder readbook = EasyExcel.read("杭州黑马在线202003班学员信息表.xlsx",
                Student.class, new StudentListener());
        //从工作簿中获取工作表对象
        ExcelReaderSheetBuilder sheet = readbook.sheet();
        //读取工作表内容
        sheet.doRead();
    }
    @Test
    void testWriteEasyExcel07(){
        //工作簿对象
        ExcelWriterBuilder writebook = EasyExcel.write("杭州黑马在线202003班学员信息表-write.xlsx",
                Student.class);
        //工作表对象
        ExcelWriterSheetBuilder sheet = writebook.sheet(1);
        //准备数据
        List<Student> students = initData();
        //写入工作表
        sheet.doWrite(students);
    }
    private static List<Student> initData(){
        ArrayList<Student> students = new ArrayList<Student>();
        Student data = new Student();
        for (int i = 0; i < 10; i++) {
            data.setName("My0" + i);
            data.setGender("boy");
            data.setBirthday(new Date());
            students.add(data);
        }
        return students;
    }


}

