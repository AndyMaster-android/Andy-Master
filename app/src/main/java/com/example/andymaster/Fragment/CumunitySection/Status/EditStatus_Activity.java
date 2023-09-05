package com.example.andymaster.Fragment.CumunitySection.Status;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.andymaster.Fragment.CumunitySection.Status.Model.StatusItem;
import com.example.andymaster.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EditStatus_Activity extends AppCompatActivity {
    private ImageView mImageView;
    private EditText mEditText;
    private FloatingActionButton mFab;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseStorage mFirebaseStorage;
    private DatabaseReference mStatusReference;
    private StorageReference mStatusStorageReference;

    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_status);
        mImageView = findViewById(R.id.preview_image);
        mEditText = findViewById(R.id.et_caption);
        mFab = findViewById(R.id.fab_send_status);

        selectedImageUri = Uri.parse(getIntent().getStringExtra("image_url"));


       // Glide.with(EditStatus_Activity.this).load(selectedImageUri).into(mImageView);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMediaStatus();
            }
        });

    }



    private void sendMediaStatus() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseStorage = FirebaseStorage.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mStatusReference = mFirebaseDatabase.getReference().child("status");
        mStatusStorageReference = mFirebaseStorage.getReference().child("status").child(mFirebaseUser.getUid());

        final long timestamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        final long expireTime = timestamp + TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES);

        mImageView.setDrawingCacheEnabled(true);
        mImageView.buildDrawingCache();
        Bitmap bitmap = mImageView.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        final String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);

        final StorageReference mediaReference = mStatusStorageReference.child(selectedImageUri.getLastPathSegment());
        mediaReference.putFile(selectedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                mediaReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        DatabaseReference newRef = mStatusReference.child(mFirebaseUser.getUid()).child("statusItem").push();
                        StatusItem statusItem = new StatusItem(newRef.getKey(), "image", uri.toString(), mEditText.getText().toString(), timestamp, expireTime,
                                encoded, null);
                        newRef.setValue(statusItem);
                        Toast.makeText(EditStatus_Activity.this, "Status Updated", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

            }
        });
    }
}