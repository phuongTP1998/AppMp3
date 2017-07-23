package school.coding.techkids.musicplayer_longth.model.topSongJSON.search_song;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trongphuong1011 on 7/22/2017.
 */

public class SourceObject {
    @SerializedName("128")
    private String linkSource;

    public String getLinkSource() {
        return linkSource;
    }

    public void setLinkSource(String linkSource) {
        this.linkSource = linkSource;
    }
}
