package com.example.exercice_integre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        final ProjetBDD actionBDD = new ProjetBDD(this);

        final EditText action_update = findViewById(R.id.action_update);
        final EditText duration_update = findViewById(R.id.duration_update);
        final EditText date_update = findViewById(R.id.date_update);
        final EditText id_update = findViewById(R.id.id_update);

        Button backButton = findViewById(R.id.backButton);
        Button updateButton = findViewById(R.id.updateButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = action_update.getText().toString();
                String date = date_update.getText().toString();
                int duration = Integer.valueOf(duration_update.getText().toString());
                int id = Integer.valueOf(id_update.getText().toString());


                Log.d(" texte", action_update.getText().toString());
                Log.d(" texte", date_update.getText().toString());
                Log.d(" texte", duration_update.getText().toString());
                Log.d(" texte", id_update.getText().toString());

                Projet projet = new Projet();
                projet.setDuree(duration);
                projet.setDate(date);
                projet.setAction(action);


                actionBDD.openForWrite();
                actionBDD.updateProject(id,projet);
                actionBDD.close();

                action_update.setText("");
                date_update.setText("");
                duration_update.setText("");
                id_update.setText("");

                Toast.makeText(getApplicationContext(),"Update Done",Toast.LENGTH_LONG).show();
            }
        });
    }


}