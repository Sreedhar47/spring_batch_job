package com.vsr.spring_batch_job.config;

import org.apache.poi.ss.usermodel.*;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsr.spring_batch_job.entity.MyRecord;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

public class ExcelItemReader implements ItemReader<MyRecord> {
	
    private final String filePath;
    private Iterator<Row> rowIterator;

    public ExcelItemReader(String filePath) throws Exception {
        this.filePath = filePath;
        init();
    }

    private void init() throws Exception {
        InputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);  // Read the first sheet
        rowIterator = sheet.iterator();  // Get row iterator
        rowIterator.next();  // Skip header row (ID, Name)
    }

    @Override
    public MyRecord read() {
    	System.out.println("read class");
        if (rowIterator != null && rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Assuming the first column is ID and the second column is Name
            int id = (int) row.getCell(0).getNumericCellValue();
            String name = row.getCell(1).getStringCellValue();
            return new MyRecord(id, name);
        }
        return null;  // Return null when there are no more rows
    }
}
