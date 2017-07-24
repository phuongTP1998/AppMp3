package school.coding.techkids.musicplayer_longth.events;

import school.coding.techkids.musicplayer_longth.databases.TopSongModel;

/**
 * Created by trongphuong1011 on 7/24/2017.
 */

public class OnClickTopSong {
    private TopSongModel topSongModel;

    public OnClickTopSong(TopSongModel topSongModel) {
        this.topSongModel = topSongModel;
    }

    public TopSongModel getTopSongModel() {
        return topSongModel;
    }

    public void setTopSongModel(TopSongModel topSongModel) {
        this.topSongModel = topSongModel;
    }
}
