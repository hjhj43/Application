package com.example.project.event;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.project.R;

public class Stopwatch extends Activity {
    TextView myOutput;
    TextView myRec;
    Button myBtnStart;
    Button myBtnRec;

    final static int Init =0;
    final static int Run =1;
    final static int Pause =2;

    int cur_Status = Init;
    int myCount=1;
    long myBaseTime;
    long myPauseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_stopwatch);

        myOutput = (TextView) findViewById(R.id.time_out);
        myRec = (TextView) findViewById(R.id.record);
        myBtnStart = (Button) findViewById(R.id.btn_start);
        myBtnRec = (Button) findViewById(R.id.btn_rec);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    Handler myTimer = new Handler(){
        public void handleMessage(Message msg){
            myOutput.setText(getTimeOut());
            myTimer.sendEmptyMessage(0);
        }
    };

    public void myOnClick(View v){
        switch(v.getId()){
            case R.id.btn_start:
                switch(cur_Status){
                    case Init:
                        myBaseTime = SystemClock.elapsedRealtime();
                        myTimer.sendEmptyMessage(0);
                        myBtnStart.setText("멈춤");
                        myBtnRec.setEnabled(true);
                        cur_Status = Run;
                        break;
                    case Run:
                        myTimer.removeMessages(0);
                        myPauseTime = SystemClock.elapsedRealtime();
                        myBtnStart.setText("시작");
                        myBtnRec.setText("리셋");
                        cur_Status = Pause;
                        break;
                    case Pause:
                        long now = SystemClock.elapsedRealtime();
                        myTimer.sendEmptyMessage(0);
                        myBaseTime += (now- myPauseTime);
                        myBtnStart.setText("멈춤");
                        myBtnRec.setText("기록");
                        cur_Status = Run;
                        break;
                }
                break;
            case R.id.btn_rec:
                switch(cur_Status){
                    case Run:
                        String str = myRec.getText().toString();
                        str +=  String.format("%d. %s\n",myCount,getTimeOut());
                        myRec.setText(str);
                        myCount++;
                        break;
                    case Pause:
                        myTimer.removeMessages(0);
                        myBtnStart.setText("시작");
                        myBtnRec.setText("기록");
                        myOutput.setText("00:00:00");

                        cur_Status = Init;
                        myCount = 1;
                        myRec.setText("");
                        myBtnRec.setEnabled(false);
                        break;
                }
                break;
        }
    }

    //현재시간을 계속 구해서 출력하는 메소드
    String getTimeOut(){
        long now = SystemClock.elapsedRealtime();
        long outTime = now - myBaseTime;
        String nowTime = String.format("%02d:%02d:%02d", outTime/1000 / 60, (outTime/1000)%60,(outTime%1000)/10);
        return nowTime;
    }
}
