package com.example.edoardo.gymmobile;

/**
 * Created by Edoardo on 09/02/2017.
 */

        import android.media.Image;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;

public class TabFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab_fragment_1, container, false);

        ImageView logo= (ImageView) v.findViewById(R.id.logo);
        logo.setImageResource(R.drawable.logo);

        ImageView arrow= (ImageView) v.findViewById(R.id.arrow);
        arrow.setImageResource(R.mipmap.rightarrow);


        return v;


    }
}