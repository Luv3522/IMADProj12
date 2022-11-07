package com.example.imadproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText stu_email;
    private EditText stu_password;
    private Button button;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stu_email=findViewById(R.id.et_email);
        stu_password= findViewById(R.id.et_password);
        button=findViewById(R.id.button1);
        auth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=stu_email.getText().toString();
                String password=stu_password.getText().toString();
                student_login(email,password);
            }
        });

    }

    public void student_login(String email,String password){
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(MainActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Login SuccessFull", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void teacherSignIn(View view) {

        Intent intent = new Intent(this,TeacherSignIn.class);
        startActivity(intent);
    }

}