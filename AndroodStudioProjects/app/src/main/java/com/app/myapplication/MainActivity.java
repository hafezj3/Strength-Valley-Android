package com.app.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Log(View view) {
        //https://assets3.sportsnet.ca/wp-content/uploads/2019/04/cristiano-ronaldo-celebrates-goal-for-juventus-1040x572.jpg
        Log.i("Juventus","Juventus");
    }
}
