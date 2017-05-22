package com.example.thedeveloper.androidactiveormappdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.thedeveloper.androidactiveormappdemo.R;
import com.example.thedeveloper.androidactiveormappdemo.models.SubjectList;

import java.util.ArrayList;

/**
 * Created by The Developer on 5/17/2017.
 */

public class SubjectAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<SubjectList> listses;

    public SubjectAdapter(Context context, ArrayList<SubjectList> listses) {
        this.context = context;
        this.listses = listses;
    }

    @Override
    public int getCount() {
        return listses.size();
    }

    @Override
    public Object getItem(int position) {
        return listses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){

            convertView = View.inflate(context , R.layout.list_of_subject,null);

        }

        TextView title = (TextView) convertView.findViewById(R.id.noteTitleText);
        TextView price = (TextView) convertView.findViewById(R.id.noteSubTitletextView);
        ImageView icons = (ImageView) convertView.findViewById(R.id.noteImages);

        ColorGenerator generator = ColorGenerator.MATERIAL;
        SubjectList subjects = listses.get(position);
        title.setText(subjects.getNameSubject());
        price.setText(subjects.getDescriptionSubject());

        String latters = String.valueOf(subjects.getNameSubject().toUpperCase().charAt(0));


        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .width(60)  // width in px
                .height(60) // height in px
                .endConfig()
                .buildRect(latters, generator.getRandomColor());

        icons.setImageDrawable(drawable);

        return convertView;
    }
}
