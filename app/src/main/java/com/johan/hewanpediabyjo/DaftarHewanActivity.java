package com.johan.hewanpediabyjo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johan.hewanpediabyjo.model.Hantu;
import com.johan.hewanpediabyjo.model.Hewan;
import com.johan.hewanpediabyjo.model.Kucing;
import com.johan.hewanpediabyjo.model.Serangga;
import com.johan.hewanpediabyjo.model.Ular;

import java.util.List;

public class DaftarHewanActivity extends AppCompatActivity {
    public final static String HEWAN_TERPILIH ="hewan_obj_key";
    List<Hewan> hewans;
    ListView listView;
    String jenisHewan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hewanactivity);
        Intent intent = getIntent();
        jenisHewan = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar);
        txJudul.setText(getString(R.string.awed)+jenisHewan.toUpperCase());
        hewans = DataProvider.getHewansByTipe(this,jenisHewan);
        String judul="";
        if(hewans.get(0) instanceof Ular){
            judul = getString(R.string.polll);
        }else if(hewans.get(0) instanceof Kucing){
            judul = getString(R.string.pol);
        }else if(hewans.get(0)instanceof Hantu){
            judul = getString(R.string.poll);
        }else if(hewans.get(0)instanceof Serangga) {
            judul = getString(R.string.pollll);
        }
        txJudul.setText(judul);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_hewan);
        DaftarHewanAdapter adapter = new DaftarHewanAdapter(this,hewans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Hewan terpilih = hewans.get(position);
            bukaProfileHewan(terpilih);
        }
    };

    private void bukaProfileHewan(Hewan hewanTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(HEWAN_TERPILIH, hewanTerpilih);
        startActivity(intent);
    }
}
