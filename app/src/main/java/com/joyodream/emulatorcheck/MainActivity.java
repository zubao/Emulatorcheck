package com.joyodream.emulatorcheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView check;
    private android.widget.RelativeLayout activitymain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activitymain = (RelativeLayout) findViewById(R.id.activity_main);
        this.check = (TextView) findViewById(R.id.check);
        PermissionUtil.checkReadPhoneStatePermission(this);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmulatorUtil.checkBuildBrand();
                EmulatorUtil.checkBuildDevice();
                EmulatorUtil.checkBuildFingerPrint();
                EmulatorUtil.checkBuildHardware();
                EmulatorUtil.checkBuildModel();
                EmulatorUtil.checkBuildProduct();
                EmulatorUtil.checkTelephoneDeviceId(MainActivity.this);
                EmulatorUtil.checkTelephoneLineNumb(MainActivity.this);
            }
        });

    }




}
