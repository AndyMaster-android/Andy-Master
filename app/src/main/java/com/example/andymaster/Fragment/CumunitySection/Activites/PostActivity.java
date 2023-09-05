package com.example.andymaster.Fragment.CumunitySection.Activites;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.andymaster.Fragment.CumunitySection.Status.Model.Status;
import com.example.andymaster.Fragment.CumunitySection.Status.Model.UserStatus;
import com.example.andymaster.Modelclasses.Post;
import com.example.andymaster.Modelclasses.Users;
import com.example.andymaster.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.storage.FirebaseStorage;

import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostActivity extends AppCompatActivity {
    private static final int REQUEST_PICK_IMAGE = 1;
    CircleImageView avatar;
    private ImageView imageView, selectImageButton, toolbar_back_button;
    EditText postContentEditText;
    private String imageUrl;

    FloatingActionButton uploadButton;
    private AppCompatButton statusButton, postButton;
    private boolean isStatusSelected = false;
    private boolean isPostSelected = false;
    StorageReference storageReference = FirebaseStorage.getInstance().getReference("Posts");

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    FirebaseDatabase database;
    private FirebaseStorage mFirebaseStorage;
   // private DatabaseReference database;
    private StorageReference mStatusStorageReference;

    ProgressDialog pd;

    private Uri imageUri;
    AppCompatButton status, post;
    Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        selectImageButton = findViewById(R.id.image_select);
        imageView = findViewById(R.id.preview_image);
        postContentEditText = findViewById(R.id.et_caption);
        statusButton = findViewById(R.id.statusButton);
        toolbar_back_button = findViewById(R.id.toolbar_back_button);
        postButton = findViewById(R.id.postButton);
        uploadButton = findViewById(R.id.uploadButton);
        avatar = findViewById(R.id.avatar);

        pd = new ProgressDialog(this);
        mFirebaseStorage = FirebaseStorage.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        database = FirebaseDatabase.getInstance();
        mStatusStorageReference = mFirebaseStorage.getReference().child("status").child(mFirebaseUser.getUid());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String profileId = user.getUid();


        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (isPostSelected && isStatusSelected) {

                    upload();
                    sendMediaStatus();
                } else if (isStatusSelected) {
                    sendMediaStatus();
                } else if (isPostSelected) {
                    upload();
                } else {
                    Toast.makeText(PostActivity.this, "Please select Your community", Toast.LENGTH_SHORT).show();
                }
            }
        });


        FirebaseDatabase.getInstance().getReference().child("Users").child(profileId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Users user = dataSnapshot.getValue(Users.class);

                Picasso.get().load(user.getImageurl()).into(avatar);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        toolbar_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });



    }

    private void sendMediaStatus() {

        pd.setMessage("Uploading");
        pd.show();

        FirebaseStorage storage = FirebaseStorage.getInstance();
        Date date = new Date();
        StorageReference statusfile = storage.getReference().child("status").child(System.currentTimeMillis() + "." + getFileExtension(imageUri));

        StorageTask uploadtask = statusfile.putFile(imageUri);

        uploadtask.continueWithTask(new Continuation() {
            @Override
            public Object then(@NonNull Task task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }

                return statusfile.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                Uri downloadUri = task.getResult();
                imageUrl = downloadUri.toString();
/*
                UserStatus userStatus = new UserStatus();
                Users user = new Users();
                userStatus.setName(user.getName());
                userStatus.setProfileImage(user.getImageurl());
                userStatus.setLastUpdated(date.getTime());

                HashMap<String, Object> obj = new HashMap<>();
                obj.put("name", userStatus.getName());
                obj.put("profileImage", userStatus.getProfileImage());
                obj.put("lastUpdated", userStatus.getLastUpdated());
                userStatus.setLastUpdated(date.getTime());
               // String desciption = postContentEditText.getText().toString();

                Status status = new Status(imageUrl, userStatus.getLastUpdated());

                database = FirebaseDatabase.getInstance().getReference();
                database.child("status").setValue(status);

                pd.dismiss();

 */

                UserStatus userStatus = new UserStatus();
                Users user = new Users();
                userStatus.setName(user.getName());
                userStatus.setProfileImage(user.getImageurl());
                userStatus.setLastUpdated(date.getTime());

                HashMap<String, Object> obj = new HashMap<>();
                obj.put("name", userStatus.getName());
                obj.put("profileImage", userStatus.getProfileImage());
                obj.put("lastUpdated", userStatus.getLastUpdated());


                Status status = new Status(imageUrl, userStatus.getLastUpdated());

                database.getReference()
                        .child("stories")
                        .child(FirebaseAuth.getInstance().getUid())
                        .updateChildren(obj);

                database.getReference().child("stories")
                        .child(FirebaseAuth.getInstance().getUid())
                        .child("statuses")
                        .push()
                        .setValue(status);
            }
        });
    }


    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, REQUEST_PICK_IMAGE);
    }

    private void upload() {


        pd.setMessage("Uploading");
        pd.show();

        if (imageUri != null) {
            final StorageReference filePath = FirebaseStorage.getInstance().getReference("Posts")
                    .child(System.currentTimeMillis() + "." + getFileExtension(imageUri));

            StorageTask uploadtask = filePath.putFile(imageUri);
            uploadtask.continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }

                    return filePath.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    Uri downloadUri = task.getResult();
                    imageUrl = downloadUri.toString();
                    String desciption = postContentEditText.getText().toString();
                    String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Posts");
                    String postId = ref.push().getKey();
                    long timestamp = System.currentTimeMillis();
                    Post post = new Post(desciption, imageUrl, postId, userid);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("postid", postId);
                    map.put("imageurl", imageUrl);
                    map.put("description", postContentEditText.getText().toString());
                    map.put("publisher", userid);

                    ref.child(postId).setValue(map);
                    Toast.makeText(PostActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();

                    pd.dismiss();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(PostActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "No image was selected!", Toast.LENGTH_SHORT).show();
        }

    }

    private String getFileExtension(Uri uri) {

        return MimeTypeMap.getSingleton().getExtensionFromMimeType(this.getContentResolver().getType(uri));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    private boolean isValidHashtags(String caption) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(caption);
        return matcher.matches();
    }

    public void onPostButtonClick(View view) {
        if (imageUri != null) {
            isPostSelected = !isPostSelected;
            updateButtonUI();
        } else {
            Toast.makeText(this, "Please select Image", Toast.LENGTH_SHORT).show();
        }
    }

    public void onStatusButtonClick(View view) {
        if (imageUri != null) {
            isStatusSelected = !isStatusSelected;
            updateButtonUI();
        } else {
            Toast.makeText(this, "Please select Image", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateButtonUI() {
        // Update button UI based on selected states
        statusButton.setActivated(isStatusSelected);
        postButton.setActivated(isPostSelected);
        if (isStatusSelected) {
            statusButton.setBackgroundResource(R.drawable.button_selected_background);
        } else {
            statusButton.setBackgroundResource(R.drawable.button_normal_background);
        }

        if (isPostSelected) {
            postButton.setBackgroundResource(R.drawable.button_selected_background);
        } else {
            postButton.setBackgroundResource(R.drawable.button_normal_background);
        }

    }

    private void disableButtons() {
        if (imageUri == null) {
            postButton.setEnabled(false);
            statusButton.setEnabled(false);
        }
    }
}