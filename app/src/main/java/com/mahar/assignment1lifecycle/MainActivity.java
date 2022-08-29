package com.mahar.assignment1lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public EditText komentarField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        komentarField=findViewById(R.id.editTextTextMultiLine);
        
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState
                    .getBoolean("reply_visible");
            if (isVisible) {
                komentarField.setText(savedInstanceState
                        .getString("komentar"));
                komentarField.setVisibility(View.VISIBLE);
            }
        }
    }
    // onSaveInstanceState dipanggil ketika aplikasi ditutup onStop/onPause
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i("SaveInstanceState","SaveInstanceState dipanggil");

        super.onSaveInstanceState(outState);
        if (komentarField.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("komentar", komentarField.getText().toString());
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("SaveInstanceState","siklus hidup onstart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("SaveInstanceState","siklus hidup onREstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SaveInstanceState","siklus hidup onresume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("SaveInstanceState","siklus hidup onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("SaveInstanceState","siklus hidup onstop");

    }
}