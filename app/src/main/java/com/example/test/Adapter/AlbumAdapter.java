package com.example.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.Model.Album;
import com.example.test.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>
{
    private List<Album> albums;
    private int rowLayout;
    private Context context;


    public AlbumAdapter(List<Album> albums, int rowLayout, Context context)
    {
        this.albums = albums;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position)
    {
        String image_url = albums.get(position).getCover();
        Picasso.with(context).load(image_url).placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.albumImage);

        holder.albumTitle.setText(albums.get(position).getTitle());
        holder.musicianName.setText(albums.get(position).getMusician());
    }

    @Override
    public int getItemCount()
    {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout ablumsLayout;
        TextView albumTitle;
        TextView musicianName;
        ImageView albumImage;

        public AlbumViewHolder(@NonNull View v)
        {
            super(v);
            this.ablumsLayout = (LinearLayout) v.findViewById(R.id.albums_layout);
            this.albumImage = (ImageView) v.findViewById(R.id.album_image);
            this.albumTitle = (TextView) v.findViewById(R.id.title);
            this.musicianName = (TextView) v.findViewById(R.id.musician);
        }
    }
}
