package com.rowsun.mvpexample.MVP;


import android.os.Handler;

import com.rowsun.mvpexample.pojo.Student;

/**
 * Created by roshanrijal on 3/27/18.
 */

public class StudentModel implements StudentMVP.StudentModel {

    public StudentModel() {
    }

    @Override
    public void getStudentDetail(String id, final OnFinishedListener callback) {
        final Student s = new Student("1", "Roshan", "Dhulikhel");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(s);
            }
        }, 3000);
    }

    @Override
    public void getList(OnFinishedListener callback) {

    }

}
