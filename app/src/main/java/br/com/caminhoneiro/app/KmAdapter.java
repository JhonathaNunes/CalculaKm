package br.com.caminhoneiro.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16254855 on 30/10/2017.
 */

public class KmAdapter extends ArrayAdapter<KmRodados> {

    public KmAdapter(Context context, List<KmRodados> list){

        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v==null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.item_lista, null);

            KmRodados item = getItem(position);

            TextView txtMes = (TextView)v.findViewById(R.id.txtMes);
            TextView txtKm = (TextView)v.findViewById(R.id.txtItem);

            txtMes.setText(item.getMes());
            txtKm.setText(item.getKm().toString()+"Km");
        }
        return v;
    }
}
