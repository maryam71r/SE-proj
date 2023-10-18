package com.example.se_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.se_proj.DatabaseHelper;



public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri; // Variable to store the selected image URI
    private String description = ""; // Initialize the description as an empty string
    private int userId = 123; // Replace with the actual user ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPostButtonClick(View view) {
        // Check if an image has been selected
        if (selectedImageUri != null) {
            String imageUrl = "URL_OF_THE_IMAGE"; // Replace with the actual image URL

            DatabaseHelper dbHelper = new DatabaseHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_IMAGE_URL, imageUrl);
            values.put(DatabaseHelper.COLUMN_DESCRIPTION, description);
            values.put(DatabaseHelper.COLUMN_USER_ID, userId);
            values.put(DatabaseHelper.COLUMN_TIMESTAMP, System.currentTimeMillis());

            long newRowId = db.insert(DatabaseHelper.TABLE_POSTS, null, values);

            db.close();

            // Provide user feedback, such as a success message
            Toast.makeText(this, "Post uploaded successfully!", Toast.LENGTH_SHORT).show();
        } else {
            // Inform the user to select an image before posting
            Toast.makeText(this, "Please select an image before posting.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onImagePickerButtonClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Store the selected image URI for later use
            Uri selectedImageUri = data.getData();

            // Display the selected image in an ImageView (assuming you have one in your layout)
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageURI(selectedImageUri);

            // Perform further processing of the selected image if needed
        }
    }
}

