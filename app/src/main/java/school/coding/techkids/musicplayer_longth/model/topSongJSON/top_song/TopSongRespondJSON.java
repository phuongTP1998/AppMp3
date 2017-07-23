package school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song;

import school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.Feed;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class TopSongRespondJSON {
    private Feed feed;

    public TopSongRespondJSON(Feed feed) {
        this.feed = feed;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
}
