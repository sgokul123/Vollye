package com.healthy.foodorder.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.healthy.foodorder.R;
import com.healthy.foodorder.app.AppController;
import com.healthy.foodorder.model.Food;

import java.util.List;

/**
 * Created by bridgeit on 7/3/17.
 */

public class ImageAdapter extends RecyclerView.Adapter <ImageAdapter.MyViewHolder> {
    public static final String TAG = "TeamAdapter";
    TextView textView;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
     private List<Food> mFoodList;
    private int lastPosition = -1;

    public ImageAdapter(List<Food> teamList, Context context) {
        this.mFoodList =teamList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card, parent, false);
        //  itemView.setOnClickListener(this);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int i) {

        //retribe data for single team

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();


        NetworkImageView thumbNail = (NetworkImageView) holder.f_url;
        Food m = mFoodList.get(i);
        thumbNail.setImageUrl(m.getImage(), imageLoader);

        textView.setText(m.getName());



       }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    //
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

         ImageView f_url;
        CardView foodcardView;

        public MyViewHolder(View view) {
            super(view);

            foodcardView=(CardView) view.findViewById(R.id.image_card_layout);
           f_url=(ImageView) view.findViewById(R.id.imageview_card_image);
            textView=(TextView) view.findViewById(R.id.food_image_name);
            }

        @Override
        public void onClick(View view) {


            //   Toast.makeText(mContext,p_dob.getText().toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

}