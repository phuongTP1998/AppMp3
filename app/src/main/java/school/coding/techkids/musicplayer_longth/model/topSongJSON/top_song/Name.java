package school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class Name {
    private String label;
    public Name(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
