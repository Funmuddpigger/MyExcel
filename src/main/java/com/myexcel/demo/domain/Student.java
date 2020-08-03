package com.myexcel.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@NoArgsConstructor
@Data
public class Student {
    @ExcelProperty(value = "id",index = 0)
    private String id;

    @ExcelProperty(value = "name",index = 1)
    private String name;

    //@DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "birthday",index = 2)
    private Date birthday;

    @ExcelProperty(value = "gender",index = 3)
    private String gender;
    //@ExcelProperty("ID")


}
