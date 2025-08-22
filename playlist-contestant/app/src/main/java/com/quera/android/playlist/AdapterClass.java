// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package com.quera.android.playlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ItemViewHolder>{

    private ArrayList<ItemModel> musicList;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music_item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TextView musicName = holder.musicName;
        TextView musicDetail = holder.musicDetail;

        musicName.setText(musicList.get(position).getTitleString());
        musicDetail.setText(musicList.get(position).getSongArtist());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView musicName;
        TextView musicDetail;

        ItemViewHolder(View itemView) {
            super(itemView);
            musicName = itemView.findViewById(R.id.music_name);
            musicDetail = itemView.findViewById(R.id.music_detail);
        }
    }

    AdapterClass(ArrayList<ItemModel> musicList) {
        this.musicList = musicList;
    }
}
