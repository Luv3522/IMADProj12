package com.example.imadproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email= findViewById(R.id.et_RegEmail);
        password= findViewById(R.id.et_RegPassword);
        register=findViewById(R.id.btn_Register);

        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacher_email= email.getText().toString();
                String teacher_password= password.getText().toString();

                if(TextUtils.isEmpty(teacher_email) || TextUtils.isEmpty(teacher_password)){
                    Toast.makeText(Register.this, "Name and Email Cannot Be Empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    registerUser(teacher_email,teacher_password);
                }
            }
        });


    }

    private void registerUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Register.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}