package com.forlost.zhongtuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forlost.zhongtuo.R;
import java.util.List;

/**
 * 首页的消息列表适配器
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myviewholder> {
    private List<String> list;
    private Context context;
    private View inflater;

    public RecyclerViewAdapter(Context context,List<String> list){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       inflater = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
       myviewholder myviewholder = new myviewholder(inflater);
        return myviewholder;
    }

    /**
     * 绑定列表数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
    holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   public class myviewholder extends RecyclerView.ViewHolder{
        public TextView textView;
        public myviewholder( View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.item_text);
        }
    }

}
