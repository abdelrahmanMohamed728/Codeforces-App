package com.example.abdo.codeforcesapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class standingsAdapter extends ArrayAdapter<Contestant> {
    public standingsAdapter(@NonNull Context context,@NonNull List<Contestant> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.standinglayout,parent,false);
        TextView txt1 = convertView.findViewById(R.id.txt1);
        TextView txt2 = convertView.findViewById(R.id.txt2);
        TextView txt3 = convertView.findViewById(R.id.txt3);
        Contestant c = getItem(position);
        txt1.setText(c.getRank());
        txt2.setText(c.getName());
        txt3.append(String.valueOf(c.getRating()));
        if (c.getRating()>=2500)
        {
            txt2.setTextColor(Color.parseColor("#da0505"));
            txt1.setTextColor(Color.parseColor("#da0505"));
        }
        else if (c.getRating()>=2100)
        {
            txt2.setTextColor(Color.parseColor("#FFA500"));
            txt1.setTextColor(Color.parseColor("#FFA500"));
        }
        else if (c.getRating()>=1900)
        {
            txt2.setTextColor(Color.parseColor("#800080"));
            txt1.setTextColor(Color.parseColor("#800080"));
        }
        return convertView;

    }
}
