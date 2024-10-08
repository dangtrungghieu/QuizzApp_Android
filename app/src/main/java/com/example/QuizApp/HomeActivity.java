package com.example.QuizApp;

import static com.example.QuizApp.R.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView userName, btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        btnLogout = findViewById(id.btnLogout);
        userName = findViewById(id.tvUsernameHome);
        userName.setText("Xin chào " + name.toUpperCase());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
                alertDialogBuilder.setTitle("Đăng xuất khỏi tài khoản !");
                alertDialogBuilder.setIcon(R.drawable.question);
                alertDialogBuilder.setMessage("Bạn chắc chứ ?");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int argl) {
                        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                        finish();
                    }
                });

                alertDialogBuilder.setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialogBuilder.create().show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Notify.exit(HomeActivity.this);
    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.ltw:
                intent = new Intent(HomeActivity.this, StartActivity.class);
                intent.putExtra("categoryId",1);
                intent.putExtra("categoryName","Lập trình web");
                startActivity(intent);
                break;
            case R.id.hdt:
                intent = new Intent(HomeActivity.this, StartActivity.class);
                intent.putExtra("categoryId",2);
                intent.putExtra("categoryName","Hướng đối tượng");
                startActivity(intent);
                break;
            case R.id.android:
                intent = new Intent(HomeActivity.this, StartActivity.class);
                intent.putExtra("categoryId",3);
                intent.putExtra("categoryName","Lập trình android");
                startActivity(intent);
                break;
            case R.id.web:
                intent = new Intent(HomeActivity.this, StartActivity.class);
                intent.putExtra("categoryId",4);
                intent.putExtra("categoryName","Quản trị mạng");
                startActivity(intent);
                break;
            case R.id.hdh:
                intent = new Intent(HomeActivity.this, StartActivity.class);
                intent.putExtra("categoryId",5);
                intent.putExtra("categoryName","Hệ điều hành");
                startActivity(intent);
                break;
            case R.id.sql:
                intent = new Intent(HomeActivity.this, StartActivity.class);
                intent.putExtra("categoryId",6);
                intent.putExtra("categoryName","Hệ quản trị CSDL");
                startActivity(intent);
                break;

            default:
                Toast.makeText(HomeActivity.this, "a", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}