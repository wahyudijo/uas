package com.johan.hewanpediabyjo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKucing,btnHantu,btnUlar,btnSerangga;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnKucing = findViewById(R.id.btn_buka_ras_kucing);
        btnHantu = findViewById(R.id.btn_buka_ras_hantu);
        btnUlar = findViewById(R.id.btn_buka_ras_ular);
        btnSerangga = findViewById(R.id.btn_buka_ras_serangga);
        btnKucing.setOnClickListener(view -> bukaGaleri("Kucing"));
        btnHantu.setOnClickListener(view -> bukaGaleri("Hantu"));
        btnUlar.setOnClickListener(view -> bukaGaleri("Ular"));
        btnSerangga.setOnClickListener(view -> bukaGaleri("Serangga"));
    }

    private void bukaGaleri(String jenisHewan) {
        Log.d("MAIN","Buka activity kucing");
        Intent intent = new Intent(this, DaftarHewanActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisHewan);
        startActivity(intent);
    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, BiodataActivity.class);
        startActivity(intent);
    }
}