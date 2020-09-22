package com.example.localfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.example.localfile.permiss.PermissionsUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    String[] permissionArr = new String[]{
            //SD卡读写操作
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //权限工具类调用
        PermissionsUtils.getInstance().checkPermissions(this, permissionArr, new PermissionsUtils.IPermissionsResult() {
            @Override
            public void passPermissions() {

            }

            @Override
            public void forbidPermissions() {
            }
        });

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsUtils.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
