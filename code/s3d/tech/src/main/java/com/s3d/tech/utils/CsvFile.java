package com.s3d.tech.utils;

import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.List;

/**
 * @author  wind.chen
 */
public class CsvFile{
	private String fileFullPathName = null; 
	private File outFile;
	private CSVWriter csvWriter;
    private FileOutputStream fileOutputStream;
    private OutputStreamWriter outputStreamWriter;

	private void close(){
		try {
			csvWriter.close();
            this.outputStreamWriter.close();
            this.fileOutputStream.close();
		} catch (IOException e) { 
			throw new RuntimeException("Close file failed.", e.getCause());
		}
	}
	
	private void initFileName(String path,String fileName){
		String uploadPath = path.replaceAll("\\*", "/");  
	    if(!uploadPath.endsWith("/")){  
	        uploadPath+="/";  
	    }
        this.fileFullPathName = uploadPath + fileName;
	}
	
	private void initFile(String filePath,String fileName){
		if(StringUtils.isBlank(fileName) || StringUtils.isBlank(filePath)){
			throw new RuntimeException("Failed to create csv for file Name or file path  is wrong! ");
		}
		this.initFileName(filePath, fileName);
		
        outFile = new File(this.fileFullPathName);
        try {
            this.fileOutputStream = new FileOutputStream(outFile);
            this.outputStreamWriter = new OutputStreamWriter(this.fileOutputStream, "UTF-8");
			csvWriter = new CSVWriter(this.outputStreamWriter);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Create CSV File with UTF-8 Failed.", e.getCause());
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Create CSV File Failed.", e.getCause());
		}
	}
	
	public CsvFile(String filePath, String fileName){
		this.initFile(filePath, fileName);
	}

    /**
     * Add one row to csv file .
     * @param rowCol
     */
	public void addRowToFile(List<String> rowCol){
		if(rowCol==null || rowCol.size()==0){
			return ;
		}
        // write export file title 
        csvWriter.writeNext(rowCol.toArray(new String[rowCol.size()]));
	}

    /**
     * Add many rows to a csv file.
     * @param manyRows
     */
    public void addRowsToFile(List<List<String>> manyRows){
        if(manyRows == null || manyRows.size() == 0){
            return ;
        }
        for(List<String> oneRow : manyRows){
            this.addRowToFile(oneRow);
        }
    }

	public File getOutputFileAndClose(){
		this.close();
		return this.outFile;
	}
	
	public String getOutputFileNameAndClose(){
		this.close();
		return this.fileFullPathName;
	}

    public String getFileFullPathName() {
        return fileFullPathName;
    }

    public void setFileFullPathName(String fileFullPathName) {
        this.fileFullPathName = fileFullPathName;
    }
}
