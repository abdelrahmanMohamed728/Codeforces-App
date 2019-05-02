package com.example.abdo.codeforcesapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SubmissionAdapter extends ArrayAdapter<Submission> {


    public SubmissionAdapter(@NonNull Context context, @NonNull List<Submission> objects) {
        super(context, 0 ,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.submissionlayout,parent,false);
        TextView txt1 = convertView.findViewById(R.id.id1);
        TextView txt2 = convertView.findViewById(R.id.problemName);
        TextView txt3 = convertView.findViewById(R.id.ProLang);
        TextView txt4 = convertView.findViewById(R.id.result);
        Submission submission = getItem(position);
        txt1.setText(submission.getId());
        txt2.setText(submission.getName());
        txt3.setText(submission.getLang());
        txt4.setText(submission.getResult());
        if (submission.getResult().equals("OK"))
        {
            txt4.setTextColor(Color.parseColor("#008000"));
        }
        else
            txt4.setTextColor(Color.parseColor("#da0505"));
        return convertView;
    }
}
