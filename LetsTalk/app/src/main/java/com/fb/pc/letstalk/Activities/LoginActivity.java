package com.fb.pc.letstalk.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fb.pc.letstalk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {

    MaterialEditText email, password;
    Button btn_login;

    FirebaseAuth auth;

    TextView forgot_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth=FirebaseAuth.getInstance();

         email=findViewById(R.id.Email);
         password=findViewById(R.id.password);
         btn_login=findViewById(R.id.btn_login);
         forgot_password = findViewById(R.id.forgot_password);

         forgot_password.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
             }
         });

         btn_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String S_email,S_password;

                 S_email = email.getText().toString();
                 S_password = password.getText().toString();
                 if (TextUtils.isEmpty(S_email) || TextUtils.isEmpty(S_password)) {
                     Toast.makeText(LoginActivity.this, "Make sure you fill all resource blocks",Toast.LENGTH_SHORT).show();
             } else{
                    auth.signInWithEmailAndPassword(S_email,S_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                                getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(LoginActivity.this,"Authentication Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                 }
             }
         });
    }
}
