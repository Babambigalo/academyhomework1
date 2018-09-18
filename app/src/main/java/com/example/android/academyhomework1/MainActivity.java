package com.example.android.academyhomework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button previewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        previewButton = findViewById(R.id.preview_button);
        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().length() != 0) {
                    openSecondActivity();
                } else {
                    Toast.makeText(MainActivity.this, "Type your message please!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    public void openSecondActivity() {
        DisplayTextActivity.start(this, editText.getText().toString());
    }

}
