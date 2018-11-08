package com.example.manikgupta.gmailuiclone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Manik Gupta on 27-03-2018.
 */

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.MyViewHolder> {

    private int mNoOfItems;

    public MailAdapter(int numberOfItems) {
        super();
        mNoOfItems = numberOfItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_view_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.circularImageView.setImageResource(R.drawable.image);
        holder.senderTextView.setText(R.string.senderTextView);
        holder.dateTextView.setText(R.string.dateTextView);
        holder.subjectTextView.setText(R.string.subjectTextView);
        holder.messageTextView.setText(R.string.messageTextView);
    }

    @Override
    public int getItemCount() {
        return mNoOfItems;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView circularImageView;
        TextView senderTextView;
        TextView dateTextView;
        TextView subjectTextView;
        TextView messageTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            circularImageView = itemView.findViewById(R.id.circular_image);
            senderTextView = itemView.findViewById(R.id.sender);
            dateTextView = itemView.findViewById(R.id.time);
            subjectTextView = itemView.findViewById(R.id.subject);
            messageTextView = itemView.findViewById(R.id.body_mail);

        }
    }
}
