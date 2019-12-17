package moviecatalogue.com.TabLayout;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import moviecatalogue.com.Adpater.MovieAdapter;
import moviecatalogue.com.Data.Movie;
import moviecatalogue.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;
    private ArrayList<Movie> list = new ArrayList<>();

    public MovieFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    // ctrl + spasi

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);

        list.addAll(getListMovie());
        showRecyclerList();
    }

    public ArrayList<Movie> getListMovie(){
        String [] title = getResources().getStringArray(R.array.title);
        String [] des = getResources().getStringArray(R.array.descriptions);
        TypedArray  poster = getResources().obtainTypedArray(R.array.poster);

        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0 ; i< title.length; i++){
            Movie movie = new Movie();
            movie.setTitle(title[i]);
            movie.setDescription(des[i]);
            movie.setPoster(poster.getResourceId(i, -1));

            listMovie.add(movie);
        }

        return listMovie;
    }

    private void showRecyclerList(){
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter adapter = new MovieAdapter(getActivity());
        rvMovie.setAdapter(adapter);
        adapter.setmList(list);

    }
}
