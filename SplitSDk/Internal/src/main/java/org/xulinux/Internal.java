package org.xulinux;

import com.google.gson.Gson;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/20 上午11:42
 */
public class Internal {
    public void Internal() {
        Gson gson = new Gson();
        Student student = new Student();
        student.setAge(10);
        student.setName("wang");
        student.setId("03201111");

        System.out.println(gson.toJson(student));
    }
}
