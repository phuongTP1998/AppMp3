package school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class Attribute {
    private int height;

    public Attribute(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return height+"";
    }
}
