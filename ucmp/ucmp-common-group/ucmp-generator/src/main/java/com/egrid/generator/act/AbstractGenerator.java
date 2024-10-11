package com.egrid.generator.act;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public abstract class AbstractGenerator {

    protected File createFile(String path) {
        File file = new File(path);
        if(file.exists()) {
            file.delete();
        }
        if(!file.getParentFile().exists()) {  
            if(!file.getParentFile().mkdirs()) {  
                System.err.println("文件创建不成功");  
            }  
        }
        return file;
    }
    
    protected void writeFile(String fileContent, File file) {
        FileOutputStream fileOut = null;
        OutputStreamWriter outStream = null;
        BufferedWriter bw = null;
        try {
            fileOut = new FileOutputStream(file);
            outStream = new OutputStreamWriter(fileOut, "UTF-8");
            bw = new BufferedWriter(outStream);
            bw.write(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if(bw != null) {
                    bw.close();
                    bw = null;
                }
                if(outStream != null) {
                    outStream.close();
                    outStream = null;
                }
                if(fileOut != null) {
                    fileOut.close();
                    fileOut = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
