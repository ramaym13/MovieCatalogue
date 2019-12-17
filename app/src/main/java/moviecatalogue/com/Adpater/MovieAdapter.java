package moviecatalogue.com.Adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import moviecatalogue.com.Data.Movie;
import moviecatalogue.com.R;

public class MovieAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Movie> listMovie = new ArrayList<>();

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    public MovieAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return listMovie.size();
    }

    @Override
    public Object getItem(int position) {
        return listMovie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = LayoutInflater.from(mContext).inflate(R.layout.list_item_movie, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);

        return itemView;
    }

    private class ViewHolder{
        TextView tvTitle, tvDesc;
        ImageView imgPoster;

        ViewHolder(View view){
            tvTitle = view.findViewById(R.id.tc_title);
            tvDesc = view.findViewById(R.id.tv_description);
            imgPoster = view.findViewById(R.id.img_poster);
        }

        private void bind(Movie movie){
            tvTitle.setText(movie.getTitle());
            tvDesc.setText(movie.getDescription());
            imgPoster.setImageResource(movie.getPoster());
        }
    }
}
