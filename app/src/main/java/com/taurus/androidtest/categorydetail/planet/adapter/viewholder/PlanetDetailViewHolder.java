package com.taurus.androidtest.categorydetail.planet.adapter.viewholder;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.viewholder.BaseViewHolder;
import com.taurus.androidtest.categorydetail.planet.adapter.model.PlanetUIModel;

import butterknife.BindView;

public class PlanetDetailViewHolder extends BaseViewHolder {

    @BindView(R.id.planetTextViewName)
    TextView textViewName;

    @BindView(R.id.planetTextViewRotationPeriod)
    TextView textViewRotationPeriod;

    @BindView(R.id.planetTextViewOrbitalPeriod)
    TextView textViewOrbitalPeriod;

    @BindView(R.id.planetTextDiameter)
    TextView textDiameter;

    @BindView(R.id.planetTextViewClimate)
    TextView textViewClimate;

    @BindView(R.id.planetTextViewGravity)
    TextView textViewGravity;

    @BindView(R.id.planetTextViewRegion)
    TextView textViewRegion;

    @BindView(R.id.planetTextViewSurfaceButton)
    TextView textViewSurfaceButton;

    @BindView(R.id.planetTextViewPopulation)
    TextView textViewPopulation;


    public PlanetDetailViewHolder(@NonNull ViewGroup parentView, int layoutId) {
        super(parentView, layoutId);
    }

    public void bind(PlanetUIModel item) {

        textViewName.setText(item.getName());
        textViewRotationPeriod.setText(item.getRotationPeriod());
        textViewOrbitalPeriod.setText(item.getOrbitalPeriod());
        textDiameter.setText(item.getDiameter());
        textViewClimate.setText(item.getClimate());
        textViewGravity.setText(item.getGravity());
        textViewRegion.setText(item.getRegion());
        textViewSurfaceButton.setText(item.getSurfaceWater());
        textViewPopulation.setText(item.getPopulation());

    }
}
