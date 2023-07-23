package edu.huflit.vnsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText medtSDT = findViewById(R.id.edtSDT);
        Button mbtnDN = findViewById(R.id.btnDN);
        Button mbtnDK = findViewById(R.id.btnDK);

        mbtnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

        mbtnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(medtSDT.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginActivity.this , "Nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                mbtnDN.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+84"+medtSDT.getText().toString(),60, TimeUnit.SECONDS,
                        LoginActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                mbtnDN.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                mbtnDN.setVisibility(View.VISIBLE);
                                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                mbtnDN.setVisibility(view.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(), OTPActivity.class);
                                intent.putExtra("mobile", medtSDT.getText().toString());
                                intent.putExtra("verificationId", verificationId);
                                startActivity(intent);
                            }
                        }

                );
            }

        });
    }
}