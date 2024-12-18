package com.example.zadanie56;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int licznikPolubien = 0;
    private String zarejestrowanyEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView licznikPolubienText = findViewById(R.id.licznikpolu);
        Button przyciskLike = findViewById(R.id.przycisklike);
        Button przyciskUnlike = findViewById(R.id.przyciskunlike);
        EditText email = findViewById(R.id.email);
        EditText haslo = findViewById(R.id.haslo);
        EditText powtorzHaslo = findViewById(R.id.powtorzhaslo);
        Button przyciskZapisz = findViewById(R.id.przyciskzapisz);
        Button przyciskZobacz = findViewById(R.id.zobaczuzytkownika);
        TextView obszarKomunikatow = findViewById(R.id.obszarkomunikatow);


        przyciskLike.setOnClickListener(v -> {
            licznikPolubien++;
            licznikPolubienText.setText(licznikPolubien + " polubień");
        });

        przyciskUnlike.setOnClickListener(v -> {
            if (licznikPolubien > 0) licznikPolubien--;
            licznikPolubienText.setText(licznikPolubien + " polubień");
        });

        przyciskZapisz.setOnClickListener(v -> {
            if (!email.getText().toString().contains("@")) {
                obszarKomunikatow.setText("Nieprawidłowy adres e-mail!");
            } else if (!haslo.getText().toString().equals(powtorzHaslo.getText().toString())) {
                obszarKomunikatow.setText("Hasła się różnią!");
            } else {
                zarejestrowanyEmail = email.getText().toString();
                obszarKomunikatow.setText("Zarejestrowano: " + zarejestrowanyEmail);
            }
        });

        przyciskZobacz.setOnClickListener(v -> {
            if (TextUtils.isEmpty(zarejestrowanyEmail)) {
                obszarKomunikatow.setText("Brak zarejestrowanego uczestnika.");
            } else {
                obszarKomunikatow.setText("Zarejestrowany e-mail: " + zarejestrowanyEmail);
            }
        });
    }
}
