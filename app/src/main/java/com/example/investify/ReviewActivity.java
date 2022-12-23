package com.example.investify;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.investify.Classes.Reviews;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ReviewActivity extends AppCompatActivity {

    EditText revScore, revTitle, revContent;
    Button submit;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        revScore = findViewById(R.id.userScore);
        revTitle = findViewById(R.id.userTitle);
        revContent = findViewById(R.id.userContent);
        submit = findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String score = revScore.getText().toString();
                String title = revTitle.getText().toString();
                String content = revContent.getText().toString();
                db = FirebaseFirestore.getInstance();
                CollectionReference dbReview = db.collection("Reviews");

                Reviews r = new Reviews(score, title, content);

                dbReview.add(r);
            }
        });
    }
}