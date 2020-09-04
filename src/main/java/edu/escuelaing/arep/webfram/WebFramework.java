package edu.escuelaing.arep.webfram;

import edu.escuelaing.arep.handlers.HTMLHandler;
import spark.Request;
import spark.Response;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class WebFramework {


    public static String getPlain(String path){
        String totalPath = getPath(path);
        System.out.println(totalPath);
        String ans = null;
        try{
            HTMLHandler handler = new HTMLHandler(totalPath);
            ans = handler.getData();
        } catch (IOException e){
            ans = "MAPEO DE ARCHIVO INEXISTENTE |:(";
        }
        return ans;
    }

    public static byte[] getImage(String path) {
        File file = new File(getPath(path));
        int numOfBytes = (int) file.length();
        FileInputStream inFile  = null;
        byte[] fileInBytes = new byte[numOfBytes];
        try {
            inFile = new FileInputStream(getPath(path));
            inFile.read(fileInBytes);
        } catch (IOException e) {
            //
        }
        return fileInBytes;
    }

    public static String getPath(String path){
        return "src/main/resources/public"+path;
    }

}
