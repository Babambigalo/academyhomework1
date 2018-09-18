package com.example.android.academyhomework1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayTextActivity extends AppCompatActivity {

    private static final String KEY_EXTRA = "EXTRA_TEXT";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);
        Button button = findViewById(R.id.email_button);
        TextView textView = findViewById(R.id.display_StringExtra);
        final String textFromTV = getIntent().getStringExtra(KEY_EXTRA);
        textView.setText(textFromTV);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] address = {"andr.academy.msk@gmail.com"};
                sendEmail(address,"Hello,Android Academy MSK!",textFromTV);
            }
        });


    }

    public static void start(Activity activity, String textFromMainActivity) {
        Intent intent = new Intent(activity, DisplayTextActivity.class);
        intent.putExtra(KEY_EXTRA, textFromMainActivity);
        activity.startActivity(intent);

    }

    public void sendEmail(String[] address,String subject,String text){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,address);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,text);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this, "No Email app found", Toast.LENGTH_SHORT).show();
        }

    }
}
