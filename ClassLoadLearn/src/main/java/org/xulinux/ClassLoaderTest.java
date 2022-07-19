package org.xulinux;

import java.io.IOException;
import java.io.InputStream;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/19 上午11:54
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader1 = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + "class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }


                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        ClassLoader classLoader2 = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + "class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }


                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };


        try {
            Object obj1 = classLoader1.loadClass("org.xulinux.ClassLoaderTest").newInstance();
            Object obj2 = classLoader2.loadClass("org.xulinux.ClassLoaderTest").newInstance();

            System.out.println(obj1.getClass());
            System.out.println(obj2.getClass());
            System.out.println(obj1 == obj2);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
