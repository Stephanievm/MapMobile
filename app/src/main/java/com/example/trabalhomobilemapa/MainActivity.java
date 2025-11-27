package com.example.trabalhomobilemapa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Encontra o botão que vai para a tela de dados do usuário
        Button dados_btn = findViewById(R.id.usuario);

        dados_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cria a intenção de ir da tela atual (MainActivity) para a tela 'pagina'
                Intent i = new Intent(MainActivity.this, pagina.class);
                startActivity(i);
            }
        });
    }
}
