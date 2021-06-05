package com.rezky.utspratik_if1_10118016_rezkynurfauzi;

/*
 * NIM   : 10118016
 * NAMA  : Rezky Nur Fauzi
 * KELAS : IF1
 * TGL   : 05/06/2021
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class    Konfirmasi extends AppCompatActivity {
    public static final String Extra_NAMA = "com.rezky.utspraktik_if1_10118016_rezkynurfauzi.NAMA";
    public static final String Extra_nik = "com.rezky.utspraktik_if1_10118016_rezkynurfauzi.nik";
    public static final String Extra_tgl = "com.rezky.utspraktik_if1_10118016_rezkynurfauzi.tgl";
    public static final String Extra_jk = "com.rezky.utspraktik_if1_10118016_rezkynurfauzi.jk";
    public static final String Extra_hub = "com.rezky.utspraktik_if1_10118016_rezkynurfauzi.hub";
    public static final String Extra_status = "com.rezky.utspraktik_if1_10118016_rezkynurfauzi.status";

    private Dialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        Intent intent = getIntent();
        Intent intent2 = new Intent(this,MainActivity.class);

        String nik = intent.getStringExtra(MainActivity.Extra_nik);
        String nama = intent.getStringExtra(MainActivity.Extra_NAMA);
        String jk = intent.getStringExtra(MainActivity.Extra_jk);
        String tgl = intent.getStringExtra(MainActivity.Extra_tgl);
        String hub = intent.getStringExtra(MainActivity.Extra_hub);

        TextView tvNik = findViewById(R.id.j_nik);
        TextView tvNama = findViewById(R.id.j_nama);
        TextView tvTgl = findViewById(R.id.j_tgl);
        TextView tvHub = findViewById(R.id.j_hub);
        TextView tvJk = findViewById(R.id.j_jk);
        Button btn_simpan= findViewById(R.id.btn_simpan);
        Button btn_ubah= findViewById(R.id.btn_ubah);

        tvNik.setText(nik);
        tvNama.setText(nama);
        tvTgl.setText(tgl);
        tvJk.setText(jk);
        tvHub.setText(hub);
        initCustomDialog();

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.show();
            }
        });

        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra(Extra_status,"ubah");
                intent2.putExtra(Extra_nik,nik);
                intent2.putExtra(Extra_NAMA,nama);
                intent2.putExtra(Extra_tgl,tgl);
                intent2.putExtra(Extra_jk,jk);
                intent2.putExtra(Extra_hub,hub);

//                if (hub == "Orang Tua"){
//                    intent2.putExtra(Extra_hub,"hbg_ort");
//                }

                startActivity(intent2);
            }
        });
    }

    private void initCustomDialog(){

        customDialog = new Dialog(Konfirmasi.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.activity_simpan);
        customDialog.setCancelable(true);



        Button btnok = customDialog.findViewById(R.id.btn_ok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog.dismiss();
            }
        });
    }
}