package com.taurus.androidtest.categorydetail.character.adapter.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.network.model.character.Character;
import com.taurus.androidtest.network.model.character.CharacterWrapper;
import com.taurus.androidtest.util.ListConverter;

import java.util.List;

public class CharacterUIModel extends GenericItem implements Parcelable {

    private String name;

    private String height;

    private String mass;

    private String hairColor;

    private String skinColor;

    private String eyeColor;

    private String birthYear;

    private String gender;

    private String id;

    public CharacterUIModel() {
    }

    protected CharacterUIModel(Parcel in) {
        super(in);
        name = in.readString();
        height = in.readString();
        mass = in.readString();
        hairColor = in.readString();
        skinColor = in.readString();
        eyeColor = in.readString();
        birthYear = in.readString();
        gender = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(name);
        dest.writeString(height);
        dest.writeString(mass);
        dest.writeString(hairColor);
        dest.writeString(skinColor);
        dest.writeString(eyeColor);
        dest.writeString(birthYear);
        dest.writeString(gender);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CharacterUIModel> CREATOR = new Creator<CharacterUIModel>() {
        @Override
        public CharacterUIModel createFromParcel(Parcel in) {
            return new CharacterUIModel(in);
        }

        @Override
        public CharacterUIModel[] newArray(int size) {
            return new CharacterUIModel[size];
        }
    };

    public static List<CharacterUIModel> createList(CharacterWrapper characterWrapper) {
        return ListConverter.convert(characterWrapper.getResults(), item -> create(item));
    }

    private static CharacterUIModel create(Character item) {

        final CharacterUIModel model = new CharacterUIModel();

        model.setName(model.getName());
        model.setHeight(model.getHeight());
        model.setMass(model.getMass());
        model.setHairColor(model.getHairColor());
        model.setSkinColor(model.getSkinColor());
        model.setEyeColor(model.getEyeColor());
        model.setBirthYear(model.getBirthYear());
        model.setGender(model.getGender());
        model.setId(model.getId());

        return model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
