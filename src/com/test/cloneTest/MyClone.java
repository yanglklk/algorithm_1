package com.test.cloneTest;

import java.io.*;

public class MyClone {
    public MyClone() {
    }
    @SuppressWarnings("unchecked")
    public static  <T extends Serializable> T clone(T obj) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(obj);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return ((T) objectInputStream.readObject());
    }
}
