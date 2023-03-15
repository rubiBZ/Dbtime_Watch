package com.example.Dbtime_Watch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Dbtime_Wathc.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends Activity {


    private EditText userNameEdt, passwordEdt;
    private Button loginBtn;
    private FirebaseAuth mAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEdt = findViewById(R.id.userNm);
        passwordEdt = findViewById(R.id.pw);
        loginBtn = findViewById(R.id.entr);
        mAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBtn.setVisibility(View.INVISIBLE);

                String email = userNameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "נא להכניס אימייל וסיסמא שאיתם נרשמת למערכת", Toast.LENGTH_SHORT).show();
                    loginBtn.setVisibility(View.VISIBLE);
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "הכניסה בוצע בהצלחה", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Login.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            loginBtn.setVisibility(View.VISIBLE);
                            Toast.makeText(Login.this, "אימייל או סיסמא שגויים, נא נסה שנית", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        /*
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
            this.finish();
        }

         */
    }
  }