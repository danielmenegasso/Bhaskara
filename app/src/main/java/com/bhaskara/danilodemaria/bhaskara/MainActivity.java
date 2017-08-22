package com.bhaskara.danilodemaria.bhaskara;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import static com.bhaskara.danilodemaria.bhaskara.R.layout.*;

public class MainActivity extends AppCompatActivity {

    private EditText valorA;
    private EditText valorB;
    private EditText valorC;
    private EditText x1;
    private EditText x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        valorA = (EditText)findViewById(R.id.valorA);
        valorB = (EditText)findViewById(R.id.valorB);
        valorC = (EditText)findViewById(R.id.valorC);
        x1 = (EditText)findViewById(R.id.x1);
        x2 = (EditText)findViewById(R.id.x2);

        Button button = (Button)findViewById(R.id.button);
    }

    public void calcula(View view) {

        double valorX1 = 0,valorX2 = 0,a,b,c,d;
        a = Double.parseDouble(valorA.getText().toString());
        b = Double.parseDouble(valorB.getText().toString());
        c = Double.parseDouble(valorC.getText().toString());


        d = (b * b) - 4* a * c;

        if (d < 0)
        {
            Toast.makeText(this ,"O valor de delta é menor que zero", Toast.LENGTH_LONG);
        }

        else
        {
            valorX1 = (-b + Math.sqrt(d))/(2 * a);
            valorX2 = (-b - Math.sqrt(d))/(2 * a);
        }

        x1.setText(String.valueOf(valorX1));
        x2.setText(String.valueOf(valorX2));
    }

    public void limpaCampos (View view){
        x1.setText(null);
        x2.setText(null);
        valorA.setText(null);
        valorB.setText(null);
        valorC.setText(null);
    }

    public void popup(View view) {

        LinearLayout layout = (LinearLayout) findViewById(R.id.popupLayout);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View layoutView = inflater.inflate(R.layout.sobre_layout, layout);

        final PopupWindow window = new PopupWindow(view);
        window.setContentView(layoutView);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        window.setWidth(metrics.widthPixels);
        window.setHeight(metrics.heightPixels);
        window.setFocusable(true);

        window.showAtLocation(layoutView, Gravity.NO_GRAVITY, 0, 0);

        Button voltar = (Button) layoutView.findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
    }
}
