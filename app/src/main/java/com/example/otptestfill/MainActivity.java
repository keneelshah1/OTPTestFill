package com.example.otptestfill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        editText = findViewById(R.id.editText);
        new RecieveSms().setEditText(editText);


//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR2 && checkSelfPermission(Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED)
//        {
//            requestPermissions(new String[] {Manifest.permission.RECEIVE_SMS},1000);
//        }
//        @Override
//        public void onRequestPermissionsResult(int requestCode,@NotNull String[] permissions , @NotNull int[] grantResults)
//        {
//            if(requestCode==1000)
//            {
//                if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
//                {
//                }
//                else
//                {
//                    finish();
//                }
//            }
//        }
    }

    private void requestPermission() {
        String permission = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this,permission);
        if(grant != PackageManager.PERMISSION_GRANTED)
        {
            String[] permission_list = new String[1];
            permission_list[0]=permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }
    }
}