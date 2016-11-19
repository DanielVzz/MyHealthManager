package com.hb4u.myhealthmanagerver01_beta;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_custom_swipe extends PagerAdapter {

    private int [] imageResources ={R.drawable.demo_slideshow_0,R.drawable.demo_slideshow_1,R.drawable.demo_slideshow_2,R.drawable.demo_slideshow_3,R.drawable.demo_slideshow_4, R.drawable.demo_slideshow_5};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public activity_custom_swipe(Context c) {
        ctx=c;
    }

    @Override
    public int getCount() {

        return imageResources.length;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.activity_custom_swipe,container,false);
        ImageView imageView=(ImageView) itemView.findViewById(R.id.swip_image_view);
        TextView textView=(TextView) itemView.findViewById(R.id.imageCount);
        imageView.setImageResource(imageResources[position]);
        switch(position){
            case 0:
                textView.setText("Registra gran variedad de Alimentos");
                break;
            case 1:
                textView.setText("Registra gran variedad de Productos");
                break;
            case 2:
                textView.setText("Registra por Paquete o Porción");
                break;
            case 3:
                textView.setText("Escanea tus Alimentos empacados");
                break;
            case 4:
                textView.setText("Escanea tus Alimentos empacados");
                break;
            case 5:
                textView.setText("Sistema de Usuarios EnLínea");
                break;


        }

        container.addView(itemView);
        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return  (view==object);
    }
}
