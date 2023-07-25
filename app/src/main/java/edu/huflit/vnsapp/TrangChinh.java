package edu.huflit.vnsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TrangChinh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chinh);
        ImageView menu = findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChinh.this, CapNhatTaiKhoan.class);
                startActivity(intent);
            }
        });

        setTitleToolbar();
        //getDataIntent();
    }
    private void setTitleToolbar(){
        if (getSupportActionBar()!= null){
            getSupportActionBar().setTitle("Main Activity");
        }
    }
   /* private void getDataIntent(){
        String strPhoneNumber = getIntent().getStringExtra("phone_number");
        TextView mtvInfor = findViewById(R.id.tvInfor);
        mtvInfor.setText(strPhoneNumber);
    }*/
}