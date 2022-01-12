package com.example.android3.Recyclerview;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3.R;

import java.util.List;

 public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.LinearViewHolder>{

     private  List<itembean> mDate;
     private OnlongitemClickListener mOnLongItemClickListener;
     private OnItemClickListener mOnItemClickListener;

     public ListViewAdapter(List<itembean> data){
        this.mDate=data;

    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= View.inflate(parent.getContext(),R.layout.item_rv,null);
        return new LinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
       holder.setData(mDate.get(position),position);

//        View itemView = ((RelativeLayout) holder.itemView).getChildAt(0);
//        if (mOnItemClickListener != null) {
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = holder.getLayoutPosition();
//                    mOnItemClickListener.onItemClick(holder.itemView, position);
//                }
//            });
//        }

    }

    @Override
    public int getItemCount() {
       if(mDate!=null){
           return mDate.size();
       }
       return  0;
    }


     public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
         mOnItemClickListener = onItemClickListener;
     }

     public interface OnItemClickListener {
         void onItemClick( int position);
     }

     public  void setOnLongItemClickListener(OnlongitemClickListener onLongItemClickListener){
         this.mOnLongItemClickListener=onLongItemClickListener;
     }
     public  interface  OnlongitemClickListener{
         void onLongItemClick(int position);
     }

    public class LinearViewHolder extends RecyclerView.ViewHolder {

        private  ImageView icon;
        private  TextView name;
        private int mPosition;




        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(mPosition);
                    }
                }




            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if(mOnLongItemClickListener!=null){
                        mOnLongItemClickListener.onLongItemClick(mPosition);
                        return true;
                    }
                    return false;
                }
            });
}


        public void setData(itembean itembean,int position) {
            this.mPosition=position;
            icon.setImageResource(itembean.id1);
            name.setText(itembean.name);
        }
    }


}





