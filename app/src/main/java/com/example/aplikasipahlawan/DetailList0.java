package com.example.aplikasipahlawan;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DetailList0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_list0);

        // Ambil data dari intent
        String nama = getIntent().getStringExtra("nama");
        int gambar = getIntent().getIntExtra("gambar", 0);
        String deskripsi = getIntent().getStringExtra("deskripsi");

        // Hubungkan dengan layout
        ImageView imageView = findViewById(R.id.imageView);
        TextView tvNama = findViewById(R.id.tvnama);
        TextView tvDeskripsi = findViewById(R.id.tv2);

        // Set data ke layout
        imageView.setImageResource(gambar);
        tvNama.setText(nama);
        tvDeskripsi.setText(deskripsi);
    }
}