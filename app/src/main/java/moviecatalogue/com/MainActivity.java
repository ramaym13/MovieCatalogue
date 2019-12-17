package moviecatalogue.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import moviecatalogue.com.Activity.DetaiMovieActivity;
import moviecatalogue.com.Adpater.MovieAdapter;
import moviecatalogue.com.Data.Movie;

public class MainActivity extends AppCompatActivity {

    private String [] title;
    private String [] descriptio;
    private TypedArray poster;
    private MovieAdapter mAdapter;
    private ArrayList<Movie> listMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new MovieAdapter(this);
        ListView lvList = findViewById(R.id.lv_movie);
        lvList.setAdapter(mAdapter);

        prepare();

        addItem();

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = listMovie.get(position);

                Intent intent = new Intent(MainActivity.this, DetaiMovieActivity.class);
                intent.putExtra(DetaiMovieActivity.EXTRAMOVIE, movie);

                startActivity(intent);
            }
        });
    }

    private void addItem() {
       listMovie = new ArrayList<>();

       for (int i = 0; i < title.length; i++){
           Movie movie = new Movie();
           movie.setTitle(title[i]);
           movie.setDescription(descriptio[i]);
           movie.setPoster(poster.getResourceId(i, -1));
           listMovie.add(movie);
       }

       mAdapter.setListMovie(listMovie);
    }

    private void prepare() {
        title = getResources().getStringArray(R.array.title);
        descriptio = getResources().getStringArray(R.array.descriptions);
        poster = getResources().obtainTypedArray(R.array.poster);
    }
}
