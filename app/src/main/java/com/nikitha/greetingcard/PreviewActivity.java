package com.nikitha.greetingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Preview");
        TextView textTo=(TextView) findViewById(R.id.ToMessagePrev);
        TextView textFrom=(TextView) findViewById(R.id.fromPrev);

        String textto = getIntent().getStringExtra("toMessage"); // to read the data to message set in main activity
        String textfrom=getIntent().getStringExtra("fromMessage"); // to read the data from message set in main activity
        textTo.setText(textto);
        ImageView imageView=(ImageView) findViewById(R.id.imageView) ;
        textFrom.setText(textfrom);
        final Button btn = (Button) findViewById(R.id.send);

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            byte[] byteArray = extras.getByteArray("picture");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imageView.setImageBitmap(bmp);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap b = Screenshot.takescreenshotOfRootView(btn);

                // to crop image
               //  b = Bitmap.createBitmap(b,b.getWidth()/3-b.getWidth()/5,b.getHeight()/3-b.getHeight()/5,b.getWidth(),b.getHeight());

                String pathofBmp=MediaStore.Images.Media.insertImage(getContentResolver(), b,"CardFinal", null);
                Uri uri = Uri.parse(pathofBmp);

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);

                sendIntent.setType("image/*");
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Star App");
                sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
                sendIntent.putExtra("crop", "true");
                startActivity(sendIntent);
            }
        });
    }


}
