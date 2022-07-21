package org.linux;

import org.xulinux.UseInternal;

import java.io.*;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/21 上午9:28
 */
public class TestForJarFile {
    public static void main(String[] args) {
        URL url = TestForJarFile.class.getResource("/APIModule-1.0-SNAPSHOT.jar");

        System.out.println(url);

        try {
            JarFile jarFile = new JarFile(url.getFile());
            JarEntry jarEntry = jarFile.getJarEntry("Internal-1.0-SNAPSHOT.jar");

            InputStream is = jarFile.getInputStream(jarEntry);

            File tempJar = new File("src/tempjar.jar");

            OutputStream outputStream = new FileOutputStream(tempJar);
            System.out.println(is.transferTo(outputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


