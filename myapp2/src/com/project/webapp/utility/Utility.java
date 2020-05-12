package com.project.webapp.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public interface Utility {

	static String getToken(){
		String csrfValue = RandomStringUtils.random(10, 0, 0, true, true, null, new SecureRandom());
		return csrfValue;
	}
	static String convertInCSV(File inputFile, File outputFile) {
		
		String  result = "failure";
		try(FileOutputStream fos = new FileOutputStream(outputFile)) {
			Workbook wbook = WorkbookFactory.create(new FileInputStream(inputFile));
			Sheet sheet = wbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();
			StringBuilder data = new StringBuilder();
			
			int rowCount = 0;
			boolean flag = false;
			
			for (Row row : sheet) {
                int lastColumn = Math.max(row.getLastCellNum(),
                        row.getPhysicalNumberOfCells());

                for (int i = 0; i < lastColumn; i++) {
                    Cell c = row.getCell(i, Row.RETURN_BLANK_AS_NULL);
                    String cellValue = (dataFormatter.formatCellValue(c)
                            .replace("\r", "")).replace("\n", "");

                    if (i == 0 && StringUtils.isBlank(cellValue)) {
                        flag = true;
                        break;
                    }

                    if (c == null) {
                        data.append("" + ",");
                    } else if (i == 9) {
                        data.append("\"" + cellValue + "\"" + ",");
                    } else {
                        data.append(cellValue + ",");
                    }

                }

                if (flag) {
                    break;
                }

                data.append("\r\n");
                rowCount++;
            }

            System.out.println("No. of rows: " + rowCount);

            fos.write(data.toString().getBytes());
            result = "success";
        } catch (Exception ex) {
        	System.out.println(ex);
        }

		return result;
	}

    static String getFilePath(String filePath,String fileName){
    	return filePath+"/"+fileName;
    }

}
