package xyz.siavash.kntuclass.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    private Href self;
    @SerializedName("previousepisode")
    @Expose
    private Href previousepisode;
    @SerializedName("nextepisode")
    @Expose
    private Href nextepisode;

    public Href getSelf() {
        return self;
    }

    public void setSelf(Href self) {
        this.self = self;
    }

    public Href getPreviousepisode() {
        return previousepisode;
    }

    public void setPreviousepisode(Href previousepisode) {
        this.previousepisode = previousepisode;
    }

    public Href getNextepisode() {
        return nextepisode;
    }

    public void setNextepisode(Href nextepisode) {
        this.nextepisode = nextepisode;
    }

}
