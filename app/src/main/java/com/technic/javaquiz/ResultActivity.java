package com.technic.javaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score)
        {
            case 0: t.setText("0 Correct and 5 incorrect answers");
                break;
            case 1: t.setText("1 Correct and 4 incorrect answers");
                break;
            case 2: t.setText("2 Correct and 3 incorrect answers");
                break;
            case 3: t.setText("3 Correct and 2 incorrect answers");
                break;
            case 4:t.setText("4Correct and 1 incorrect answers");
                break;
            case 5:t.setText("5 Correct and 0 incorrect answers");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, QuizActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}