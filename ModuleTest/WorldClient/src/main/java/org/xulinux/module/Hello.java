package org.xulinux.module;

import org.xulinux.ModuleExample.Hello3;
import org.xulinux.ModuleExample.pack1.Hello1;
import org.xulinux.ModuleExample.pack2.Hello2;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/6/20 下午8:17
 */
public class Hello {
    public static void main(String[] args) {
        Hello1 hello1 = new Hello1();
        Hello2 hello2 = new Hello2();
        Hello3 hello3 = new Hello3();

        hello1.hello();
        hello3.hello();
    }
}
