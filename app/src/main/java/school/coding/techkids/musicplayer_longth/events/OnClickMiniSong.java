package school.coding.techkids.musicplayer_longth.events;

import school.coding.techkids.musicplayer_longth.databases.TopSongModel;


public class OnClickMiniSong {
    private TopSongModel topSongModel;

    public OnClickMiniSong(TopSongModel topSongModel) {
        this.topSongModel = topSongModel;
    }

    public TopSongModel getTopSongModel() {
        return topSongModel;
    }

    public void setTopSongModel(TopSongModel topSongModel) {
        this.topSongModel = topSongModel;
    }
}
