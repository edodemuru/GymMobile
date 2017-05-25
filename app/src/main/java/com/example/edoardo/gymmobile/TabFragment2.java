package com.example.edoardo.gymmobile;

/**
 * Created by Edoardo on 09/02/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;

public class TabFragment2 extends Fragment {
    Button allen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tab_fragment_2, container, false);
        Button allen= (Button) view.findViewById(R.id.allenamento);
        Button calend= (Button) view.findViewById(R.id.calendario);
        Button scheda= (Button) view.findViewById(R.id.scheda);
        Button impost= (Button) view.findViewById(R.id.impostazioni);

        allen.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            { Intent allen= new Intent(v.getContext(),ActivityAllen.class);
                startActivity(allen);
            }
        });

        calend.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            { Intent calend= new Intent(v.getContext(),ActivityCalend.class);
                startActivity(calend);
            }
        });

        scheda.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            { Intent scheda= new Intent(v.getContext(),Tab_Allen.class);
                startActivity(scheda);
            }
        });

        impost.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            { Intent impost= new Intent(v.getContext(),ActivityImpost.class);
                startActivity(impost);
            }
        });

        return view;


    }
}
