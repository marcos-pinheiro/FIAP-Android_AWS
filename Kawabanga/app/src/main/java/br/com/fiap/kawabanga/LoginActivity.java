package br.com.fiap.kawabanga;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilLogin;
    private TextInputLayout tilPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilLogin = (TextInputLayout) findViewById(R.id.tilLogin);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
    }

    public void logar(View view) {

        final String user = tilLogin.getEditText().getText().toString();
        final String pass = tilPassword.getEditText().getText().toString();

        if("admin".equals(user) && "admin".equals(pass)) {
            Intent intent = new Intent(this, PedidoActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Se fudeu", Toast.LENGTH_SHORT).show();
        }
    }
}
