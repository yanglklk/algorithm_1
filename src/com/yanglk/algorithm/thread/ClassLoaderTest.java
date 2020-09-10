package com.yanglk.algorithm.thread;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    ClassLoader loader=new ClassLoader() {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            try {
                String filename = name.substring(name.lastIndexOf('.' )+1) + ".class";
                InputStream is = getClass().getResourceAsStream(filename);
                if (is == null)
                    return super.loadClass(name);

                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                throw  new RuntimeException(name);
            }
        }
    };

        Object object1=loader.loadClass("com.yanglk.algorithm.thread.ClassLoaderTest").newInstance();
        Object object2=ClassLoader.getSystemClassLoader().loadClass("com.yanglk.algorithm.thread.ClassLoaderTest").newInstance();
        System.out.println(object1.getClass());
        System.out.println(object2.getClass());
        System.out.println(object1 instanceof com.yanglk.algorithm.thread.ClassLoaderTest );
        System.out.println(object2 instanceof com.yanglk.algorithm.thread.ClassLoaderTest);



    }
}
