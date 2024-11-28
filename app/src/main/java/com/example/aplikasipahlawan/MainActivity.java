package com.example.aplikasipahlawan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lvdata = findViewById(R.id.lvdatapahlawan);
        ArrayList<String> daftarpahlawan = new ArrayList<>();
        daftarpahlawan.add("Soekarno");
        daftarpahlawan.add("Hatta");
        daftarpahlawan.add("Soedirman");
        daftarpahlawan.add("Pattimura");
        daftarpahlawan.add("Imam Bonjol");

        // Data untuk setiap pahlawan
        HashMap<String, Pahlawan> detailPahlawan = new HashMap<>();
        detailPahlawan.put("Soekarno", new Pahlawan(
                "Ir. Soekarno",
                R.drawable.soekarno,
                "Ir. Soekarno; 6 Juni 1901 – 21 Juni 1970), biasa dipanggil dengan sebutan Bung Karno adalah seorang negarawan, orator, dan Presiden Indonesia pertama yang menjabat sejak tahun 1945 hingga tahun 1967. Ia menjabat sebagai presiden setelah memproklamasikan kemerdekaan Indonesia bersama wakilnya, Mohammad Hatta. Selain dikenal sebagai Bapak Proklamator, Soekarno dikenal juga sebagai pencetus Pancasila, dasar negara dan ideologi bangsa Indonesia."
        ));
        detailPahlawan.put("Hatta", new Pahlawan(
                "Mohammad Hatta",
                R.drawable.hatta,
                "Mohammad Hatta (12 Agustus 1902 – 14 Maret 1980), adalah seorang pejuang kemerdekaan Indonesia dan proklamator yang menjadi wakil presiden pertama Indonesia. Ia juga dikenal sebagai Bapak Koperasi Indonesia."
        ));
        detailPahlawan.put("Soedirman", new Pahlawan(
                "Jenderal Soedirman",
                R.drawable.soedirman,
                "Jenderal Soedirman (24 Januari 1916 – 29 Januari 1950), adalah seorang jenderal besar Indonesia yang memimpin perjuangan kemerdekaan melawan Belanda. Ia terkenal karena memimpin perang gerilya dengan kondisi kesehatan yang buruk."
        ));
        detailPahlawan.put("Pattimura", new Pahlawan(
                "Kapitan Pattimura",
                R.drawable.pattimura,
                "Kapitan Pattimura (Thomas Matulessy, 8 Juni 1783 – 16 Desember 1817) adalah seorang pejuang Maluku yang memimpin perlawanan terhadap penjajahan Belanda pada tahun 1817."
        ));
        detailPahlawan.put("Imam Bonjol", new Pahlawan(
                "Tuanku Imam Bonjol",
                R.drawable.imambonjol,
                "Tuanku Imam Bonjol (1772 – 6 November 1864), adalah seorang ulama dan pemimpin Perang Padri di Sumatra Barat melawan kolonial Belanda."
        ));

        // Buat adapter untuk menghubungkan data ke listview
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, daftarpahlawan
        );

        // menghubungkan listview ke adapter
        lvdata.setAdapter(adapter);

        lvdata.setOnItemClickListener((parent, view, position, id) -> {
            String namaPahlawan = daftarpahlawan.get(position);
            Toast.makeText(MainActivity.this, "Anda memilih " + namaPahlawan, Toast.LENGTH_SHORT).show();

            Pahlawan pahlawan = detailPahlawan.get(namaPahlawan);
            if (pahlawan != null) {
                Intent intent = new Intent(MainActivity.this, DetailList0.class);
                intent.putExtra("nama", pahlawan.nama);
                intent.putExtra("gambar", pahlawan.gambar);
                intent.putExtra("deskripsi", pahlawan.deskripsi);
                startActivity(intent);
            }
        });
    }

    // Inner class untuk menyimpan data pahlawan
    static class Pahlawan {
        String nama;
        int gambar;
        String deskripsi;

        Pahlawan(String nama, int gambar, String deskripsi) {
            this.nama = nama;
            this.gambar = gambar;
            this.deskripsi = deskripsi;
        }
    }
}