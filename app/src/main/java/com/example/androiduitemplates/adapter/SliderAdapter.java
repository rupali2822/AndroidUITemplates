package com.example.androiduitemplates.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androiduitemplates.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

private int images[];
private String imgtext[];

    public SliderAdapter(int[] images, String[] imgtext) {
        this.images = images;
        this.imgtext = imgtext;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout,null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {
        viewHolder.imageViewBackground.setImageResource(images[position]);
        viewHolder.textView.setText(imgtext[position]);



    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder{
        View itemView;
        TextView textView;
        ImageView imageViewBackground;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.sliderText);
            this.itemView = itemView;
        }
    }
}

