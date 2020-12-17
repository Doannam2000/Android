package dn.doannam.acotien;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    public void onBindViewHolder(@NonNull InforNickHolder holder, int position) {
        holder.tvName.setText("Name : "+inforNickList.get(position).getNickName());
        holder.tvID.setText("ID : "+inforNickList.get(position).getIdNick());
        Picasso.get().load(inforNickList.get(position).getImageId()).into(holder.imageView);
        holder.tvJob.setText("JOB : "+inforNickList.get(position).getJob());
    }

    @Override
    public int getItemCount() {
        return inforNickList.size();
    }

    public static class InforNickHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvName,tvJob,tvID;
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
        }
    }
}
