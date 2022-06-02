package com.test.fileTest;

import com.test.cloneTest.Car;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {

    public void fileCopy(String source,String targer){
        try {
            ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
            FileOutputStream fileOutputStream =new FileOutputStream(targer);
            FileInputStream fileInputStream =new FileInputStream(source);
            FileChannel out = fileOutputStream.getChannel();
            FileChannel in = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
            while (out.read(byteBuffer)!=-1){
                in.write(byteBuffer);
            }

        }catch (Exception e){

        }
    }

}
