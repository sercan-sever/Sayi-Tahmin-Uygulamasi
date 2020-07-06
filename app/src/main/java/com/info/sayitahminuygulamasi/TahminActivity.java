package com.info.sayitahminuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {

    private TextView textViewKalanHak, textViewYardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;

    private int rastgeleSayi;
    private int sayac = 5;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);


        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewYardim = findViewById(R.id.textViewYardim);
        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonTahmin = findViewById(R.id.buttonTahmin);

        Random r = new Random();

        rastgeleSayi = r.nextInt(101);
        Log.e("Rastgele Sayi",String.valueOf(rastgeleSayi));


        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sayac -= 1;

                // editText içindeki veriyi INTEGER a çevirir.....
                int tahmin = Integer.parseInt(editTextGirdi.getText().toString());

                if (tahmin == rastgeleSayi){

                    Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                    i.putExtra("sonuc", true);
                    i.putExtra("deneme",String.valueOf(rastgeleSayi));
                    startActivity(i);

                    finish();

                    return;// butonun çalışmasını o anda durdurur...
                }

                if (tahmin < rastgeleSayi){

                    textViewYardim.setText("Girilen Sayıyı Yükseltiniz");
                    textViewKalanHak.setText("Kalan Hakkın : " + sayac);
                }

                if (tahmin > rastgeleSayi){

                    textViewYardim.setText("Girilen Sayıyı Azaltınız");
                    textViewKalanHak.setText("Kalan Hakkın : " + sayac);
                }

                if (sayac == 0){

                    Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                    i.putExtra("sonuc", false);
                    i.putExtra("deneme",String.valueOf(rastgeleSayi));
                    startActivity(i);

                    finish();
                }


                // son girdiğimiz değerin orada kalmaması için editText in içinin sıfırlanması için kullandık...
                editTextGirdi.setText("");




            }
        });

    }
}
