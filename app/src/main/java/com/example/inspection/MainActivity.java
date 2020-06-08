package com.example.inspection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.inspection.Model.Questions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button buttonpass,buttonfail,buttonna;
    TextView questionstext;
    int total=-1;
    int correct = 0;
    DatabaseReference reference;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonpass = (Button)findViewById(R.id.buttonpass);
        buttonfail = (Button)findViewById(R.id.buttonfail);
        buttonna = (Button)findViewById(R.id.buttonna);


        questionstext = (TextView) findViewById(R.id.questionstext);

        updateQuestion();


    }

    private void updateQuestion() {

        if(total >5){
            //open result activity


        }

        else
        {
            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Questions questions = dataSnapshot.getValue(Questions.class);

                    questionstext.setText(questions.getQuestion());
                    buttonpass.setText(questions.getOption1());
                    buttonpass.setText(questions.getOption2());
                    buttonpass.setText(questions.getOption3());

                    buttonpass.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {



                        }
                    });

                    buttonpass.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    buttonpass.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

    }
}
