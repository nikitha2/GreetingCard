package com.nikitha.greetingcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

public class ChangeBackgroundActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1;
    ImageView imageView;
    private static final int PICK_IMAGE_ID = 1; // the number doesn't matter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Change Background");

        View mainLayout = findViewById(R.id.FunActivity);
        Intent chooseImageIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICK_IMAGE_ID:
                Bitmap bitmap = ImagePicker.getImageFromResult(this, resultCode, data);
                // TODO use bitmap
                //View mainLayout = findViewById(R.id.FunActivity);
                //LayoutInflater inflater = getLayoutInflater();
                //View view = inflater.inflate(R.layout.activity_main, (ConstraintLayout) mainLayout, false);
                //ImageView image= (ImageView) findViewById(R.id.imageView);  /* Get the widget with id name which is defined in the another_xml of the row */
                Intent intent = new Intent(ChangeBackgroundActivity.this, MainActivity.class);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                intent.putExtra("picture", byteArray);
                startActivity(intent);
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}