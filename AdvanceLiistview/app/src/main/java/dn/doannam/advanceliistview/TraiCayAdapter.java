package dn.doannam.advanceliistview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public  class ViewHolder
    {
        TextView txtTen;
        TextView txtMoTa;
        ImageView anh;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view ==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
             holder = new ViewHolder();
            // ánh xạ
            holder.txtTen = (TextView) view.findViewById(R.id.textviewten);
            holder.txtMoTa  = (TextView) view.findViewById(R.id.textMota);
            holder.anh = (ImageView) view.findViewById(R.id.imgview1);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        TraiCay traiCay = traiCayList.get(i);
        holder.txtTen.setText(traiCay.getTen());
        holder.txtMoTa.setText(traiCay.getMoTa());
        holder.anh.setImageResource(traiCay.getHinh());

        return view;
    }
}
