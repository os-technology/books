package com.gena.office;

import java.io.File;
/**
 * @author code
 * @Title: FileDeleteTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/7/615:38
 */
public class FileDeleteTest {
    //É¾³ıÎÄ¼şºÍÄ¿Â¼
    public void clearFiles(String workspaceRootPath){
        File file = new File(workspaceRootPath);
        if(file.exists()){
            deleteFile(file);
        }
    }
    public void deleteFile(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0; i<files.length; i++){
                deleteFile(files[i]);
            }
        }
        file.delete();
    }
}
