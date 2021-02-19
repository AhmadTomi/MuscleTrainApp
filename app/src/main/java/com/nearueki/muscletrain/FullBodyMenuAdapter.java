package com.nearueki.muscletrain;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FullBodyMenuAdapter extends RecyclerView.Adapter<FullBodyMenuAdapter.MyViewHolder>{

    Context context;
    public FullBodyMenuAdapter(Context context){
        this.context = context;
    }

    int[][] color_icon_matrix = new int[][]{
            {R.drawable.bg_burpee, 0},
            {android.R.color.white, R.raw.vdfullbody1a},
            {R.drawable.bg_shoulderspress, 0},//2
            {android.R.color.white, R.raw.vdfullbody2a},
            {R.drawable.bg_sidelateral, 0},//4
            {android.R.color.white, R.raw.vdfullbody3a},
            {R.drawable.bg_pushups, 0},//6
            {android.R.color.white, R.raw.vdfullbody4a},
            {android.R.color.white, R.raw.vdfullbody4b},
            {R.drawable.bg_diamondpushups, 0},//9
            {android.R.color.white, R.raw.vdfullbody5a},
            {R.drawable.bg_pullup, 0},//11
            {android.R.color.white, R.raw.vdfullbody6a},
            {R.drawable.bg_bicepscurl, 0},//13
            {android.R.color.white, R.raw.vdfullbody7a},
            {android.R.color.white, R.raw.vdfullbody7b},
            {R.drawable.bg_squat, 0},//16
            {android.R.color.white, R.raw.vdfullbody8a},
            {R.drawable.bg_crunches, 0},//18
            {android.R.color.white, R.raw.vdfullbody9a},


    };

    public class MyViewHolder extends RecyclerView.ViewHolder{
        VideoView video_view;
        RelativeLayout container;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            video_view = (VideoView) itemView.findViewById(R.id.video_view);
            container= (RelativeLayout)itemView.findViewById(R.id.container);
        }
    }

    @NonNull
    @Override
    public FullBodyMenuAdapter.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new FullBodyMenuAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_page,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final FullBodyMenuAdapter.MyViewHolder holder, final int position) {
        if (color_icon_matrix[position][1]==0){
            holder.video_view.setVisibility(View.INVISIBLE);
        }else{
            holder.video_view.setVisibility(View.VISIBLE);
            holder.video_view.setVideoURI(
                    Uri.parse("android.resource://" +context.getPackageName() + "/" + (color_icon_matrix[position][1])));
            MediaController mediaController = new MediaController(context);
            mediaController.setAnchorView(holder.video_view);

            holder.video_view.setMediaController(mediaController);

            holder.video_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer arg0) {
                    holder.video_view.requestFocus();
                    holder.video_view.seekTo(1000);
                    holder.video_view.pause();

                }
            });

        }
        holder.container.setBackgroundResource(color_icon_matrix[position][0]);
    }

    @Override
    public int getItemCount() {
        return color_icon_matrix.length;
    }
}
