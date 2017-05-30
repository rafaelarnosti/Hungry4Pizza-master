package com.rafaelarnosti.hungry4pizza;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PedidoActivity extends AppCompatActivity {
    private TextView tvUsuario;
    private CheckBox cbatum;
    private CheckBox cbbacon;
    private CheckBox cbcalabresa;
    private CheckBox cbmussarela;
    private RadioGroup rgTamanhoPizza;
    private Spinner spn_pgto;
    private CheckBox cbbordarecheada;
    private CheckBox cbrecheioextra;
    private CheckBox cbrefrigerante;
    private CheckBox cbsobremesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        tvUsuario = (TextView)findViewById(R.id.tvUsuario);
        cbatum =(CheckBox)findViewById(R.id.cbatum);
        cbbacon=(CheckBox)findViewById(R.id.cbbacon);
        cbcalabresa=(CheckBox) findViewById(R.id.cbcalabresa);
        cbmussarela=(CheckBox)findViewById(R.id.cbmussarela);
        rgTamanhoPizza=(RadioGroup)findViewById(R.id.rgTamanhoPizza);
        spn_pgto = (Spinner)findViewById(R.id.spn_pgto);
        cbbordarecheada=(CheckBox)findViewById(R.id.cbbordarecheada);
        cbrecheioextra=(CheckBox)findViewById(R.id.cbrecheioextra);
        cbrefrigerante=(CheckBox)findViewById(R.id.cbrefrigerante);
        cbsobremesa=(CheckBox)findViewById(R.id.cbsobremesa);

        Bundle bundle = getIntent().getExtras();
        String usuario = bundle.getString("usuario");

        tvUsuario.setText("Olá " + usuario);
    }

    public void calcular(View view) {

        int idSelecionado = rgTamanhoPizza.getCheckedRadioButtonId();
        int valorTamanhoPizza =0;
        double valor =0;

        switch (idSelecionado) {
            case R.id.rbPequena:
                valorTamanhoPizza =10;
                break;
            case R.id.rbMedia:
                valorTamanhoPizza=12;
                break;
            case R.id.rbGrande:
                valorTamanhoPizza=15;
                break;
        }
        if (cbbordarecheada.isChecked()) {
            valor += 5;
        }
        if (cbrecheioextra.isChecked()) {
            valor += 10;
        }
        if (cbrefrigerante.isChecked()) {
            valor += 7;
        }
        if (cbsobremesa.isChecked()) {
            valor += 13;
        }
        if (cbatum.isChecked()) {
            valor += 3 + valorTamanhoPizza;
        }
        if (cbbacon.isChecked()) {
            valor += 5 + valorTamanhoPizza;
        }
        if (cbcalabresa.isChecked()) {
            valor += 4 + valorTamanhoPizza;
        }
        if (cbmussarela.isChecked()) {
            valor += 2 + valorTamanhoPizza;
        }

        String pagamento = (String) spn_pgto.getSelectedItem();

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirmação");
        alert.setMessage("Valor: " + valor + "​\n​Pagamento: " + pagamento);

         alert.setPositiveButton("SIM",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("Pedido","Confirmação de Pedido");
                Toast.makeText(PedidoActivity.this, "Pedido Confirmado",
                        Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("NÃO",null);
        alert.show();
    }
}
