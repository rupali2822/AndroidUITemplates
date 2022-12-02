package com.example.androiduitemplates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.daimajia.slider.library.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class DashboardUiActivity extends AppCompatActivity {
SliderView sliderView;

    private int slider_images[];
    private String slider_text[];
    com.example.androiduitemplates.adapter.SliderAdapter sAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_ui);

        sliderView=findViewById(R.id.slider);
        slider_images=new int[]{R.drawable.laptopimg1,R.drawable.laptopimg2,R.drawable.laptopimg3};
        slider_text=new String[]{"Available products","Hp Products","Smartphones","Dell laptops"};

        sAdapter=new com.example.androiduitemplates.adapter.SliderAdapter(slider_images,slider_text);

        //below method is used to set auto cycle direction in left to right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        //below method is used to setadapter to sliderview.
        sliderView.setSliderAdapter(sAdapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.SLIDE);
        //below method is use to set scroll time in seconds.
        sliderView.setScrollTimeInSec(3);
        //to set it scrollable automatically we use below method.
        sliderView.setAutoCycle(true);
        //to start autocycle below method is used.
        sliderView.startAutoCycle();
        // Inflate the layout for this fragment

    }
}