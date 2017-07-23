package school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song;

import java.util.List;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class Feed {
    List<TopSongJSONModel> entry;

    public Feed(List<TopSongJSONModel> entry) {
        this.entry = entry;
    }

    public List<TopSongJSONModel> getEntry() {
        return entry;
    }

    public void setEntry(List<TopSongJSONModel> entry) {
        this.entry = entry;
    }
}
