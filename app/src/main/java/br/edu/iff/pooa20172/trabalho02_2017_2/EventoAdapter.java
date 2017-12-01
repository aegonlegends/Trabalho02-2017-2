package br.edu.iff.pooa20172.trabalho02_2017_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;


public class EventoAdapter extends ArrayAdapter<Evento> {
    private final Context context;
    private final ArrayList<Evento> elementos;

        public EventoAdapter(Context context, ArrayList<Evento> elementos) {
        super(context, R.layout.item_evento, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_evento, parent, false);
        TextView tvNome = (TextView) rowView.findViewById(R.id.nome);
        TextView tvLocal = (TextView) rowView.findViewById(R.id.local);
        TextView tvData = (TextView) rowView.findViewById(R.id.data);
        tvNome.setText(elementos.get(position).getNome());
        tvLocal.setText(elementos.get(position).getLocal());

        String data = String.format(Locale.ENGLISH, "%02d/%02d/%d", elementos.get(position).getDia(),elementos.get(position).getMes(),elementos.get(position).getAno());

        tvData.setText(data);

        return rowView;
    }
}
