package moviecatalogue.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import moviecatalogue.com.Adpater.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

//    private String [] title;
//    private String [] descriptio;
//    private TypedArray poster;
//    private MovieAdapter mAdapter;
//    private ArrayList<Movie> listMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        getSupportActionBar().setElevation(0);

//        mAdapter = new MovieAdapter(this);
//        ListView lvList = findViewById(R.id.lv_movie);
//        lvList.setAdapter(mAdapter);
//
//        prepare();
//
//        addItem();
//
//        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Movie movie = listMovie.get(position);
//
//                Intent intent = new Intent(MainActivity.this, DetaiMovieActivity.class);
//                intent.putExtra(DetaiMovieActivity.EXTRAMOVIE, movie);
//
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.settings){
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    //    private void addItem() {
//       listMovie = new ArrayList<>();
//
//       for (int i = 0; i < title.length; i++){
//           Movie movie = new Movie();
//           movie.setTitle(title[i]);
//           movie.setDescription(descriptio[i]);
//           movie.setPoster(poster.getResourceId(i, -1));
//           listMovie.add(movie);
//       }
//
//       mAdapter.setListMovie(listMovie);
//    }
//
//    private void prepare() {
//        title = getResources().getStringArray(R.array.title);
//        descriptio = getResources().getStringArray(R.array.descriptions);
//        poster = getResources().obtainTypedArray(R.array.poster);
//    }
}
