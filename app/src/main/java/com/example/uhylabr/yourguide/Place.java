package com.example.uhylabr.yourguide;



public class Place {

    /**
     * Constant value that represents no value provide for place
     */
    private static final int NOT_PROVIDED = -1;

    /**
     * Image resource ID for the place
     */
    private int mPlaceImageID = NOT_PROVIDED;

    private int mPlaceNameID;
    private int mPlaceDescriptionID = NOT_PROVIDED;
    private int mPlaceLocationID;
    private int mPlaceWebsiteID;
    private String  mPlaceMapID;

    public Place(int placeImageID, int placeNameID, int placeDescriptionID,
                 int placeLocationID, int placeWebsiteID, String PlaceMapID){

        mPlaceNameID = placeNameID;
        mPlaceImageID = placeImageID;
        mPlaceDescriptionID = placeDescriptionID;
        mPlaceLocationID = placeLocationID;
        mPlaceWebsiteID = placeWebsiteID;
        mPlaceMapID = PlaceMapID;
    }

    public Place(int placeNameID, int placeLocationID,
                 int placeWebsiteID, String PlaceMapID) {

        mPlaceNameID = placeNameID;
        mPlaceLocationID = placeLocationID;
        mPlaceWebsiteID = placeWebsiteID;
        mPlaceMapID = PlaceMapID;
    }

    /**
     * Get the name of a place
     * @return the name id of the place
     */
    public int getPlaceNameID(){
        return mPlaceNameID;
    }

    /**
     * Get the image of a place
     * @return the image id of the place
     */
    public int getPlaceImageID(){
        return mPlaceImageID;
    }

    /**
     * Get the description of a place
     * @return the description id of a place as int
     */
    public int getPlaceDescriptionID(){
        return mPlaceDescriptionID;
    }

    /**
     * Get The location of a place
     * @return the location id of a place as int
     */
    public int getPlaceLocationID() {
        return mPlaceLocationID;
    }

    /**
     * Get the website a place
     * @return the website id of a place as int
     */
    public int getPlaceWebsiteID() {
        return mPlaceWebsiteID;
    }

    /**
     * get the map url of a place
     * @return the map url of a place
     */
    public String getPlaceMapID(){
        return mPlaceMapID;
    }

    /**
     * Check if an image is set for the a place
     *
     * @return whether or not there is an image for the place
     */
    public boolean hasImage() {
        return mPlaceImageID != NOT_PROVIDED;
    }

    public boolean hasPlaceInfo() {
        return mPlaceDescriptionID != NOT_PROVIDED;
    }

}

