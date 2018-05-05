package com.example.uhylabr.yourguide;



public class Place {

    private static final int NOT_PROVIDED = -1;


    private int mPlaceImageID = NOT_PROVIDED;

    private int mPlaceNameID;
    private int mPlaceDescriptionID = NOT_PROVIDED;
    private int mPlaceLocationID;
    private int mPlaceWebsiteID;
    private String  mPlaceMapID;

    public Place(int placeImageID, int placeNameID, int placeDescriptionID, int placeLocationID, int placeWebsiteID, String PlaceMapID){

        mPlaceNameID = placeNameID;
        mPlaceImageID = placeImageID;
        mPlaceDescriptionID = placeDescriptionID;
        mPlaceLocationID = placeLocationID;
        mPlaceWebsiteID = placeWebsiteID;
        mPlaceMapID = PlaceMapID;
    }

    public Place(int placeNameID, int placeLocationID, int placeWebsiteID, String PlaceMapID) {

        mPlaceNameID = placeNameID;
        mPlaceLocationID = placeLocationID;
        mPlaceWebsiteID = placeWebsiteID;
        mPlaceMapID = PlaceMapID;
    }


    public int getPlaceNameID(){
        return mPlaceNameID;
    }


    public int getPlaceImageID(){
        return mPlaceImageID;
    }


    public int getPlaceDescriptionID(){
        return mPlaceDescriptionID;
    }


    public int getPlaceLocationID() {
        return mPlaceLocationID;
    }


    public int getPlaceWebsiteID() {
        return mPlaceWebsiteID;
    }


    public String getPlaceMapID(){
        return mPlaceMapID;
    }


    public boolean hasImage() {
        return mPlaceImageID != NOT_PROVIDED;
    }

    public boolean hasPlaceInfo() {
        return mPlaceDescriptionID != NOT_PROVIDED;
    }

}

