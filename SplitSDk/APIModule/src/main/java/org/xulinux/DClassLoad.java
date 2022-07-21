package org.xulinux;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/21 上午9:19
 */
public class DClassLoad extends ClassLoader{

    static {
        URL url = UseInternal.class.getResource("/Internal-1.0-SNAPSHOT.jar");
        String path = url.getPath();
        // 得到 ApiModule.jar位置
        String jarpath = path.substring(0,path.lastIndexOf("!")).replace("file:","");

        System.out.println(jarpath);

        // 创建jarfile
        JarFile jarFile = null;
        try {
            jarFile = new JarFile(jarpath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 得到internal entry
        JarEntry InternalEntry = jarFile.getJarEntry("Internal-1.0-SNAPSHOT.jar");
        try {
            InputStream is = jarFile.getInputStream(InternalEntry);

            // 创建临时文件
            File file = File.createTempFile("DubboTmpJar",".jar");

            file.deleteOnExit();
            OutputStream ops = new FileOutputStream(file);
            is.transferTo(ops);
            urlClassLoader = new URLClassLoader(new URL[]{file.toURL()});
            is.close();
            ops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static URLClassLoader urlClassLoader;

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (urlClassLoader != null) {
            return urlClassLoader.loadClass(name);
        }

        return null;
    }
}
