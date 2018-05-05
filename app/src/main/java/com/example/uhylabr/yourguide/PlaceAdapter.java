package com.example.uhylabr.yourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class PlaceAdapter extends ArrayAdapter<com.example.uhylabr.yourguide.Place> {


    private int mColorResourceId;

    public PlaceAdapter(Context context, ArrayList<com.example.uhylabr.yourguide.Place> places, int colorResourceID) {
        super(context, 0, places);
        mColorResourceId = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        com.example.uhylabr.yourguide.Place currentPlace = getItem(position);

        ImageView ivPlaceImage = (ImageView)listItemView.findViewById(R.id.iv_place_image);
        if (currentPlace.hasImage()) {
            ivPlaceImage.setImageResource(currentPlace.getPlaceImageID());
        } else {
            ivPlaceImage.setVisibility(View.GONE);
        }

        TextView tvPlaceName = (TextView) listItemView.findViewById(R.id.tv_place_name);
        tvPlaceName.setText(currentPlace.getPlaceNameID());

        TextView tvPlaceDescription = (TextView)listItemView.findViewById(R.id.tv_place_description);
        if (currentPlace.hasPlaceInfo()) {
            tvPlaceDescription.setText(currentPlace.getPlaceDescriptionID());
        } else {
            tvPlaceDescription.setVisibility(View.GONE);
        }

        TextView tvPlaceLocation = (TextView)listItemView.findViewById(R.id.tv_place_location);
        tvPlaceLocation.setText(currentPlace.getPlaceLocationID());

        TextView tvPlaceWebsite = (TextView)listItemView.findViewById(R.id.tv_place_website);
        tvPlaceWebsite.setText(currentPlace.getPlaceWebsiteID());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
