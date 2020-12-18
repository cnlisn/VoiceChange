package com.lisn.voicechange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Request necessary permissions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] perms = {"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};
            if (checkSelfPermission(perms[0]) == PackageManager.PERMISSION_DENIED ||
                    checkSelfPermission(perms[1]) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(perms, 200);
            }
        }
        org.fmod.FMOD.init(this);

        findViewById(R.id.btn_primary).setOnClickListener(v -> {
//      String path = Environment.getExternalStoragePublicDirectory(.)
            VoiceUtils.luoli("s", VoiceUtils.MODE_PRIMARY);
        });
        findViewById(R.id.btn_luoli).setOnClickListener(v -> {
//      String path = Environment.getExternalStoragePublicDirectory(.)
            VoiceUtils.luoli("s", VoiceUtils.MODE_LUOLI);
        });
        findViewById(R.id.btn_dashu).setOnClickListener(v -> {
//      String path = Environment.getExternalStoragePublicDirectory(.)
            VoiceUtils.luoli("s", VoiceUtils.MODE_DASHU);
        });
        findViewById(R.id.btn_jingsong).setOnClickListener(v -> {
//      String path = Environment.getExternalStoragePublicDirectory(.)
            VoiceUtils.luoli("s", VoiceUtils.MODE_JINSONG);
        });
        findViewById(R.id.btn_gaoguai).setOnClickListener(v -> {
//      String path = Environment.getExternalStoragePublicDirectory(.)
            VoiceUtils.luoli("s", VoiceUtils.TYPE_GAOGUAI);
        });
        findViewById(R.id.btn_kongling).setOnClickListener(v -> {
//      String path = Environment.getExternalStoragePublicDirectory(.)
            VoiceUtils.luoli("s", VoiceUtils.TYPE_KONGLING);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        org.fmod.FMOD.close();
    }

}
