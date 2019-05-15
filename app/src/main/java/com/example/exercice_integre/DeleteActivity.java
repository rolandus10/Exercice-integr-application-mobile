package com.example.exercice_integre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        final ProjetBDD actionBDD = new ProjetBDD(this);

        final EditText action_delete = findViewById(R.id.action_delete);


        Button backButton = findViewById(R.id.backButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DeleteActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String  action = action_delete.getText().toString();

             Log.d(" texte", action_delete.getText().toString());

             actionBDD.openForWrite();
             actionBDD.removeProject(action);
             actionBDD.close();

             action_delete.setText("");

             Toast.makeText(getApplicationContext(),"Delete Done",Toast.LENGTH_LONG).show();


            }
        });
    }
}