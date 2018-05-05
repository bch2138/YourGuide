package com.example.uhylabr.yourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TouristsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        final ArrayList<com.example.uhylabr.yourguide.Place> places = new ArrayList<>();

        places.add(new com.example.uhylabr.yourguide.Place(R.drawable.grant,R.string.tourist_one,R.string.info_tourist_one,
                R.string.address_tourist_one,R.string.web_tourist_one,
                "https://www.google.com.ng/maps/place/General+Grant+National+Memorial/@40.8134085,-73.9652558,17z/data=!3m1!4b1!4m5!3m4!1s0x89c2f640faa71aa3:0x4f7927f02d4ef82e!8m2!3d40.8134045!4d-73.9630671 "));
        places.add(new com.example.uhylabr.yourguide.Place(R.drawable.stjohnthedivine,R.string.tourist_two,R.string.info_tourist_two,
                R.string.address_tourist_two,R.string.web_tourist_two,
                "https://www.google.com.ng/maps/place/The+Cathedral+Church+of+St.+John+the+Divine/@40.8038396,-73.9640641,17z/data=!3m1!4b1!4m5!3m4!1s0x89c2f63c567b446b:0xc4a30e125ef40bff!8m2!3d40.8038356!4d-73.9618754"));
        places.add(new com.example.uhylabr.yourguide.Place(R.drawable.buell,R.string.tourist_three,R.string.info_tourist_three,
                R.string.address_tourist_three,R.string.web_tourist_three,
                "https://www.google.com.ng/maps/place/Buell+Hall,+New+York,+NY+10027/@40.8077317,-73.9636268,17z/data=!3m1!4b1!4m5!3m4!1s0x89c2f63e42410075:0x320cd179c274aca2!8m2!3d40.8077339!4d-73.9614348"));



        com.example.uhylabr.yourguide.PlaceAdapter adapter = new com.example.uhylabr.yourguide.PlaceAdapter(this, places, R.color.colorHome);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // get the place map id an launch a google map view of the place
                com.example.uhylabr.yourguide.Place place = places.get(i);

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
