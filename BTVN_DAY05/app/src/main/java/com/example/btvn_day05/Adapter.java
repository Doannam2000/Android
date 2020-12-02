package com.example.btvn_day05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewhoder> {
    List<Contact> contacts;
    Onclick onclick;

    public void setOnclick(Onclick onclick1) {
        this.onclick = onclick1;
    }

    public Adapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_food__order, parent, false);
        Viewhoder viewhoder = new Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {

        final Contact contact =contacts.get(position);

        holder.tvName.setText(contact.getName());
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.onClickName(contact.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {

        TextView tvName;
        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
