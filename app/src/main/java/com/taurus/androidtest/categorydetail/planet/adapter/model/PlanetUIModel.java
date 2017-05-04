package com.taurus.androidtest.categorydetail.planet.adapter.model;

import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.network.model.planet.Planet;
import com.taurus.androidtest.util.ListConverter;

import java.util.List;

public class PlanetUIModel extends GenericItem {

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

    public static List<PlanetUIModel> createList(List<Planet> planetList) {
        return ListConverter.convert(planetList, item -> create(item));
    }

    private static PlanetUIModel create(Planet item) {

        final PlanetUIModel model = new PlanetUIModel();

        model.setName(model.getName());
        model.setRotationPeriod(model.getRotationPeriod());
        model.setOrbitalPeriod(model.getOrbitalPeriod());
        model.setDiameter(model.getDiameter());
        model.setClimate(model.getClimate());
        model.setGravity(model.getGravity());
        model.setRegion(model.getRegion());
        model.setSurfaceWater(model.getSurfaceWater());
        model.setPopulation(model.getPopulation());
        model.setId(model.getId());

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
}
