package com.taurus.androidtest.categorydetail.planet.adapter.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.network.model.planet.Planet;
import com.taurus.androidtest.util.ListConverter;

import java.util.List;

public class PlanetUIModel extends GenericItem implements Parcelable {

    private String name;

    private String rotationPeriod;

    private String orbitalPeriod;

    private String diameter;

    private String climate;

    private String gravity;

    private String region;

    private String surfaceWater;

    private String population;

    private String id;

    public PlanetUIModel() {
    }

    protected PlanetUIModel(Parcel in) {
        super(in);
        name = in.readString();
        rotationPeriod = in.readString();
        orbitalPeriod = in.readString();
        diameter = in.readString();
        climate = in.readString();
        gravity = in.readString();
        region = in.readString();
        surfaceWater = in.readString();
        population = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(name);
        dest.writeString(rotationPeriod);
        dest.writeString(orbitalPeriod);
        dest.writeString(diameter);
        dest.writeString(climate);
        dest.writeString(gravity);
        dest.writeString(region);
        dest.writeString(surfaceWater);
        dest.writeString(population);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlanetUIModel> CREATOR = new Creator<PlanetUIModel>() {
        @Override
        public PlanetUIModel createFromParcel(Parcel in) {
            return new PlanetUIModel(in);
        }

        @Override
        public PlanetUIModel[] newArray(int size) {
            return new PlanetUIModel[size];
        }
    };

    public static List<PlanetUIModel> createList(List<Planet> planetList) {
        return ListConverter.convert(planetList, item -> create(item));
    }

    private static PlanetUIModel create(Planet item) {

        final PlanetUIModel model = new PlanetUIModel();

        model.setName(item.getName());
        model.setRotationPeriod(item.getRotationPeriod());
        model.setOrbitalPeriod(item.getOrbitalPeriod());
        model.setDiameter(item.getDiameter());
        model.setClimate(item.getClimate());
        model.setGravity(item.getGravity());
        model.setRegion(item.getRegion());
        model.setSurfaceWater(item.getSurfaceWater());
        model.setPopulation(item.getPopulation());
        model.setId(item.getId());

        return model;
    }

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

    @Override
    public int getItemRecognitionFiled() {
        return Integer.parseInt(id);
    }
}
