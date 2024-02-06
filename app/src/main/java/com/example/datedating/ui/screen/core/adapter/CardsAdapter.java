package com.example.datedating.ui.screen.core.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datedating.R;
import com.example.datedating.model.Partner;
import com.example.datedating.ui.screen.messages.adapter.MessagesAdapter;
import com.example.datedating.ui.screen.messages.utilities.OnItemClick;
import com.google.android.material.imageview.ShapeableImageView;
import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ViewHolder> {


    public CardsAdapter(String[] listGif) {
        this.listGif = listGif;
    }

    private String[] listGif;

    public class ViewHolder extends  RecyclerView.ViewHolder {
        private ImageView imageView;
        //private TextView textView;
        //private TextView textViewSecond;
        //private VideoView videoView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //videoView = itemView.findViewById(R.id.imageThrid);
            imageView = itemView.findViewById(R.id.imageThrid);
            //textView = itemView.findViewById(R.id.textItemMessagesTitle);
            //textViewSecond = itemView.findViewById(R.id.previewMessage);

        }
        /*public TextView getTextView() {
            return textView;
        }
        public TextView getTextViewSecond() {return textViewSecond;}*/
        public ImageView getImageView(){ return imageView;}
        //public VideoView getVideoView() {return videoView;}

    }
    @NonNull
    @Override
    public CardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cards, parent, false);
        return new CardsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsAdapter.ViewHolder holder, int position) {
        //holder.getTextView().setText(partnerList.get(position).getNamePartner());
        //holder.getTextViewSecond().setText(partnerList.get(position).getMessagePartner());
        //Glide.with(holder.imageView.getContext()).load(partnerList.get(position).getPhotoUrlPartner()).into(holder.imageView);
        //holder.getImageView().setImageResource(listImage[position]);
        //holder.getVideoView().setVideoURI(Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"));
        
        Glide.with(holder.getImageView().getContext()).asGif().load(listGif[position]).into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return listGif.length;
    }

}
