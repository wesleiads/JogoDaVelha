package com.br.jogodavelha;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class teste extends AppCompatActivity {

    private TextView btnNewGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teste);

        btnNewGame = findViewById(R.id.textView2);
    }

}
