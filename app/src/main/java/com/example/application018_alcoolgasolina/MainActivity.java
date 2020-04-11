package com.example.application018_alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool;
    private TextInputEditText editPrecoGasolina;
    private TextView viewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        viewResultado = findViewById(R.id.viewResultado);

    }

    // funcao principal que realiza o calculo
    public void calcular(View view) {

        String precoAlcool, precoGasolina;

        precoAlcool = editPrecoAlcool.getText().toString();
        precoGasolina = editPrecoGasolina.getText().toString();

        // chamada da funcao de validacao
        boolean resultValidacao = validarDados(precoAlcool, precoGasolina);

        if(resultValidacao) {

            // Convercao dos dados
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            double resultado = valorAlcool / valorGasolina;

            if(resultado >= 0.7) {
                viewResultado.setText("Melhor abastecer com Gasolina");
            } else {
                viewResultado.setText("Melhor abastecer com Álcool");
            }

        } else {
            viewResultado.setText("Preencha todos os campos");
        }

    }

    // Fucao de validacao
    public boolean validarDados(String pAlcool, String pGasolina) {

        boolean validacao = true;

        if(pAlcool == null || pAlcool.equals("")) {
            validacao = false;
        } else if(pGasolina == null || pGasolina.equals("")) {
            validacao = false;
        }

        return validacao;

    }

}
