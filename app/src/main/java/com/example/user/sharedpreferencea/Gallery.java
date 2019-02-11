package com.example.user.sharedpreferencea;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Gallery extends AppCompatActivity {

    private static final int GALLERY_REQUEST = 1880;
    Button Gallery, Camera;
    ImageView image;
    static int CAM_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Gallery = findViewById(R.id.galy);
        Camera = findViewById(R.id.imgcamera);
        image = findViewById(R.id.imageView);
    }

    public void galclick(View view) {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }
    public void cmraclick (View view){
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAM_REQUEST);
    }
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (reqCode == GALLERY_REQUEST) {

            if (resultCode == RESULT_OK) {
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    image.setImageBitmap(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(Gallery.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            } else
                Toast.makeText(Gallery.this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
        if (reqCode == CAM_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap mphoto = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(mphoto);
        }
    }




    }

