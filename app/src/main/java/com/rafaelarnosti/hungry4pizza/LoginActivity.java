package com.rafaelarnosti.hungry4pizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText tilLogin;
    private EditText tilSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilLogin = (EditText) findViewById(R.id.tilLogin);
        tilSenha = (EditText) findViewById(R.id.tilSenha);

    }
    public void logar(View v){

        String Login = tilLogin.getText().toString();
        String Senha = tilSenha.getText().toString();

        if(Login.equals("FIAP") && Senha.equals("123")){
            Intent intent = new Intent(this, PedidoActivity.class);
            intent.putExtra("usuario",Login);
            startActivity(intent);

        }else{
            Toast.makeText(this,"Usuario ou senhas invalidos",Toast.LENGTH_SHORT).show();
        }
    }
}
