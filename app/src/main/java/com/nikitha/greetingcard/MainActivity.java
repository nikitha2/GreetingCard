package com.nikitha.greetingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
public  String toMessage,fromMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonview= (Button) findViewById(R.id.previewbtn);
        Button buttonviewUpload= (Button) findViewById(R.id.changeBackgroundbtn);
        ImageView imageView=(ImageView) findViewById(R.id.imageView);
       final EditText text=(EditText) findViewById(R.id.ToMessage);
       final EditText textfrom=(EditText) findViewById(R.id.from);
        byte[] byteArray1;
       Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            byte[] byteArray = extras.getByteArray("picture");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imageView.setImageBitmap(bmp);

            byteArray1=byteArray;
        }

        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("main activity","toMessage= "+toMessage+" and fromMessage="+fromMessage);

                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(MainActivity.this, PreviewActivity.class);
                intent.putExtra("toMessage", text.getText().toString());
                intent.putExtra("fromMessage",textfrom.getText().toString());

                Bundle extras = getIntent().getExtras();
                if(extras!=null) {
                    intent.putExtra("picture", extras.getByteArray("picture"));
                    // Start the new activity
                    startActivity(intent);
                }
            }
        });
        buttonviewUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(MainActivity.this, ChangeBackgroundActivity.class);
                // Start the new activity
                startActivity(intent);
            }
        });


    }
}
