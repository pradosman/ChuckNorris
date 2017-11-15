package com.davidpradosm.chuckjokes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by David Prados on 09/11/2017.
 */

public class Joke {

    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("value")
    @Expose
    private String value;



    /**
     * No args constructor for use in serialization
     *
     */
    public Joke() {
    }

    /**
     *
     * @param id
     * @param category
     * @param iconUrl
     * @param value
     * @param url
     */
    public Joke(String category, String iconUrl, String id, String url, String value) {
        super();
        this.category = category;
        this.iconUrl = iconUrl;
        this.id = id;
        this.url = url;
        this.value = value;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Joke withCategory(String category) {
        this.category = category;
        return this;
    }




    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Joke withIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Joke withId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Joke withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Joke withValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "category='" + category + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
