package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.event.Calendar;
import com.example.project.event.EventListActivity;
import com.example.project.event.Stopwatch;

public class MainActivity extends AppCompatActivity {

    Button eventBtn;
    Button stopwacthBtn;
    Button calenderBtn;
    Button addBtn;
    TextView birthTextView;
    TextView schoolTextView;
    EditText editText1;
    EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventBtn=(Button) findViewById(R.id.eventBtn);
        stopwacthBtn=(Button) findViewById(R.id.stopwacthBtn);
        calenderBtn=(Button) findViewById(R.id.calenderBtn);
        addBtn=(Button) findViewById(R.id.addBtn);
        birthTextView=(TextView) findViewById(R.id.birthTextView);
        schoolTextView=(TextView) findViewById(R.id.schoolTextView);

        calenderBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
            }
        });

        eventBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), EventListActivity.class);
                startActivity(intent);
            }
        });

        stopwacthBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Stopwatch.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        View dialogView = View.inflate(MainActivity.this, R.layout.event_dialog, null);

        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle("개인정보 수정");
        dlg.setView(dialogView);
        dlg.setPositiveButton("수정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                editText1=(EditText)dialogView.findViewById(R.id.editText1);
                editText2=(EditText)dialogView.findViewById(R.id.editText2);

                String birth = editText1.getText().toString();
                birthTextView.setText("생년월일: " + birth);
                String school = editText2.getText().toString();
                schoolTextView.setText("나의 학교: " + school);
                Toast.makeText(MainActivity.this, "변경되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                infoOptionsDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void infoOptionsDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.about)
                .setMessage(R.string.about_message)
                .setPositiveButton(R.string.str_ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {}
                        }).show();
    }
}