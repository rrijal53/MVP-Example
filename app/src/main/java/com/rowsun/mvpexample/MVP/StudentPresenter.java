package com.rowsun.mvpexample.MVP;


import com.rowsun.mvpexample.pojo.Student;

import java.util.List;

/**
 * Created by roshanrijal on 3/27/18.
 */

public class StudentPresenter implements StudentMVP.StudentPresenter, StudentMVP.StudentModel.OnFinishedListener {

    private StudentMVP.StudentView mView;
    private StudentMVP.StudentModel mModel;

    public StudentPresenter(StudentMVP.StudentView mView, StudentMVP.StudentModel mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void onLoaded() {
        if (mView != null) {
            mView.init();
        }
    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void setStudentDetail(String id, String name, String address) {

    }

    @Override
    public void getStudentList() {

    }

    @Override
    public void getStudentDetail(String id) {
        if (mView != null && mModel != null) {
            mView.showLoading();
            mModel.getStudentDetail(id, this);
        }

    }

    @Override
    public void onSuccess(Student s) {
        if (mView != null && s != null) {
            mView.hideLoading();
            mView.showName(s.getName());
            mView.showAddress(s.getAddress());
        }
    }

    @Override
    public void onSuccess(List<Student> list) {

    }

    @Override
    public void onError(String message) {
        if (mView != null) {
            mView.hideLoading();
            mView.showError(message);
        }

    }
}
