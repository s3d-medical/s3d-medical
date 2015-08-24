package com.s3d.auth.mongo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015-07-29
 */
public class Location{

    private String type;
    private List<Double> coordinates = new ArrayList<Double>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}