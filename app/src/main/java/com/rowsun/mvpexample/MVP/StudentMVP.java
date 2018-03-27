package com.rowsun.mvpexample.MVP;

import com.rowsun.mvpexample.pojo.Student;

import java.util.List;

/**
 * Created by roshanrijal on 3/27/18.
 */

public interface StudentMVP {
    interface StudentView {
        void init();

        void showLoading();

        void hideLoading();


        void showName(String name);

        void showAddress(String address);

        void showError(String error);

        void showStudentList(List<Student> list);

    }

    interface StudentPresenter {
        void onLoaded();

        void onDestroy();

        void setStudentDetail(String id, String name, String address);

        void getStudentList();

        void getStudentDetail(String id);
    }

    interface StudentModel {
        void getStudentDetail(String id, OnFinishedListener callback);

        void getList(OnFinishedListener callback);

        interface OnFinishedListener {
            void onSuccess(Student s);

            void onSuccess(List<Student> list);

            void onError(String message);
        }
    }
}
