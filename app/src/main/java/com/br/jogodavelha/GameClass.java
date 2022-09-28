package com.br.jogodavelha;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GameClass extends AppCompatActivity {
    boolean jogoAtivo = true;
    private FloatingActionButton btnHome;

    int jogadorAtivo = 0;
    int[] statusJogo = {2, 2, 2, 2, 2, 2, 2, 2, 2};


    int[][] posicaoVencer = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    public static int counter = 0;




    public void cliqueJogador(View view) {
        ImageView img = (ImageView) view;
        int imagemClicada = Integer.parseInt(img.getTag().toString());


        if (!jogoAtivo) {
            reiniciarJogo(view);
        }


        if (statusJogo[imagemClicada] == 2) {

            counter++;


            if (counter == 9) {

                jogoAtivo = false;
            }


            statusJogo[imagemClicada] = jogadorAtivo;


            img.setTranslationY(-1000f);


            if (jogadorAtivo == 0) {

                img.setImageResource(R.drawable.x);
                jogadorAtivo = 1;
                TextView status = findViewById(R.id.status);


                status.setText("O vez - clique para jogar");
            } else {

                img.setImageResource(R.drawable.o);
                jogadorAtivo = 0;
                TextView status = findViewById(R.id.status);


                status.setText("X vez - clique para jogar");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        int flag = 0;

        for (int[] posicaoVencedora : posicaoVencer) {
            if (statusJogo[posicaoVencedora[0]] == statusJogo[posicaoVencedora[1]] &&
                    statusJogo[posicaoVencedora[1]] == statusJogo[posicaoVencedora[2]] &&
                    statusJogo[posicaoVencedora[0]] != 2) {
                flag = 1;


                String vencedorStr;

                jogoAtivo = false;
                if (statusJogo[posicaoVencedora[0]] == 0) {
                    vencedorStr = "X venceu";
                } else {
                    vencedorStr = "O venceu";
                }

                TextView status = findViewById(R.id.status);
                status.setText(vencedorStr);
            }
        }

        if (counter == 9 && flag == 0) {
            TextView status = findViewById(R.id.status);
            status.setText("Empate");
        }
    }


    public void reiniciarJogo(View view) {
        jogoAtivo = true;
        jogadorAtivo = 0;
        for (int i = 0; i < statusJogo.length; i++) {
            statusJogo[i] = 2;
        }

        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X vez - clique para jogar");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameclass);

        btnHome = findViewById(R.id.button_homepage);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(GameClass.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}

