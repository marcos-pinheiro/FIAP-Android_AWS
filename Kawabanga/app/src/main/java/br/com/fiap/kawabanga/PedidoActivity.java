package br.com.fiap.kawabanga;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.fiap.kawabanga.models.Usuario;

public class PedidoActivity extends AppCompatActivity {

    private TextView tvUsuario;
    private CheckBox cbAtum;
    private CheckBox cbBacon;
    private CheckBox cbMussarela;
    private CheckBox cbCalabresa;

    private RadioGroup rgTamanhoPizza;
    private Spinner spPagamentos;
    private CheckBox cbBordaRecheada;
    private CheckBox cbRecheioExtra;
    private CheckBox cbRefrigerante;
    private CheckBox cbSobremesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        Intent intent = getIntent();
        //String username = intent.getStringExtra("user");
        Usuario usuario = (Usuario) intent.getExtras().getParcelable("user");
        tvUsuario.setText("Bem vindo " + usuario.getLogin());

        this.bind();
    }

    public void calcular(View view) {

        Toast.makeText(this, "Pedido xxx", Toast.LENGTH_LONG).show();

        int idSelecionado = rgTamanhoPizza.getCheckedRadioButtonId();
        double valorPizza = 0.;

        switch (idSelecionado) {
            case R.id.rbGrande:
                valorPizza = 50;
                break;

            case R.id.rbMedia:
                valorPizza = 40;
                break;

            case R.id.rbPequena:
                valorPizza = 30;
                break;
        }

        if(cbBordaRecheada.isChecked()) {
            valorPizza += 5.;
        }

        if(cbRecheioExtra.isChecked()) {
            valorPizza += 8.;
        }

        if(cbRefrigerante.isChecked()) {
            valorPizza += 11.;
        }

        if(cbSobremesa.isChecked()) {
            valorPizza += 20.;
        }

        final String pagamento = (String) spPagamentos.getSelectedItem();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmação do pedido");
        builder.setMessage(String.format("Valor $: %s \nPagamento: %s", valorPizza, pagamento));

        builder.setNegativeButton("Não", null);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(PedidoActivity.this, "Pedido confirmado", Toast.LENGTH_LONG).show();
            }
        });
    }

    private final void bind() {
        tvUsuario       = (TextView) findViewById(R.id.tvUsuario);
        cbAtum          = (CheckBox) findViewById(R.id.cbAtum);
        cbBacon         = (CheckBox) findViewById(R.id.cbBacon);
        cbMussarela     = (CheckBox) findViewById(R.id.cbMussarela);
        cbCalabresa     = (CheckBox) findViewById(R.id.cbCalabresa);
        rgTamanhoPizza  = (RadioGroup) findViewById(R.id.rgTamanhoPizza);
        spPagamentos    = (Spinner) findViewById(R.id.spPagamentos);
        cbBordaRecheada = (CheckBox) findViewById(R.id.cbBordaRecheada);
        cbRecheioExtra  = (CheckBox) findViewById(R.id.cbRecheioExtra);
        cbRefrigerante  = (CheckBox) findViewById(R.id.cbRefrigerante);
        cbSobremesa     = (CheckBox) findViewById(R.id.cbSobremesa);
    }
}
