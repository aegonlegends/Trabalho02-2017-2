package br.edu.iff.pooa20172.trabalho02_2017_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {

    private ArrayList<Evento> eventos;
    private ArrayAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.activity_mainTitle);

        ListView lista = (ListView) findViewById(R.id.lvEventos);
        final ArrayList<Evento> eventos = adicionarEventos();
        listAdapter = new EventoAdapter(this, eventos);
        lista.setAdapter(listAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, EditarActivity.class);
                Bundle bundle = eventos.get(i).toBundle();
                bundle.putInt("index", i);

                intent.putExtras(bundle);

                startActivityForResult(intent, R.integer.activity_editarCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK && requestCode == R.integer.activity_editarCode) {
            Bundle data = intent.getExtras();
            int i = data.getInt("index");
            Evento evento = eventos.get(i);

            if(data.containsKey("nome"))          { evento.setNome(data.getString("nome")); }
            if(data.containsKey("local"))         { evento.setLocal(data.getString("local")); }
            if(data.containsKey("promotor"))      { evento.setPromotor(data.getString("promotor")); }
            if(data.containsKey("patrocinio"))    { evento.setPatrocinio(data.getString("patrocinio")); }
            if(data.containsKey("capacidade"))    { evento.setCapacidade(data.getInt("capacidade")); }
            if(data.containsKey("dia"))           { evento.setDia(data.getInt("dia")); }
            if(data.containsKey("mes"))           { evento.setMes(data.getInt("mes")); }
            if(data.containsKey("ano"))           { evento.setAno(data.getInt("ano")); }
            if(data.containsKey("valorIngresso")) { evento.setValorIngresso(data.getFloat("valorIngresso")); }

            listAdapter.notifyDataSetChanged();
        }
    }

    private ArrayList<Evento> adicionarEventos() {
        eventos = new ArrayList<Evento>();
        eventos.add(new Evento("Forró do Higor", "Pelinca, n27", 10,12,2017));
        eventos.add(new Evento("Churrasco do Fim de Ano", "Rua das Flores, Condominio Atlantis", 17,12,2017, 20, "Isidoro", "Paul Default", 26));
        Evento e = new Evento("Campeonato de Futsal Ulan", "Osasco, Rua Thomas do Sul, n93",6,2,2018);
        e.setValorIngresso(40);
        eventos.add(e);
        return eventos;

    }
}
