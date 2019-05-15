package com.example.exercice_integre;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class ActionViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_view);

        final ProjetBDD actionBDD = new ProjetBDD(this);

        EditText display = findViewById(R.id.display);
        EditText sumDisplay = findViewById(R.id.sumDisplay);

        Button backButton = findViewById(R.id.backButton);


        actionBDD.openForRead();
        ArrayList<Projet> projectList = actionBDD.getAllproject();


        display.setText(projectList.toString());
        sumDisplay.setText(actionBDD.sum());




        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActionViewActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });





    }
}
