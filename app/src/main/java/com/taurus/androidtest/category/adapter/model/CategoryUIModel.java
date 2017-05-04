package com.taurus.androidtest.category.adapter.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.util.ListConverter;
import com.taurus.androidtest.util.databasehandler.model.CategoryDatabaseModel;

import java.util.List;

public class CategoryUIModel extends GenericItem implements Parcelable {

    private String categoryName;
    private int type;

    public CategoryUIModel() {
    }

    public CategoryUIModel(int type, String categoryName) {
        this.categoryName = categoryName;
        this.type = type;
    }

    protected CategoryUIModel(Parcel in) {
        super(in);
        categoryName = in.readString();
        type = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(categoryName);
        dest.writeInt(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CategoryUIModel> CREATOR = new Creator<CategoryUIModel>() {
        @Override
        public CategoryUIModel createFromParcel(Parcel in) {
            return new CategoryUIModel(in);
        }

        @Override
        public CategoryUIModel[] newArray(int size) {
            return new CategoryUIModel[size];
        }
    };

    public static List<CategoryUIModel> createList(List<CategoryDatabaseModel> categoryList) {
        return ListConverter.convert(categoryList, item -> create(item));
    }

    private static CategoryUIModel create(CategoryDatabaseModel item) {

        final CategoryUIModel model = new CategoryUIModel(item.getType(), item.getCategoryName());

        return model;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemRecognitionFiled() {
        return type;
    }
}
