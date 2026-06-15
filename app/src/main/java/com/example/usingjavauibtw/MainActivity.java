package com.example.usingjavauibtw;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /*
    public void disable(View v){
        v.setEnabled(false);

        Button b = (Button)v;
        b.setText("Sup bro?");

        Log.d("Success", "Disabled button");
    }
    */

    public void handleText(View v){
        EditText t = findViewById(R.id.editTextText1);
        String aboutYou = t.getText().toString();

        ((TextView)findViewById(R.id.textView4)).setText(aboutYou);

        Toast.makeText(this, aboutYou, Toast.LENGTH_LONG).show();
        Log.d("About", aboutYou);
    }

    public void checkAbout(View v){
        findViewById(R.id.button4);

        Intent aboutAct = new Intent(this, AboutActivity.class);
        startActivity(aboutAct);
    }

    public void photoBro(View v){
        Intent myBro = new Intent(this, MediaStuff.class);
        startActivity(myBro);
    }
}