package com.example.btvn_listview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class AdapterContact extends BaseAdapter {

    List<Contact> contactList;

    public AdapterContact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_contact,parent,false);

        TextView tvname = (TextView) view.findViewById(R.id.tvName);
        TextView tvSchool = (TextView) view.findViewById(R.id.tvSchool);
        CircleImageView avt  = (CircleImageView) view.findViewById(R.id.image_avt);
        TextView tvOne = (TextView)view.findViewById(R.id.tv_numberOne);
        TextView tvTwo = (TextView)view.findViewById(R.id.tv_numberTwo);
        TextView tvThree = (TextView)view.findViewById(R.id.tv_numberThree);
        TextView tvFour =(TextView) view.findViewById(R.id.tv_numberFour);
        TextView tvFive= (TextView)view.findViewById(R.id.tv_numberFive);
        TextView tvSix = (TextView)view.findViewById(R.id.tv_numberSix);
        LinearLayout backgroud = (LinearLayout)view.findViewById(R.id.backgroud);

        Contact contact = contactList.get(position);

        tvname.setText(contact.getName());
        tvSchool.setText(contact.getNameSchool());
        avt.setImageResource(contact.getImg1());
        tvOne.setText(contact.getText1());
        tvTwo.setText(contact.getText2());
        tvThree.setText(contact.getText3());
        tvFour.setText(contact.getText4());
        tvFive.setText(contact.getText5());
        tvSix.setText(contact.getText6());

        backgroud.setBackgroundResource(contact.getBackgroud());
        return view;
    }
}

