package com.bhaskara.michael.bhaskara;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends Activity {

    // Variveis para receber os valores de entrada e saída
    private EditText valorA;
    private EditText valorB;
    private EditText valorC;
    private TextView x1;
    private TextView x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencia nas variaveis os campos de entrada ou saída
        valorA = (EditText)findViewById(R.id.valorA);
        valorB = (EditText)findViewById(R.id.valorB);
        valorC = (EditText)findViewById(R.id.valorC);
        x1 = (TextView)findViewById(R.id.x1);
        x2 = (TextView)findViewById(R.id.x2);

        Button button = (Button)findViewById(R.id.button);
    }

    // função acionada ao clicar no botão de calcular
    public void calcula(View view) {
        //validação para caso algum dos campos estajam vazios
        if (valorA.getText().length() == 0) {
            valorA.setError("Campo Vazio");
        } else if (valorB.getText().length() == 0) {
            valorB.setError("Campo Vazio");
        } else if (valorC.getText().length() == 0) {
            valorC.setError("Campo Vazio");
        } else {
            // definição das variaveis de controle auxiliares
            double valorX1 = 0, valorX2 = 0, a, b, c, d;
            // coloca nas variaveis a,b,c os valores que estão nos campos
            a = Double.parseDouble(valorA.getText().toString());
            b = Double.parseDouble(valorB.getText().toString());
            c = Double.parseDouble(valorC.getText().toString());

            // validação do valor de delta, se for menor que zero apresenta uma mensagem ao usuario
            d = (b * b) - 4 * a * c;

            if (d < 0) {
                Toast.makeText(this, "O valor de delta é menor que zero", Toast.LENGTH_LONG).show();
            } else {
                // se tiver ok, aplica formula de bhaskara
                NumberFormat format = NumberFormat.getInstance();
                format.setMaximumFractionDigits(4);
                format.setMinimumFractionDigits(2);
                format.setMaximumIntegerDigits(2);
                format.setRoundingMode(RoundingMode.HALF_UP);

                valorX1 = (-b + Math.sqrt(d)) / (2 * a);
                valorX2 = (-b - Math.sqrt(d)) / (2 * a);

                // coloca nos campos de resultados os valores obtidos atraves das formulas
                x1.setText(String.valueOf(format.format(valorX1)));
                x2.setText(String.valueOf(format.format(valorX2)));
            }

        }
    }

    // função para limpar os campos, para realizar novo calculo
    public void limpaCampos (View view){
        x1.setText(null);
        x2.setText(null);
        valorA.setText(null);
        valorB.setText(null);
        valorC.setText(null);
        valorA.requestFocus();
    }

}
