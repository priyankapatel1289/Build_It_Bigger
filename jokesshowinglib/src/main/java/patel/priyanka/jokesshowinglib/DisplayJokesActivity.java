package patel.priyanka.jokesshowinglib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    public String JOKE_INTENT = "joke intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        TextView jokeTextView = findViewById(R.id.tv_joke);

        if (getIntent() != null && getIntent().hasExtra("joke intent")) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                String joke = bundle.getString(JOKE_INTENT);
                jokeTextView.setText(joke);
            }

        }
    }
}
