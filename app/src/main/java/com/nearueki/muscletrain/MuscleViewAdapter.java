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

public class MuscleViewAdapter extends RecyclerView.Adapter<MuscleViewAdapter.MyViewHolder> {

    Context context;
    public MuscleViewAdapter(Context context){
        this.context = context;
    }

    int[][] color_icon_matrix = new int[][]{
            {R.drawable.title_shoulder, 0},
            {android.R.color.white, R.raw.vdmuscle_1a},
            {android.R.color.white, R.raw.vdmuscle_1b},
            {R.drawable.title_back, 0},//3
            {android.R.color.white, R.raw.vdmuscle_2a},
            {android.R.color.white, R.raw.vdmuscle_2b},
            {R.drawable.title_abs, 0},//6
            {android.R.color.white, R.raw.vdmuscle_3a},
            {android.R.color.white, R.raw.vdmuscle_3b},
            {R.drawable.title_triceps, 0},//9
            {android.R.color.white, R.raw.vdmuscle_4a},
            {android.R.color.white, R.raw.vdmuscle_4b},
            {R.drawable.title_biceps, 0},//12
            {android.R.color.white, R.raw.vdmuscle_5a},
            {android.R.color.white, R.raw.vdmuscle_5b},
            {R.drawable.title_legs, 0},//15
            {android.R.color.white, R.raw.vdmuscle_6a},
            {android.R.color.white, R.raw.vdmuscle_6b},
            {android.R.color.white, R.raw.vdmuscle_6c},

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
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_page,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
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
