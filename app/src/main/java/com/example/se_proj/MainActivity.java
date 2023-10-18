
//Profile Page
package com.example.se_proj;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {
    Button add_btn;

    Button profile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn = findViewById(R.id.addbtn);

        profile = findViewById(R.id.mypostbtn);

        add_btn.setOnClickListener(v ->

        {


            Intent intent = new Intent(getApplicationContext(), AddPost.class);
            startActivity(intent);

        });


    }





}


