package com.example.datedating.ui.screen.messages.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.datedating.R;
import com.example.datedating.model.Partner;
import com.example.datedating.ui.screen.messages.utilities.OnItemClick;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    private OnItemClick onItemClick;
    private List<Partner> partnerList;
    public MessagesAdapter(List<Partner> partnerList, OnItemClick onItemClick) {
        this.partnerList = partnerList;
        this.onItemClick = onItemClick;
    }



    public class ViewHolder extends  RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textViewSecond;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageItemMessagesProfile);
            textView = itemView.findViewById(R.id.textItemMessagesTitle);
            textViewSecond = itemView.findViewById(R.id.previewMessage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClick != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            onItemClick.onItemClick(pos);
                        }
                    }
                }
            });
        }
        public TextView getTextView() {
            return textView;
        }
        public ImageView getImageView(){ return imageView;}
        public TextView getTextViewSecond() {return textViewSecond;}
    }
    @NonNull
    @Override
    public MessagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(partnerList.get(position).getNamePartner());
        holder.getTextViewSecond().setText(partnerList.get(position).getMessagePartner());
        //Glide.with(holder.imageView.getContext()).load(partnerList.get(position).getPhotoUrlPartner()).into(holder.imageView);
        Glide.with(holder.imageView.getContext()).asGif().load(partnerList.get(position).getImagePartner()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return partnerList.size();
    }

}
