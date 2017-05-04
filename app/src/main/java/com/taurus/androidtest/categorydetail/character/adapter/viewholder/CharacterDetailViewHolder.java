package com.taurus.androidtest.categorydetail.character.adapter.viewholder;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taurus.androidtest.R;
import com.taurus.androidtest.baseadapter.viewholder.BaseViewHolder;
import com.taurus.androidtest.categorydetail.character.adapter.model.CharacterUIModel;

import butterknife.BindView;

public class CharacterDetailViewHolder extends BaseViewHolder {

    @BindView(R.id.characterTextViewHeight)
    TextView textViewHeight;

    @BindView(R.id.characterTextViewMass)
    TextView textViewMass;

    @BindView(R.id.characterTextViewHairColor)
    TextView textViewHairColor;

    @BindView(R.id.characterTextViewSkinColor)
    TextView textViewSkinColor;

    @BindView(R.id.characterTextViewEyeColor)
    TextView textViewEyeColor;

    @BindView(R.id.characterTextViewBirthYear)
    TextView textViewBirthYear;

    @BindView(R.id.characterTextViewGender)
    TextView textViewGender;

    @BindView(R.id.characterTextViewName)
    TextView textViewName;

    public CharacterDetailViewHolder(@NonNull ViewGroup parentView, int layoutId) {
        super(parentView, layoutId);
    }

    public void bind(CharacterUIModel item) {

        textViewHeight.setText(item.getHeight());
        textViewMass.setText(item.getMass());
        textViewHairColor.setText(item.getHairColor());
        textViewSkinColor.setText(item.getSkinColor());
        textViewEyeColor.setText(item.getEyeColor());
        textViewBirthYear.setText(item.getBirthYear());
        textViewGender.setText(item.getGender());
        textViewName.setText(item.getName());

    }
}
