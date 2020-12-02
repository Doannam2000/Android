package com.example.webapi_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import android.content.Context;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Viewhoder> {

    List<Contact> contacts;
    private Context context;
    public ContactAdapter(Context context, List<Contact> contacts) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_contact, parent, false);

        Viewhoder viewhoder = new Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {

        final Contact contact = contacts.get(position);

        holder.tvone.setText(String.valueOf(contact.getId()));
        holder.tvtwo.setText(String.valueOf(contact.getParent_id()) );
        holder.tvthree.setText(String.valueOf(contact.getPublisher_id()));
        holder.tvfour.setText(contact.getAvatar());
        holder.tvfive.setText(String.valueOf (contact.getContent_type()));
        holder.tvsix.setText(String.valueOf(contact.getDate_created()));
        holder.tvseven.setText(String.valueOf(contact.getUser_modified()));
        holder.tveight.setText(String.valueOf(contact.getUser_created()));
        holder.tvnine.setText(String.valueOf(contact.getTitle()));
        holder.tvten.setText(String.valueOf(contact.getStatus()));
        holder.tv11.setText(String.valueOf(contact.getLft()));
        holder.tv12.setText(String.valueOf(contact.getDeleted()));
        holder.tv13.setText(String.valueOf(contact.getTab()));
        holder.tv14.setText(String.valueOf(contact.getTitle()));
        Picasso.with(context).load(contact.getThumb()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
         ImageView image;
        TextView tvone, tvtwo, tvthree, tvfour, tvfive, tvsix, tvseven, tveight,tvnine,tvten,tv11,tv12, tv13, tv14,tv15,tv16,tv17,tv18,tv19,tv20,img;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);

            tvone = itemView.findViewById(R.id.tv1);
            tvtwo = itemView.findViewById(R.id.tv2);
            tvthree = itemView.findViewById(R.id.tv3);
            tvfour = itemView.findViewById(R.id.tv4);
            tvfive = itemView.findViewById(R.id.tv5);
            tvsix = itemView.findViewById(R.id.tv6);
            tvseven = itemView.findViewById(R.id.tv7);
            tveight = itemView.findViewById(R.id.tv8);
            tvnine = itemView.findViewById(R.id.tv9);
            tvten = itemView.findViewById(R.id.tv10);
            tv11 = itemView.findViewById(R.id.tv11);
            tv12 = itemView.findViewById(R.id.tv12);
            tv13 = itemView.findViewById(R.id.tv13);
            tv14 = itemView.findViewById(R.id.tv14);
            image = itemView.findViewById(R.id.image1);



        }
    }
}
