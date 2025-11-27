package com.example.trabalhomobilemapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pagina extends AppCompatActivity {

    // Declara os componentes da interface (UI)
    private EditText campoPeso;
    private EditText campoAltura;
    private EditText campoGenero;
    private EditText campoDataNascimento;
    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina);

        // Inicializa o SharedPreferences para salvar os dados do usuário
        preferencias = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        // 1. Encontre os componentes da interface pelos seus novos IDs no XML
        campoPeso = findViewById(R.id.editText_Peso);
        campoAltura = findViewById(R.id.editText_Altura);
        campoGenero = findViewById(R.id.editText_Genero);
        campoDataNascimento = findViewById(R.id.editText_DataNascimento);
        Button btn_voltar = findViewById(R.id.button_Voltar);
        Button btn_salvar = findViewById(R.id.salvar);

        // Carrega e exibe os dados salvos anteriormente, se existirem
        carregarDados();

        // 2. Configure a ação de clique para o botão "voltar".
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha a tela atual e volta para a anterior.
            }
        });

        // 3. Configure a ação de clique para o botão "salvar".
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chama o método para salvar os dados
                salvarDados();
                // Fecha a tela após salvar.
                finish();
            }
        });
    }

    private void carregarDados() {
        // Busca os dados salvos. Se não encontrar, usa um valor padrão "" (vazio).
        String pesoSalvo = preferencias.getString("user_peso", "");
        String alturaSalva = preferencias.getString("user_altura", "");
        String generoSalvo = preferencias.getString("user_genero", "");
        String dataNascimentoSalva = preferencias.getString("user_data_nascimento", "");

        // Coloca os dados encontrados nos campos de texto
        campoPeso.setText(pesoSalvo);
        campoAltura.setText(alturaSalva);
        campoGenero.setText(generoSalvo);
        campoDataNascimento.setText(dataNascimentoSalva);
    }

    private void salvarDados() {
        // --- AQUI CRIAMOS AS VARIÁVEIS E SALVAMOS AS NOVAS INFORMAÇÕES ---

        // Pega o texto atual dos campos de EditText
        String pesoParaSalvar = campoPeso.getText().toString();
        String alturaParaSalvar = campoAltura.getText().toString();
        String generoParaSalvar = campoGenero.getText().toString();
        String dataNascimentoParaSalvar = campoDataNascimento.getText().toString();

        // Cria um editor para o nosso arquivo de preferências
        SharedPreferences.Editor editor = preferencias.edit();

        // Salva os valores usando chaves diferentes
        editor.putString("user_peso", pesoParaSalvar);
        editor.putString("user_altura", alturaParaSalvar);
        editor.putString("user_genero", generoParaSalvar);
        editor.putString("user_data_nascimento", dataNascimentoParaSalvar);

        // Confirma a gravação dos dados no arquivo
        editor.apply();

        // Exibe uma mensagem rápida na tela confirmando que foi salvo
        Toast.makeText(this, "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
