package com.yrs.ost.features.rootset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yrs.ost.R;
import com.yrs.ost.models.Set;

import java.util.List;

/**
 * Created by yaros on 03/03/16.
 */
public class RootSetAdapter extends ArrayAdapter<Set> {

    private int resource;
    private Context context;
    private List<Set> objects;


    public RootSetAdapter(Context context, int resource, List<Set> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Set singleSet = objects.get(position);
        ViewHolder viewHolder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.title_textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTextView.setText(singleSet.getTitle());


        return convertView;

    }

    private class ViewHolder {

        ImageView backgroundImageView;
        TextView titleTextView;
    }
}
