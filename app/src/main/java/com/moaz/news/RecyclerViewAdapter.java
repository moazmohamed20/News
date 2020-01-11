package com.moaz.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moaz.news.newsmodels.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.picasso.transformations.BlurTransformation;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

    Context context;
    List<Article> list;

    public RecyclerViewAdapter(Context context, List<Article> list) {
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
        View row = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter.Holder holder, final int position) {
        holder.text.setText(list.get(position).getTitle());
        Picasso.get().load(list.get(position).getUrlToImage()).transform(new BlurTransformation(context, 25, 1)).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.text.getText().equals(list.get(position).getTitle())) {
                    Picasso.get().load(list.get(position).getUrlToImage()).into(holder.image);
                    holder.text.setText(list.get(position).getDescription());
                } else {
                    Picasso.get().load(list.get(position).getUrlToImage()).transform(new BlurTransformation(context, 25, 1)).into(holder.image);
                    holder.text.setText(list.get(position).getTitle());
                }
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_TEXT, list.get(position).getDescription());
//                context.startActivity(Intent.createChooser(intent, "Share Description To:"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
