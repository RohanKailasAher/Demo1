package com.DataProviders;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SchoolTest {
    @DataProvider(name = "studentData")
    public Iterator<Object[]> studentData() throws IOException {
        String filePath = "C:\\Users\\user\\Desktop\\student_details.xlsx";
        FileInputStream excelFile = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        List<Object[]> data = new ArrayList<>();

        for (Row row : sheet) {
            if (row == null || row.getRowNum() == 0) {
                continue;
            }

            Cell nameCell = row.getCell(0);
            Cell ageCell = row.getCell(1);

            if (nameCell == null || ageCell == null) {
                continue;
            }

            String name = nameCell.getStringCellValue();
            int age = (int) ageCell.getNumericCellValue();

            data.add(new Object[]{name, age});
        }

        workbook.close();
        excelFile.close();

        return data.iterator();
    }

    @Test(dataProvider = "studentData")
    public void testAddStudent(String name, int age) {
        // Print the student's name and age
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}
