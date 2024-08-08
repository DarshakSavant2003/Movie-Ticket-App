package com.example.app;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText name;
    private Button registerButton;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page); // Set your layout XML file

        // Initialize UI elements
        usernameEditText = findViewById(R.id.etNewUsername);
        passwordEditText = findViewById(R.id.etNewPassword);
        registerButton = findViewById(R.id.btnRegister);
        name= findViewById(R.id.etName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        firebaseAuth = FirebaseAuth.getInstance();
        // Initialize the Firebase Realtime Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        // Set a click listener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered username and password
                final String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String namet = name.getText().toString();
                int selectedRadioButtonId = radioGroupGender.getCheckedRadioButtonId();
                final String gender;
                if (selectedRadioButtonId == R.id.radioButtonMale) {
                    gender = "Male";
                } else if (selectedRadioButtonId == R.id.radioButtonFemale) {
                    gender = "Female";
                } else {
                    Toast.makeText(RegisterActivity.this, "Please select a gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Use Firebase Authentication to create a new user
                firebaseAuth.createUserWithEmailAndPassword(username, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Successful registration, add user information to the Firebase Realtime Database
                                    UserInformation userInformation = new UserInformation(username, namet,gender);
                                    databaseReference.child("users").child(firebaseAuth.getCurrentUser().getUid()).setValue(userInformation);

                                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Registration failed, display an error message
                                    Toast.makeText(RegisterActivity.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
