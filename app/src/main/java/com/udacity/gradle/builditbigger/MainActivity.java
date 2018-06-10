package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import patel.priyanka.jokesshowinglib.DisplayJokesActivity;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.EndpointAsyncTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {

        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onTaskComplete(String result) {
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        Intent intentToDisplayJoke = new Intent(MainActivity.this, DisplayJokesActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(new DisplayJokesActivity().JOKE_INTENT, result);
        intentToDisplayJoke.putExtras(bundle);
        startActivity(intentToDisplayJoke);
    }
}
