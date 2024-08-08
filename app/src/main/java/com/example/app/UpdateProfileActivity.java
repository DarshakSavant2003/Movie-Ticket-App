package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateProfileActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText genderEditText;
    private Button updateButton;
    private EditText userEditText;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        nameEditText = findViewById(R.id.editTextName);
        userEditText = findViewById(R.id.editUserName);
        genderEditText = findViewById(R.id.editTextGender);
        updateButton = findViewById(R.id.btnUpdate);

        // Initialize Firebase components
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        // Retrieve the current user
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        // Retrieve the user's current profile data and populate the UI elements
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference userRef = databaseReference.child("users").child(userId);

            userRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        DataSnapshot dataSnapshot = task.getResult();
                        if (dataSnapshot.exists()) {
                            String name = dataSnapshot.child("name").getValue(String.class);
                            String gender = dataSnapshot.child("gender").getValue(String.class);
                            String Username = dataSnapshot.child("username").getValue(String.class);
                            nameEditText.setText(name);
                            genderEditText.setText(gender);
                            userEditText.setText(Username);
                        }
                    }
                }
            });
        }


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the updated name and gender
                String updatedName = nameEditText.getText().toString();
                String updatedGender = genderEditText.getText().toString();
                String updatedUserName = userEditText.getText().toString();
                // Update the user's profile in the database
                if (currentUser != null) {
                    String userId = currentUser.getUid();
                    DatabaseReference userRef = databaseReference.child("users").child(userId);
                    userRef.child("name").setValue(updatedName);
                    userRef.child("gender").setValue(updatedGender);
                    userRef.child("username").setValue(updatedUserName);
                    Toast.makeText(UpdateProfileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
