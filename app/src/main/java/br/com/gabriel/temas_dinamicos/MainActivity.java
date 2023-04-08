package br.com.gabriel.temas_dinamicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnTheme1, btnTheme2, btnTheme3, btnTheme4;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme();
        setContentView(R.layout.activity_main);
        setBtn();
    }

    private void setBtn() {
        btnTheme1 = findViewById(R.id.btnTheme1);
        btnTheme2 = findViewById(R.id.btnTheme2);
        btnTheme3 = findViewById(R.id.btnTheme3);
        btnTheme4 = findViewById(R.id.btnTheme4);

        btnTheme1.setOnClickListener(this);
        btnTheme2.setOnClickListener(this);
        btnTheme3.setOnClickListener(this);
        btnTheme4.setOnClickListener(this);
    }

    private void setTheme() {
        sharedPreferences = getSharedPreferences("Tema", Context.MODE_PRIVATE);
        int slectedTheme = sharedPreferences.getInt("SelectedTheme", 0);
        setDynamicTheme(slectedTheme);
    }

    private void setDynamicTheme(int slectedTheme) {
        switch (slectedTheme){
            case 1:
                MainActivity.this.setTheme(R.style.DynamicTheme1);
                break;
            case 2:
                MainActivity.this.setTheme(R.style.DynamicTheme2);
                break;
            case 3:
                MainActivity.this.setTheme(R.style.DynamicTheme3);
                break;
            case 4:
                MainActivity.this.setTheme(R.style.DynamicTheme4);
                break;
        }
    }
    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        switch (view.getId()){
            case R.id.btnTheme1:
                editor.putInt("SelectedTheme", 1);
                break;
            case R.id.btnTheme2:
                editor.putInt("SelectedTheme", 2);
                break;
            case R.id.btnTheme3:
                editor.putInt("SelectedTheme", 3);
                break;
            case R.id.btnTheme4:
                editor.putInt("SelectedTheme", 4);
                break;
        }
        editor.apply();
        startActivity(new Intent(MainActivity.this, MainActivity.class));
        finish();
    }
}