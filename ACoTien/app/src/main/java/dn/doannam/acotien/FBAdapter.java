package dn.doannam.acotien;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FBAdapter extends RecyclerView.Adapter<FBAdapter.InforNickHolder>  {

    private static  List<InforNick>inforNickList;
    public FBAdapter(List<InforNick> inforNickList)
    {
        this.inforNickList = inforNickList;
    }

    @NonNull
    @Override
    public InforNickHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new InforNickHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final InforNickHolder holder, final int position) {
        holder.startJob.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    holder.tvttCookie.setVisibility(View.VISIBLE);
                    if (inforNickList.get(position).getCookie().equals("CookieDie")||inforNickList.get(position).getCookie().length()==0)
                    {
                        holder.tvttCookie.setText("COOKIE DIE");
                        holder.tvttCookie.setTextColor(Integer.parseInt("#FF0000"));
                    }
                    else
                    {
                        holder.tvttCookie.setText("LIVE");
                    }
                    holder.cookieFB.setVisibility(View.GONE);
                    holder.tvName.setTextSize(20);
                    holder.tvID.setTextSize(20);
                    holder.tvJob.setTextSize(20);
                    inforNickList.get(position).setCheck(true);
                    inforNickList.get(position).setCookie(holder.cookieFB.getText().toString());
                }
                else
                {
                    holder.cookieFB.setVisibility(View.VISIBLE);
                    inforNickList.get(position).setCheck(false);
                    holder.tvName.setTextSize(18);
                    holder.tvID.setTextSize(18);
                    holder.tvJob.setTextSize(18);
                }
            }
        });
        holder.tvName.setText("Name : "+inforNickList.get(position).getNickName());
        holder.tvID.setText("ID : "+inforNickList.get(position).getIdNick());
        Picasso.get().load(inforNickList.get(position).getImageId()).into(holder.imageView);
        holder.tvJob.setText("JOB : "+inforNickList.get(position).getJob());
        if(inforNickList.get(position).isCheck()==true)
        {
            holder.startJob.setChecked(true);
            holder.cookieFB.setVisibility(View.GONE);
            holder.tvName.setTextSize(20);
            holder.tvID.setTextSize(20);
            holder.tvJob.setTextSize(20);
            holder.tvttCookie.setVisibility(View.VISIBLE);
            if (inforNickList.get(position).getCookie().equals("CookieDie")||inforNickList.get(position).getCookie().length()==0)
            {
                holder.tvttCookie.setText("COOKIE DIE");
                holder.tvttCookie.setTextColor(Integer.parseInt("#FF0000"));
            }
            else
            {
                holder.tvttCookie.setText("LIVE");
            }
        }
        else
        {
            holder.cookieFB.setText(inforNickList.get(position).getCookie());
            holder.cookieFB.setVisibility(View.VISIBLE);
            holder.tvName.setTextSize(18);
            holder.tvID.setTextSize(18);
            holder.tvJob.setTextSize(18);
            holder.startJob.setChecked(false);
            holder.tvttCookie.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return inforNickList.size();
    }

    public static class InforNickHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvName,tvJob,tvID,tvttCookie;
        public Switch startJob;
        public EditText cookieFB;
        public InforNickHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.anhDaiDien);
            tvID = itemView.findViewById(R.id.idFB);
            tvJob = itemView.findViewById(R.id.Job);
            tvName = itemView.findViewById(R.id.NameFB);
            startJob = itemView.findViewById(R.id.startAuto);
            cookieFB = itemView.findViewById(R.id.cookieFB);
            tvttCookie = itemView.findViewById(R.id.ttCookie);
        }
    }
}
