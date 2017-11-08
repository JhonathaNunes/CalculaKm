package br.com.caminhoneiro.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class VisualizarKm extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<KmRodados> adapter;
    List<KmRodados> lstMesKm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_km);

        listView = (ListView)findViewById(R.id.lstKms);

        Intent intent = getIntent();

        boolean visualizar = intent.getBooleanExtra("visualizar", false);

        if (visualizar == true){
            lstMesKm = KmRodados.listAll(KmRodados.class);
            adapter = new KmAdapter(this, lstMesKm);
        }else{
            calculaGanho();
            lstMesKm = KmRodados.listAll(KmRodados.class);
            adapter = new GanhoAdapter(this, lstMesKm);
        }

        listView.setAdapter(adapter);
    }

    private void calculaGanho(){
        int i = 1;
        int kmTotal = 0;
        int kmMes;
        double ganho = 0;

        while (i <= KmRodados.listAll(KmRodados.class).size()){
            KmRodados kmR = KmRodados.findById(KmRodados.class, i);

            kmTotal = kmR.getKm() + kmTotal;
            kmMes = kmR.getKm();

            if (kmTotal<4000){
                ganho = (kmMes * 1.5) + ganho;
            }else{
                ganho = (kmMes*1.25) + ganho;
            }

            kmR.setGanho(ganho);
            kmR.save();

            i++;
        }
    }
}
