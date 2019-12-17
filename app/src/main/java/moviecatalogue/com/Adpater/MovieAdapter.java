package moviecatalogue.com.Adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import moviecatalogue.com.Data.Movie;
import moviecatalogue.com.R;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Movie> mList;

    public void setmList(ArrayList<Movie> mList) {
        this.mList = mList;
    }

    public MovieAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_movie
        ,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie currentMuvie = mList.get(position);
        holder.tvTitle.setText(currentMuvie.getTitle());
        holder.tvDecs.setText(currentMuvie.getDescription());
        holder.imgPoster.setImageResource(currentMuvie.getPoster());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDecs;
        ImageView imgPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tc_title);
            tvDecs = itemView.findViewById(R.id.tv_description);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }
    }
}
