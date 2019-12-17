package moviecatalogue.com.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import moviecatalogue.com.Data.Movie;
import moviecatalogue.com.R;

public class DetaiMovieActivity extends AppCompatActivity {

    public static final String EXTRAMOVIE = "extramovie";

    TextView tvDetailTitle, tvDetailDesc;
    ImageView imgDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai_movie);

        tvDetailTitle = findViewById(R.id.tv_detail_title);
        tvDetailDesc = findViewById(R.id.tv_des_detail);
        imgDetail = findViewById(R.id.img_detatail);

        Movie currentMovie = getIntent().getParcelableExtra(EXTRAMOVIE);

        if (getSupportActionBar() !=null){
            int imgRes = currentMovie.getPoster();
            String title = currentMovie.getTitle();
            String des = currentMovie.getDescription();

            tvDetailTitle.setText(title);
            tvDetailDesc.setText(des);
            imgDetail.setImageResource(imgRes);

            getSupportActionBar().setTitle(title);
        }
    }
}
