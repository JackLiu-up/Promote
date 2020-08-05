package com.jackliu.promote.controller.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackliu.promote.R;
import com.jackliu.promote.model.bean.GoodsEntity;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.myViewHodler> {
    private Context context;
    private ArrayList<GoodsEntity> goodsEntityList;

    public MessageAdapter(Context context, ArrayList<GoodsEntity> goodsEntityList) {
        //将传递过来的数据，赋值给本地变量
        this.context = context;
        this.goodsEntityList = goodsEntityList;//实体类数据ArrayList
    }


    /**
     * 创建viewhodler，相当于listview中getview中的创建view和viewhodler
     *
     * @param parent
     * @param viewType
     * @return
     */
    public myViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建自定义布局
        View itemView = View.inflate(context, R.layout.message_view, null);
        return new myViewHodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHodler holder, int position) {
        GoodsEntity data = goodsEntityList.get(position);
    }

    @Override
    public int getItemCount() {
        return goodsEntityList.size();
    }


    //自定义viewhodler
    class myViewHodler extends RecyclerView.ViewHolder {
        private ImageView mItemGoodsImg;
        private TextView mItemGoodsText;

        public myViewHodler(View itemView) {
            super(itemView);
            mItemGoodsImg = (ImageView) itemView.findViewById(R.id.imageView1);
            mItemGoodsText = (TextView) itemView.findViewById(R.id.textView);
            //   mItemGoodsPrice = (TextView) itemView.findViewById(R.id.item_goods_price);
            //点击事件放在adapter中使用，也可以写个接口在activity中调用
            //方法一：在adapter中设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可以选择直接在本位置直接写业务处理
                    //Toast.makeText(context,"点击了xxx",Toast.LENGTH_SHORT).show();
                    //此处回传点击监听事件
                    if (onItemClickListener != null) {
                        onItemClickListener.OnItemClick(v, goodsEntityList.get(getLayoutPosition()));
                    }
                }
            });
        }

    }

    /**
     * 设置item的监听事件的接口
     */
    public interface OnItemClickListener {
        /**
         * 接口中的点击每一项的实现方法，参数自己定义
         *
         * @param view 点击的item的视图
         * @param data 点击的item的数据
         */
        public void OnItemClick(View view, GoodsEntity data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}


