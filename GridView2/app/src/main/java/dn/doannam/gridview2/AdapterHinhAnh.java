package dn.doannam.gridview2;

import android.content.Context;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterHinhAnh extends BaseAdapter {
    private Context context;
    private int layout;
    List<HinhAnh> list;

    public AdapterHinhAnh(Context context, int layout, List<HinhAnh> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder
    {
        ImageView imageView;
        //TextView textView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder Holder;
        if(view == null)
        {
            Holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            Holder.imageView = (ImageView)view.findViewById(R.id.Anh1);
           // Holder.textView =(TextView)view.findViewById(R.id.Ten);
            view.setTag(Holder);
        }
        else
        {
            Holder = (ViewHolder) view.getTag();
        }
        HinhAnh hinhAnh = list.get(i);
        Holder.imageView.setImageResource(hinhAnh.getHinh());
        //Holder.textView.setText(hinhAnh.getTen());
        return view;
    }
}
