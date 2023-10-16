package com.example.se_proj;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPostButtonClick(View view) {
        String imageUrl = "URL_OF_THE_IMAGE"; // Get the URL of the uploaded image
        String description = "USER_DESCRIPTION"; // Get the user's description
        int userId = 123; // Replace with the actual user ID

        // Insert data into the database
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
            // Handle the selected image, e.g., display it in an ImageView
            Uri selectedImageUri = data.getData();
            // Perform further processing of the selected image
        }
    }
}