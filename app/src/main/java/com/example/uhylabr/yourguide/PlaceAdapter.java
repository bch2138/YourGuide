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


    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link PlaceAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param places  is the list of {@link Place}s to be displayed.
     * @param colorResourceID is the resource ID for the background color for this list of places
     */
    public PlaceAdapter(Context context, ArrayList<com.example.uhylabr.yourguide.Place> places, int colorResourceID) {
        super(context, 0, places);
        mColorResourceId = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        com.example.uhylabr.yourguide.Place currentPlace = getItem(position);

        // find the image for the place from the list_item.xml
        ImageView ivPlaceImage = (ImageView)listItemView.findViewById(R.id.iv_place_image);
        // Check if an image is provided for the place
        if (currentPlace.hasImage()) {
            // Get the place image from the currentPlace object and
            // set this image on the iv_place_image view
            ivPlaceImage.setImageResource(currentPlace.getPlaceImageID());
        } else {
            //Set the imageView to Gone (Hide the imageView Visibility)
            ivPlaceImage.setVisibility(View.GONE);
        }

        // Set the place name on the tv_place_name of the list_item.xml
        TextView tvPlaceName = (TextView) listItemView.findViewById(R.id.tv_place_name);
        // Get the place name from the currentPlace object and set this text
        // on the tv_place_name TextView
        tvPlaceName.setText(currentPlace.getPlaceNameID());

        // Find the description for a place from the list_item.xml
        TextView tvPlaceDescription = (TextView)listItemView.findViewById(R.id.tv_place_discription);
        // Check if the current place has place information
        if (currentPlace.hasPlaceInfo()) {
            // Get the place description from the currentPlace object and
            // set the correct description on the tv_place_description TextView
            tvPlaceDescription.setText(currentPlace.getPlaceDescriptionID());
        } else {
            // Set tvPlaceDescription to gone (hide the textView for place description)
            tvPlaceDescription.setVisibility(View.GONE);
        }

        // Find the location for a place from the list_item.xml
        TextView tvPlaceLocation = (TextView)listItemView.findViewById(R.id.tv_place_location);
        // Get the place location from the currentPlace object and
        // set the correct location on the tv_place_location TextView
        tvPlaceLocation.setText(currentPlace.getPlaceLocationID());

        // Find the website for a place from the list_item.xml
        TextView tvPlaceWebsite = (TextView)listItemView.findViewById(R.id.tv_place_website);
        // Get the place website from the currentPlace object and
        // set the correct website on the tv_place_website textView
        tvPlaceWebsite.setText(currentPlace.getPlaceWebsiteID());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout
        // so that it can be shown in the ListView.
        return listItemView;
    }
}
