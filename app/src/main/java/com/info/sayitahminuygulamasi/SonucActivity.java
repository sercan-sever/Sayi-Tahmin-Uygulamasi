package com.info.sayitahminuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {

    private ImageView imageViewSonuc;
    private TextView textViewSonuc,textViewSonucSayi;
    private Button buttonTekrar;

    private Boolean sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);


        imageViewSonuc = findViewById(R.id.imageViewSonuc);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        textViewSonucSayi = findViewById(R.id.textViewSonucSayi);
        buttonTekrar = findViewById(R.id.buttonTekrar);

        sonuc = getIntent().getBooleanExtra("sonuc",false);
        String gelenMesaj = getIntent().getStringExtra("deneme");


        if (sonuc){

            textViewSonuc.setText("KAZANDINIZ");
            textViewSonucSayi.setText("Tebrikler Çok Zekizisiniz Sayımızı Buldunuz :)");
            imageViewSonuc.setImageResource(R.drawable.mutlu_resim);
        }
        else{

            textViewSonuc.setText("KAYBETTİNİZ");
            textViewSonucSayi.setText("Bulmaya Çalıştığınız Sayı : " + gelenMesaj);
            imageViewSonuc.setImageResource(R.drawable.uzgun_resim);
        }


        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SonucActivity.this, TahminActivity.class));

                finish();



            }
        });



    }
}
