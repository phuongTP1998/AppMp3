package school.coding.techkids.musicplayer_longth.databases;

import android.media.Image;

import school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Artist;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Name;

/**
 * Created by trongphuong1011 on 7/22/2017.
 */

public class TopSongModel {
    private school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Image image;
    private Name songName;
    private Artist singerName;
    private String linkSource;

    public Name getSongName() {
        return songName;
    }

    public void setSongName(Name songName) {
        this.songName = songName;
    }

    public Artist getSingerName() {
        return singerName;
    }

    public void setSingerName(Artist singerName) {
        this.singerName = singerName;
    }

    public String getLinkSource() {
        return linkSource;
    }

    public void setLinkSource(String linkSource) {
        this.linkSource = linkSource;
    }

    public school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Image getImage() {
        return image;
    }

    public void setImage(school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Image image) {
        this.image = image;
    }
}
