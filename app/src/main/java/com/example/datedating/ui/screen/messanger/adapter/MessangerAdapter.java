package com.example.datedating.ui.screen.messanger.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datedating.R;

public class MessangerAdapter extends RecyclerView.Adapter<MessangerAdapter.ViewHolder> {
    private final String[] localTextInput;
    private final String localTextInputTitle;
    //private final String[] localTextOutput;
    private boolean messeageInput;
    private final int[] lenght;



    public MessangerAdapter(String[] localTextInput, String localTextInputTitle,/* String[] localTextOutput, boolean messeageInput,*/ int[] lenght) {
        this.localTextInput = localTextInput;
        this.localTextInputTitle = localTextInputTitle;
        //this.localTextOutput = localTextOutput;
        //this.messeageInput = messeageInput;
        this.lenght = lenght;
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder {
        private final TextView titleInputMessenger;
        private final TextView textInputMessenger;
        private final TextView textOutputMessenger;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textOutputMessenger = itemView.findViewById(R.id.textOutputMessager);
            titleInputMessenger = itemView.findViewById(R.id.titleInputMessager);
            textInputMessenger = itemView.findViewById(R.id.textInputMessager);

        }
        public TextView getTitleInputMessenger() {
            return titleInputMessenger;
        }
        public TextView getTextInputMessenger(){
            return textInputMessenger;
        }
        public TextView getTextOutputMessenger() {return textOutputMessenger;}
    }
    @NonNull
    @Override
    public MessangerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //if (messeageInput) {
            View viewInput = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inputmessage, parent, false);
            //messeageInput = false;
            return new MessangerAdapter.ViewHolder(viewInput);
        /*} else {
            View viewOutput = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_outputmessage, parent, false);
            return new MessangerAdapter.ViewHolder(viewOutput);
        }*/
    }

    @Override
    public void onBindViewHolder(@NonNull MessangerAdapter.ViewHolder holder, int position) {
        //if (messeageInput){
            holder.getTextInputMessenger().setText(localTextInput[position]);
            holder.getTitleInputMessenger().setText(localTextInputTitle);
        /*}if (!messeageInput){
            holder.getTextOutputMessager().setText(localTextOutput[position]);
        }*/

    }

    @Override
    public int getItemCount() {
        return lenght.length;
    }

}
