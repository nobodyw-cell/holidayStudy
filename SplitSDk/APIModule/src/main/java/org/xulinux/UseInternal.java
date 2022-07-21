package org.xulinux;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.*;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/20 上午11:46
 */
public class UseInternal {
    public static void main(String[] args) {
        DClassLoad dClassLoad = new DClassLoad();

        try {
            Class klass = dClassLoad.loadClass("org.xulinux.Internal");

            Method method = klass.getMethod("Internal");

            method.invoke(klass.newInstance());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
