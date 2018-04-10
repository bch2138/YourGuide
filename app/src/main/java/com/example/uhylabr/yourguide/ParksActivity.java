package com.example.uhylabr.yourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.uhylabr.yourguide.Place;
import com.example.uhylabr.yourguide.PlaceAdapter;

import java.util.ArrayList;


public class ParksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.drawable.sakura, R.string.park_one, R.string.info_park_one,
                R.string.address_park_one, R.string.web_park_one,
                "https://www.google.com/maps/place/Sakura+Park/@40.8127856,-73.9644378,17z/data=!3m1!4b1!4m12!1m6!3m5!1s0x89c2f640597795e9:0x384a41ad11a39e77!2sSakura+Park!8m2!3d40.8127856!4d-73.9622491!3m4!1s0x89c2f640597795e9:0x384a41ad11a39e77!8m2!3d40.8127856!4d-73.9622491"));
        places.add(new Place(R.drawable.riverside, R.string.park_two, R.string.info_park_two,
                R.string.address_park_two, R.string.web_park_two,
                "https://www.google.com.ng/maps/place/Riverside+Park/@40.8013427,-74.0423501,12z/data=!4m23!1m17!4m16!1m6!1m2!1s0x89c2f62ed8cf502f:0x7c67f4849fdf7287!2sRiverside+Park,+New+York,+NY!2m2!1d-73.9723096!2d40.8012339!1m2!1m1!2s'!1m2!1m1!2s'!1m2!1m1!2s'!3m4!1s0x89c2f62ed8cf502f:0x7c67f4849fdf7287!8m2!3d40.8012339!4d-73.9723096"));
        places.add(new Place(R.drawable.nicholas, R.string.park_three, R.string.info_park_three,
                R.string.address_park_three, R.string.web_park_three,
                "https://www.google.com.ng/maps/place/St.+Nicholas+Park/@40.8174729,-73.9509363,17z/data=!3m1!4b1!4m5!3m4!1s0x89c2f66fcbc031d3:0x4c9cd4fd1b947438!8m2!3d40.8174689!4d-73.9487476"));



        PlaceAdapter adapter = new PlaceAdapter(this, places, R.color.colorHome);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // get the place map id an launch a google map view of the place
                Place place = places.get(i);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(place.getPlaceMapID()));

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "No App to Handle Intent", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
