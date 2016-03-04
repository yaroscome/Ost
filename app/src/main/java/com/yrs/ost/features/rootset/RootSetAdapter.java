package com.yrs.ost.features.rootset;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yrs.ost.R;
import com.yrs.ost.models.Image;
import com.yrs.ost.models.Set;
import com.yrs.ost.networking.connectors.SkylarkConnector;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by yaros on 03/03/16.
 */
public class RootSetAdapter extends ArrayAdapter<Set> {

    @NonNull
    private int resource;

    @NonNull
    private Context context;

    @NonNull
    private List<Set> objects;

    @NonNull
    private SkylarkConnector skylark;

    @NonNull
    private List<Image> inMemoryImages;



    public RootSetAdapter(@NonNull Context context,
                          @NonNull int resource,
                          @NonNull List<Set> objects,
                          @NonNull SkylarkConnector skylark,
                          @NonNull List<Image> inMemoryImages) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.skylark = skylark;
        this.inMemoryImages = inMemoryImages;

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
            viewHolder.visualImageView = (ImageView) convertView.findViewById(R.id.visual_imageView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.titleTextView.setText(singleSet.getTitle());

        if(singleSet.getImageUrls() != null && !singleSet.getImageUrls().isEmpty()) {
            for(Image image: inMemoryImages) {
                String self = singleSet.getSelf();
                String contentUrl = image.getContentUrl();
                if(self.equals(contentUrl)) {
//                if(singleSet.getSelf().equals(image.getContentUrl())) {
                    StringTokenizer tokenizer = new StringTokenizer(image.getUrl(), "?");
                    String imageUrl = tokenizer.nextToken();
                    Picasso.with(context)
                            .load(imageUrl)
                            .fit()
                            .into(viewHolder.visualImageView);
                    break;
                }
            }
        }




        return convertView;

    }

    private class ViewHolder {

        ImageView visualImageView;
        TextView titleTextView;
    }
}
