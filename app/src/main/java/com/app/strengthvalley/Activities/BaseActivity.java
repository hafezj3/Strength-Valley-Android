package com.app.strengthvalley.Activities;

import android.os.Bundle;
import android.util.Log;
import java.io.Serializable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public abstract int getContentView(Bundle savedInstanceState);
//    protected Loader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView(savedInstanceState));
    }

}
