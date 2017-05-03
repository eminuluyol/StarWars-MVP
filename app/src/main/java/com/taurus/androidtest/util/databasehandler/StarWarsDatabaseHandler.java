package com.taurus.androidtest.util.databasehandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

@Singleton
public class StarWarsDatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "categoryManager";

    // Category table name
    private static final String TABLE_CATEGORIES = "categories";

    // Category Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TYPE = "type";
    private static final String KEY_CATEGORY_NAME = "category_name";

    public StarWarsDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CATEGORIES_TABLE = "CREATE TABLE " + TABLE_CATEGORIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TYPE + " INTEGER,"
                + KEY_CATEGORY_NAME + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_CATEGORIES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);

        // Create tables again
        onCreate(sqLiteDatabase);

    }


    public void addCategory(CategoryDatabaseModel category) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TYPE, category.getType());
        values.put(KEY_CATEGORY_NAME, category.getCategoryName());

        db.insert(TABLE_CATEGORIES, null, values);
        db.close();

    }

    public void addAllCategory(List<CategoryDatabaseModel> categories) {

        if(getCategoryCount() == 0) {

            SQLiteDatabase db = this.getWritableDatabase();

            for(int i = 0; i < categories.size(); i++) {

                ContentValues values = new ContentValues();
                values.put(KEY_TYPE, categories.get(i).getType());
                values.put(KEY_CATEGORY_NAME, categories.get(i).getCategoryName());

                db.insert(TABLE_CATEGORIES, null, values);

            }

            db.close();

        }

    }

    public CategoryDatabaseModel getCategory(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CATEGORIES, new String[] { KEY_ID,
                        KEY_TYPE, KEY_CATEGORY_NAME }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        return new CategoryDatabaseModel(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), cursor.getString(2));

    }

    public List<CategoryDatabaseModel> getAllCategories() {

        List<CategoryDatabaseModel> categoryList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORIES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {

            do {

                CategoryDatabaseModel category = new CategoryDatabaseModel();
                category.setId(Integer.parseInt(cursor.getString(0)));
                category.setType(Integer.parseInt(cursor.getString(1)));
                category.setCategoryName(cursor.getString(2));

                categoryList.add(category);

            } while (cursor.moveToNext());

        }

        return categoryList;

    }

    public List<CategoryDatabaseModel> getAllCategoriesOrderByName() {

        List<CategoryDatabaseModel> categoryList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORIES + " ORDER BY " + KEY_CATEGORY_NAME + " ASC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {

            do {

                CategoryDatabaseModel category = new CategoryDatabaseModel();
                category.setId(Integer.parseInt(cursor.getString(0)));
                category.setType(Integer.parseInt(cursor.getString(1)));
                category.setCategoryName(cursor.getString(2));

                categoryList.add(category);

            } while (cursor.moveToNext());

        }

        return categoryList;

    }

    public int getCategoryCount() {

        String countQuery = "SELECT  * FROM " + TABLE_CATEGORIES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        if (cursor != null && cursor.moveToFirst()) {
            if(cursor.getInt (0) == 0) return  0;
        }

         cursor.close();

        return cursor.getCount();

    }

    public int updateCategory(CategoryDatabaseModel category) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TYPE, category.getType());
        values.put(KEY_CATEGORY_NAME, category.getCategoryName());

        // updating row
        return db.update(TABLE_CATEGORIES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(category.getId()) });

    }

    public void deleteContact(CategoryDatabaseModel category) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CATEGORIES, KEY_ID + " = ?",
                new String[] { String.valueOf(category.getId()) });

        db.close();

    }


}
