package com.example.inspection;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<List_Data> listData;
    private OnItemClickListener listener;

    public MyAdapter(List<List_Data> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List_Data ld=listData.get(position);
        holder.txtid.setText(ld.getId());
        holder.txtname.setText(ld.getName());
        holder.txtoption1.setText(ld.getOption1());
        holder.txtoption2.setText(ld.getOption2());
        holder.txtoption3.setText(ld.getOption3());




    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtid,txtname,txtoption1,txtoption2,txtoption3;
        public ViewHolder(View itemView) {
            super(itemView);
            txtid=(TextView)itemView.findViewById(R.id.idtxt);
            txtname=(TextView)itemView.findViewById(R.id.nametxt);
            txtoption1=(TextView)itemView.findViewById(R.id.option1txt);
            txtoption2=(TextView)itemView.findViewById(R.id.option2txt);
            txtoption3=(TextView)itemView.findViewById(R.id.option3txt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
/*                    if (position != RecyclerView.NO_POSITION && listener! = null){


                    }*/

                    Log.i(TAG, "CLICKED" + position);

                }
            });




        }
    }

    public interface OnItemClickListener{
        void onItemClick(DataSnapshot dataSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.listener = listener;
    }

}