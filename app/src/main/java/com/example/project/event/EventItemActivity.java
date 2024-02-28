package com.example.project.event;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;

public class EventItemActivity extends AppCompatActivity {

    TextView title;
    TextView content;
    TextView detail;
    ImageButton webBtn;
    ImageButton shareBtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_content);

        title=findViewById(R.id.titleSub);
        content=findViewById(R.id.contentSub);
        detail=findViewById(R.id.detailSub);
        webBtn=findViewById(R.id.webBtn);
        shareBtn=findViewById(R.id.shareBtn);

        title.setText(getIntent().getStringExtra("title"));
        content.setText(getIntent().getStringExtra("content"));
        detail.setText(getIntent().getStringExtra("detail"));
        String link= getIntent().getStringExtra("link");

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse(link);
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra("sms_body", title.getText()+"\n"+link);
                startActivity(Intent.createChooser(intent,null));
            }
        });
    }
}