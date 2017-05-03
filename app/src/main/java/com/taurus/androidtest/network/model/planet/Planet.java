package com.taurus.androidtest.network.model.planet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Planet {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("rotation_period")
    @Expose
    private String rotationPeriod;

    @SerializedName("orbital_period")
    @Expose
    private String orbitalPeriod;

    @SerializedName("diameter")
    @Expose
    private String diameter;

    @SerializedName("climate")
    @Expose
    private String climate;

    @SerializedName("gravity")
    @Expose
    private String gravity;

    @SerializedName("region")
    @Expose
    private String region;

    @SerializedName("surface_water")
    @Expose
    private String surfaceWater;

    @SerializedName("population")
    @Expose
    private String population;

    @SerializedName("id")
    @Expose
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
