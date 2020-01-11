package com.moaz.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.moaz.news.giphymodels.Datum;
import com.moaz.news.giphymodels.Images;
import com.moaz.news.giphymodels.PreviewGif;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GifsRecyclerViewAdapter extends RecyclerView.Adapter<GifsRecyclerViewAdapter.Holder> {

    Context context;
    List<Datum> list;

    public GifsRecyclerViewAdapter(Context context, List<Datum> list) {
        this.context = context;
        this.list = list;
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;

        public Holder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.row_gif, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final GifsRecyclerViewAdapter.Holder holder, final int position) {
        holder.text.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImages().getDownsized().getUrl()).apply(new RequestOptions()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
