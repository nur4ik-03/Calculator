package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
            textView = findViewById(R.id.Text11);
        Button button = findViewById(R.id.openCalcolator);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Main2Activity.this , MainActivity.class);
                        startActivityForResult(intent,42);
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 42 && resultCode == RESULT_OK && data != null){
            textView.setText(data.getStringExtra("save"));
        }
    }

    public void Share(View view) {
        Intent intent = new Intent();
       intent.setAction(Intent.ACTION_SEND);
       intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
       intent.setType("text/plain");
       startActivity(intent);
    }
}
