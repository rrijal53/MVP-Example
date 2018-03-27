package com.rowsun.mvpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rowsun.mvpexample.MVP.StudentMVP;
import com.rowsun.mvpexample.MVP.StudentModel;
import com.rowsun.mvpexample.MVP.StudentPresenter;
import com.rowsun.mvpexample.pojo.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentMVP.StudentView {


    StudentMVP.StudentPresenter presenter;
    TextView tvName;
    TextView tvAddress;
    ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tv_name);
        tvAddress = findViewById(R.id.tv_address);
        pBar = findViewById(R.id.prg_bar);
        presenter = new StudentPresenter(this, new StudentModel());
        presenter.getStudentDetail("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void init() {

    }

    @Override
    public void showLoading() {
        pBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pBar.setVisibility(View.GONE);

    }

    @Override
    public void showName(String name) {
        tvName.setText(name);
    }

    @Override
    public void showAddress(String address) {
        tvAddress.setText(address);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showStudentList(List<Student> list) {

    }
}
