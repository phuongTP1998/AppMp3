package school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Artist;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Name;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Image;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class TopSongJSONModel {
    @SerializedName("im:name")
    private Name songName;
    @SerializedName("im:image")
    private List<Image> songImage;
    @SerializedName("im:artist")
    private Artist songArtist;

    public TopSongJSONModel(Name songName, List<Image> songImage, Artist songArtist) {
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

    public List<Image> getSongImage() {
        return songImage;
    }

    public void setSongImage(List<Image> songImage) {
        this.songImage = songImage;
    }

    public Artist getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(Artist songArtist) {
        this.songArtist = songArtist;
    }
}
