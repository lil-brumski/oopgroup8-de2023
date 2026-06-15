package com.example.usingjavauibtw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView backGPhoto;
    private Button imageButtom;

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

        backGPhoto = findViewById(R.id.backGroundImage);
        imageButtom = findViewById(R.id.backSetter);

        imageButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_opener_bro = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_opener_bro, 100);
            }
        });
    }

    //@Override
    //protected void OnActivityResult(int requestCode, int resultCode){

    }

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

    public void checkContact(View v){
        findViewById(R.id.button2);

        Intent contactAct = new Intent(this, ContactActivity.class);
        startActivity(contactAct);
    }

    public void photoBro(View v){
        Intent myBro = new Intent(this, MediaStuff.class);
        startActivity(myBro);
    }
}