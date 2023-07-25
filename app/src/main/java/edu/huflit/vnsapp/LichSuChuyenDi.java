package edu.huflit.vnsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LichSuChuyenDi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_chuyen_di);
        TextView LSCD = findViewById(R.id.tvLS);
        LSCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuChuyenDi.this, FavoriteLocation.class);
                startActivity(intent);
            }
        });
    }
}