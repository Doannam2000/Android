package dn.doannam.listviewpart2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterDongHo extends BaseAdapter {

    private Context context;
    private int layout;
    private List<DongHo> dongHoList;

    public AdapterDongHo(Context context, int layout, List<DongHo> dongHoList) {
        this.context = context;
        this.layout = layout;
        this.dongHoList = dongHoList;
    }

    @Override
    public int getCount() {
        return dongHoList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class HolderView
    {
        TextView txtTen;
        TextView txtMota;
        ImageView imganh;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      HolderView holder;
       if(view == null)
       {
           holder = new HolderView();
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = inflater.inflate(layout,null);

           // ánh xạ

           holder.txtTen = (TextView) view.findViewById(R.id.textTen);
           holder.txtMota = (TextView) view.findViewById(R.id.textMota);
           holder.imganh = (ImageView) view.findViewById(R.id.Imagedh1);

           view.setTag(holder);
       }
       else
       {
           holder = (HolderView) view.getTag();
       }

       DongHo dongHo = dongHoList.get(i);

       holder.txtTen.setText(dongHo.getTen());
       holder.txtMota.setText(dongHo.getMota());
       holder.imganh.setImageResource(dongHo.getHinh());

       return view;
    }
}
