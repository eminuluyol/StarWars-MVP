package com.taurus.androidtest.categorydetail.adapter.model;

import com.taurus.androidtest.baseadapter.model.GenericItem;
import com.taurus.androidtest.network.model.movie.Movie;
import com.taurus.androidtest.util.ListConverter;

import java.util.List;

public class MovieUIModel extends GenericItem {

    private String title;

    private int episodeId;

    private String openingCrawl;

    private String director;

    private String producer;

    private String releaseDate;

    private String id;

    public MovieUIModel() {
    }

    public static List<MovieUIModel> createList(List<Movie> movieList) {
        return ListConverter.convert(movieList, item -> create(item));
    }

    private static MovieUIModel create(Movie item) {

        final MovieUIModel model = new MovieUIModel();

        model.setTitle(model.getTitle());
        model.setEpisodeId(model.getEpisodeId());
        model.setOpeningCrawl(model.getOpeningCrawl());
        model.setDirector(model.getDirector());
        model.setProducer(model.getProducer());
        model.setReleaseDate(model.getReleaseDate());
        model.setId(model.getId());

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
}
