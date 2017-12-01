package br.edu.iff.pooa20172.trabalho02_2017_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.StringTokenizer;

public class EditarActivity extends Activity {
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        setTitle(R.string.activity_editarTitle);

        Intent intent = getIntent();
        Bundle dados = intent.getExtras();

        this.index = dados.getInt("index");

        ((EditText) findViewById(R.id.etNome)).setText(dados.getString("nome"));
        ((EditText) findViewById(R.id.etData)).setText(String.format(Locale.ENGLISH, "%02d/%02d/%d", dados.getInt("dia"), dados.getInt("mes"), dados.getInt("ano")));
        ((EditText) findViewById(R.id.etLocal)).setText(dados.getString("local"));
        ((EditText) findViewById(R.id.etCapacidade)).setText(Integer.toString(dados.getInt("capacidade")));
        ((EditText) findViewById(R.id.etPromotor)).setText(dados.getString("promotor"));
        ((EditText) findViewById(R.id.etPatrocinio)).setText(dados.getString("patrocinio"));
        ((EditText) findViewById(R.id.etValorIngresso)).setText(Float.toString(dados.getFloat("valorIngresso")));

    }

    @Override
    public void finish() {
        Intent intent = new Intent();

        Bundle bundle = new Bundle();
        bundle.putInt("index", index);

        bundle.putString("nome", ((EditText) findViewById(R.id.etNome)).getText().toString());
        bundle.putString("local", ((EditText) findViewById(R.id.etLocal)).getText().toString());
        bundle.putString("promotor", ((EditText) findViewById(R.id.etPromotor)).getText().toString());
        bundle.putString("patrocinio", ((EditText) findViewById(R.id.etPatrocinio)).getText().toString());

        bundle.putInt("capacidade", Integer.parseInt(((EditText) findViewById(R.id.etCapacidade)).getText().toString()));

        bundle.putFloat("valorIngresso", Float.parseFloat(((EditText) findViewById(R.id.etValorIngresso)).getText().toString()));

        String[] dataInfo = ((EditText) findViewById(R.id.etData)).getText().toString().split("/");
        String[] dataNome = new String[]{"dia", "mes", "ano"};


        for (int i = 0; i < dataInfo.length; i++) {
            bundle.putInt(dataNome[i], Integer.parseInt(dataInfo[i]));
        }

        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        super.finish();
    }

}
