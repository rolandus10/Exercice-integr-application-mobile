package com.example.exercice_integre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProjetBDD actionBDD = new ProjetBDD(this);

        final EditText action_add = findViewById(R.id.action_add);
        final EditText duration_add = findViewById(R.id.duration_add);
        final EditText date_add = findViewById(R.id.date_add);

        Button addButton = findViewById(R.id.addButton);
        Button deleteButton =  findViewById(R.id.deleteButton);
        Button actionViewButton =  findViewById(R.id.actionViewButton);
        Button updateButton =  findViewById(R.id.updateButton);



        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        actionViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ActionViewActivity.class);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String action = action_add.getText().toString();
                String date = date_add.getText().toString();
                int duration = Integer.valueOf(duration_add.getText().toString());

                android.util.Log.d(" texte", action_add.getText().toString());
                android.util.Log.d(" texte", date_add.getText().toString());
                android.util.Log.d(" texte", duration_add.getText().toString());

                Projet projet = new Projet();
                projet.setDuree(duration);
                projet.setDate(date);
                projet.setAction(action);


                actionBDD.openForWrite();
                actionBDD.inserProjet(projet);
                actionBDD.close();

                action_add.setText("");
                date_add.setText("");
                duration_add.setText("");

                Toast.makeText(getApplicationContext(),"Add Done",Toast.LENGTH_LONG).show();
            }
        });


    }
}
