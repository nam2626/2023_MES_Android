package com.example.a09_touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        View view1 = findViewById(R.id.view1);
        View view2 = findViewById(R.id.view2);

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float xpos = motionEvent.getX();
                float ypos = motionEvent.getY();
                String str = "";
                Log.d("TOUCH_EVENT", "onTouch: "+action);
                //textView에 출력 -> 실행이력이 누적
                if(action == MotionEvent.ACTION_DOWN){
                    //손가락 눌렀을때
                    str = String.format("손가락 누름 - xpos : %.1f, ypos : %.1f", xpos,ypos);
                }else if (action == MotionEvent.ACTION_UP){
                    //손가락 눌렀다가 떼었을때
                    str = String.format("손가락 뗌 - xpos : %.1f, ypos : %.1f", xpos,ypos);
                }else if(action == MotionEvent.ACTION_MOVE){
                    //손가락 눌러서 움직였을 때
                    str = String.format("손가락 움직임 - xpos : %.1f, ypos : %.1f", xpos,ypos);
                }
                textView.setText(textView.getText() + "\n" + str);
                return true;
            }
        });

        
    }
}












