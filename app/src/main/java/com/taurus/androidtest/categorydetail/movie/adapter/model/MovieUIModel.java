package com.taurus.androidtest.categorydetail.movie.adapter.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.network.model.movie.Movie;
import com.taurus.androidtest.util.ListConverter;

import java.util.List;

public class MovieUIModel extends GenericItem implements Parcelable {

    private String title;

    private int episodeId;

    private String openingCrawl;

    private String director;

    private String producer;

    private String releaseDate;

    private String id;

    public MovieUIModel() {
    }

    protected MovieUIModel(Parcel in) {
        super(in);
        title = in.readString();
        episodeId = in.readInt();
        openingCrawl = in.readString();
        director = in.readString();
        producer = in.readString();
        releaseDate = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(title);
        dest.writeInt(episodeId);
        dest.writeString(openingCrawl);
        dest.writeString(director);
        dest.writeString(producer);
        dest.writeString(releaseDate);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieUIModel> CREATOR = new Creator<MovieUIModel>() {
        @Override
        public MovieUIModel createFromParcel(Parcel in) {
            return new MovieUIModel(in);
        }

        @Override
        public MovieUIModel[] newArray(int size) {
            return new MovieUIModel[size];
        }
    };

    public static List<MovieUIModel> createList(List<Movie> movieList) {
        return ListConverter.convert(movieList, item -> create(item));
    }

    private static MovieUIModel create(Movie item) {

        final MovieUIModel model = new MovieUIModel();

        model.setTitle(item.getTitle());
        model.setEpisodeId(item.getEpisodeId());
        model.setOpeningCrawl(item.getOpeningCrawl());
        model.setDirector(item.getDirector());
        model.setProducer(item.getProducer());
        model.setReleaseDate(item.getReleaseDate());
        model.setId(item.getId());

        return model;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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
