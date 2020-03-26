package com.fb.pc.letstalk.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.fb.pc.letstalk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;


public class RegisterActivity extends AppCompatActivity {

    MaterialEditText number, password, Email;
    Button btn_register;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        number=findViewById(R.id.number);
        Email=findViewById(R.id.Email);
        password=findViewById(R.id.password);
        btn_register=findViewById(R.id.btn_register);

        auth=FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username, email, pass;

                username=number.getText().toString();// convert phone to string and use it as a username for sign in
                email=Email.getText().toString();// Convert email to string to save it
                pass=password.getText().toString();//Save password also as string
                int length=username.length();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(RegisterActivity.this, "Fill all the boxes",Toast.LENGTH_SHORT).show();
                } else if (length<8){
                    Toast.makeText(RegisterActivity.this, "Phone number invalid! Must be at least 8 numbers",Toast.LENGTH_SHORT).show();
                }else if (pass.length()<6){
                    Toast.makeText(RegisterActivity.this, "Password at least 6 characters",Toast.LENGTH_SHORT).show();
                }else{
                    register(username,email,pass);// register user
                }
            }
        });


    }

    private void register(final String username, String mail, String password)
    {
        auth.createUserWithEmailAndPassword(mail,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser FirebaseUser = auth.getCurrentUser();
                            assert FirebaseUser != null;
                            String id = FirebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Users").child(id);

                            HashMap<String, String> hash = new HashMap<>();
                            hash.put("id", id);
                            hash.put("username", username);
                            hash.put("imageURL", "default");
                            hash.put("status", "offline");

                            reference.setValue(hash).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(RegisterActivity.this, Main2Activity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(RegisterActivity.this,"Email or password invalid! Check and retry", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
 }
