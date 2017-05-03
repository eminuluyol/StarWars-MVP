package com.taurus.androidtest.util.databasehandler;

import com.taurus.androidtest.network.model.Category;
import com.taurus.androidtest.util.ListConverter;

import java.util.List;

public class CategoryDatabaseModel {

    private int id;
    private String categoryName;
    private int type;

    public CategoryDatabaseModel() {
    }

    public CategoryDatabaseModel(int type, String categoryName) {
        this.categoryName = categoryName;
        this.type = type;
    }

    public CategoryDatabaseModel(int id, int type, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.type = type;
    }

    public static List<CategoryDatabaseModel> createList(List<Category> categoryList) {
        return ListConverter.convert(categoryList, item -> create(item));
    }

    private static CategoryDatabaseModel create(Category item) {

        final CategoryDatabaseModel model = new CategoryDatabaseModel();

        model.setType(item.getType());
        model.setCategoryName(item.getCategoryName());

        return model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
