package com.example.storyappmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView storyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        storyContent = findViewById(R.id.storyDetails);
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        getSupportActionBar().setTitle(title);
        storyContent.setText(content);
        storyContent.setMovementMethod(new ScrollingMovementMethod());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}