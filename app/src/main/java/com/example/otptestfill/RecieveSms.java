package com.example.otptestfill;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class RecieveSms extends BroadcastReceiver {

    private static EditText editText;
    public void setEditText(EditText editText)
    {
        RecieveSms.editText = editText;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {

        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for(SmsMessage sms : messages)
        {
            String message = sms.getMessageBody();
        }
        Toast.makeText(context,"SMS RECIEVED",Toast.LENGTH_SHORT).show();
    }
}
