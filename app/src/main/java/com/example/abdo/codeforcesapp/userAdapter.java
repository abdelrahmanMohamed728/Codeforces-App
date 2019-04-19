package com.example.abdo.codeforcesapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.util.List;

public class userAdapter extends ArrayAdapter<User> {
    public userAdapter(@NonNull Context context,  @NonNull List<User> objects) {
        super(context, 0, objects);
    }
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.userlayout,parent,false);
        TextView username = convertView.findViewById(R.id.userUsername);
        TextView rank = convertView.findViewById(R.id.userRank);
        TextView maxRating = convertView.findViewById(R.id.userMaxRating);
        TextView rating =convertView.findViewById(R.id.userRating);
        TextView friends = convertView.findViewById(R.id.userFriends);
        ImageView image = convertView.findViewById(R.id.userImage);
        User c = getItem(position);
        username.setText(c.getUsername());
        rank.setText(c.getRank());
        maxRating.setText(String.valueOf(c.getMaxRating()));
        rating.setText(String.valueOf(c.getRating()));
        friends.setText(String.valueOf(c.getFriends()));
        if (c.getRating()>=2500)
        {
            username.setTextColor(Color.parseColor("#da0505"));
            rating.setTextColor(Color.parseColor("#da0505"));
            rank.setTextColor(Color.parseColor("#da0505"));
        }
        else    if (c.getRating()>=2100)
        {
            username.setTextColor(Color.parseColor("#FFA500"));
            rating.setTextColor(Color.parseColor("#FFA500"));
            rank.setTextColor(Color.parseColor("#FFA500"));
        }
        else   if (c.getRating()>=1900) {
            username.setTextColor(Color.parseColor("#800080"));
            rating.setTextColor(Color.parseColor("#800080"));
            rank.setTextColor(Color.parseColor("#800080"));
        }
        else if (c.getRating()>=1600)
        {
            username.setTextColor(Color.parseColor("#0000FF"));
            rating.setTextColor(Color.parseColor("#0000FF"));
            rank.setTextColor(Color.parseColor("#0000FF"));
        }
        else if (c.getRating()>=1400)
        {
            username.setTextColor(Color.parseColor("#89cff0"));
            rating.setTextColor(Color.parseColor("#89cff0"));
            rank.setTextColor(Color.parseColor("#89cff0"));
        }
        else if (c.getRating()>=1200)
        {
            username.setTextColor(Color.parseColor("#008000"));
            rating.setTextColor(Color.parseColor("#008000"));
            rank.setTextColor(Color.parseColor("#008000"));
        }
        if (c.getMaxRating()>=2500)
        {
            maxRating.setTextColor(Color.parseColor("#da0505"));
        }

      else  if (c.getMaxRating()>=2100)
        {
            maxRating.setTextColor(Color.parseColor("#FFA500"));
        }


       else if (c.getMaxRating()>=1900)
        {
            maxRating.setTextColor(Color.parseColor("#800080"));
        }

       else if (c.getMaxRating()>=1600)
        {
            maxRating.setTextColor(Color.parseColor("#0000FF"));
        }

       else if (c.getMaxRating()>=1400)
        {
            maxRating.setTextColor(Color.parseColor("#89cff0"));
        }

       else if (c.getMaxRating()>=1200)
        {
            maxRating.setTextColor(Color.parseColor("#008000"));
        }
        Picasso.with(getContext())
                .load("http:"+c.getPicURL())
                .resize(120,120).into(image);
        return convertView;

    }
}


