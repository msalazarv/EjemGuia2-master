package com.example.guia2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SegundaPantalla extends AppCompatActivity implements View.OnLongClickListener {

    TextView lblNombre;
    ProgressBar ejemPBAR;
    Button btnHola;
    AutoCompleteTextView ACTAnimal;
    String [] animal={"León", "Jirafa", "Oso", "Tigre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Holi");
        }
        String nombre= getIntent().getStringExtra("Nombre");
        String apellido= getIntent().getStringExtra("Apellido");

        lblNombre=findViewById(R.id.lblNombre);
        lblNombre.setText(nombre+" "+apellido);
        ACTAnimal=findViewById(R.id.ACTAnimal);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, animal);

        ACTAnimal.setThreshold(1);
        ACTAnimal.setAdapter(adapter);
        ejemPBAR=findViewById(R.id.ejemPBAR);
        btnHola=findViewById(R.id.btnHola);

        btnHola.setOnLongClickListener(this);
    }

     private void setProgressValue(final int progress){
        ejemPBAR.setProgress(progress);
        Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress+10);
            }
        });
        thread.start();
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.btnHola:
                setProgressValue(0);
                break;
        }
        return false;
    }
}
