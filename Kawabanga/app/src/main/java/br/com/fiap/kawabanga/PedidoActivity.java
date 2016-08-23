package br.com.fiap.kawabanga;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PedidoActivity extends AppCompatActivity {

    private TextView tvUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        Intent intent = getIntent();
        String username = intent.getStringExtra("user");

        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        tvUsuario.setText("Bem vindo " + username);
    }

}
