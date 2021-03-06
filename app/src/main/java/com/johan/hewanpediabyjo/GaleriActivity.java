//package com.johan.hewanpediabyjo;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//;
//
//import com.johan.hewanpediabyjo.model.Hewan;
//
//import java.util.List;
//
//public class GaleriActivity extends AppCompatActivity {
//
//    List<Hewan> hewans;
//    int indeksTampil = 0;
//    String jenisHewan;
//    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
//    TextView txJenis,txRas,txAsal,txDeskripsi,txJudul;
//    ImageView ivFotoHewan;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profil_ras);
//        Intent intent = getIntent();
//        jenisHewan = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
//        hewans = com.johan.hewanpediabyjo.DataProvider.getHewansByTipe(this,jenisHewan);
//        inisialisasiView();
//        tampilkanProfil();
//    }
//
//    private void inisialisasiView() {
//        btnPertama = findViewById(R.id.btnPertama);
//        btnSebelumnya = findViewById(R.id.btnSebelumnya);
//        btnBerikutnya = findViewById(R.id.btnBerikutnya);
//        btnTerakhir = findViewById(R.id.btnTerakhir);
//
//        btnPertama.setOnClickListener(view -> hewanPertama());
//        btnTerakhir.setOnClickListener(view -> hewanTerakhir());
//        btnSebelumnya.setOnClickListener(view -> hewanSebelumnya());
//        btnBerikutnya.setOnClickListener(view -> hewanBerikutnya());
//
//        txJenis = findViewById(R.id.txJenis);
//        txRas = findViewById(R.id.txRas);
//        txAsal = findViewById(R.id.txAsal);
//        txDeskripsi = findViewById(R.id.txDeskripsi);
//        ivFotoHewan = findViewById(R.id.gambarHewan);
//
//        txJudul = findViewById(R.id.txJudul);
//        txJudul.setText("Ras "+jenisHewan);
//    }
//
//
//    private void tampilkanProfil() {
//        Hewan k = hewans.get(indeksTampil);
//        Log.d("ANJING","Menampilkan anjing "+k.getJenis());
//        txJenis.setText(k.getJenis());
//        txRas.setText(k.getRas());
//        txAsal.setText(k.getAsal());
//        txDeskripsi.setText(k.getDeskripsi());
//        ivFotoHewan.setImageDrawable(this.getDrawable(k.getDrawableRes()));
//    }
//
//    private void hewanPertama() {
//        int posAwal = 0;
//        if (indeksTampil == posAwal) {
//            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            indeksTampil = posAwal;
//            tampilkanProfil();
//        }
//    }
//
//    private void hewanTerakhir() {
//        int posAkhir = hewans.size() - 1;
//        if (indeksTampil == posAkhir) {
//            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            indeksTampil = posAkhir;
//            tampilkanProfil();
//        }
//    }
//
//    private void hewanBerikutnya() {
//        if (indeksTampil == hewans.size() - 1) {
//            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            indeksTampil++;
//            tampilkanProfil();
//        }
//    }
//
//    private void hewanSebelumnya() {
//        if (indeksTampil == 0) {
//            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            indeksTampil--;
//            tampilkanProfil();
//        }
//    }
//}