package school.coding.techkids.musicplayer_longth.model;

import android.media.Image;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.jar.Attributes;

import school.coding.techkids.musicplayer_longth.model.topSongJSON.Artist;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.Name;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class TopSongJSONModel {
    @SerializedName("im:name")
    private Name songName;
    @SerializedName("im:image")
    private List<school.coding.techkids.musicplayer_longth.model.topSongJSON.Image> songImage;
    @SerializedName("im:artist")
    private Artist songArtist;

    public TopSongJSONModel(Name songName, List<school.coding.techkids.musicplayer_longth.model.topSongJSON.Image> songImage, Artist songArtist) {
        this.songName = songName;
        this.songImage = songImage;
        this.songArtist = songArtist;
    }

    @Override
    public String toString() {
        return "TopSongJSONModel{" +
                "songName=" + songName +
                ", songImage=" + songImage +
                ", songArtist=" + songArtist +
                '}';
    }

    public Name getSongName() {
        return songName;
    }

    public void setSongName(Name songName) {
        this.songName = songName;
    }

    public List<school.coding.techkids.musicplayer_longth.model.topSongJSON.Image> getSongImage() {
        return songImage;
    }

    public void setSongImage(List<school.coding.techkids.musicplayer_longth.model.topSongJSON.Image> songImage) {
        this.songImage = songImage;
    }

    public Artist getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(Artist songArtist) {
        this.songArtist = songArtist;
    }
}
