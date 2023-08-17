package com.example.andymaster.Fragment.CumunitySection.Activites;





import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andymaster.Modelclasses.Post;
import com.example.andymaster.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class PostActivity extends AppCompatActivity {
    private static final int REQUEST_PICK_IMAGE = 1;

    private ImageView imageView;
    private EditText postContentEditText;
    private String imageUrl;
    private Button uploadButton;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private FirebaseStorage storage;
    private Button selectImageButton;

    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

        imageView = findViewById(R.id.imageView);
        postContentEditText = findViewById(R.id.postContentEditText);
        uploadButton = findViewById(R.id.uploadButton);
        selectImageButton = findViewById(R.id.select_image_button);
        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        uploadButton.setOnClickListener(view -> uploadPost());

    }
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, REQUEST_PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
             imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    private void uploadPost() {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.show();
        if (imageUri != null){
            final StorageReference filePath = FirebaseStorage.getInstance()
                    .getReference("Posts").child(System.currentTimeMillis() + "." + getFileExtension(imageUri));

            StorageTask<UploadTask.TaskSnapshot> uploadtask = filePath.putFile(imageUri);
            uploadtask.continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if (!task.isSuccessful()){
                        throw task.getException();
                    }

                    return filePath.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    Uri downloadUri = task.getResult();
                    imageUrl = downloadUri.toString();
                   String description = postContentEditText.getText().toString();
                   String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Posts").child(userid);
                    String postId = ref.push().getKey();
                    Post post = new Post(description ,imageUrl ,postId ,userid);
                    ref.setValue(post);
                    Toast.makeText(PostActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();


                    pd.dismiss();
                    finish();
                }
            });
        } else {
            Toast.makeText(PostActivity.this, "Please select an image", Toast.LENGTH_SHORT).show();
        }
    }
    private String getFileExtension(Uri uri) {

        return MimeTypeMap.getSingleton().getExtensionFromMimeType(this.getContentResolver().getType(uri));

    }
}