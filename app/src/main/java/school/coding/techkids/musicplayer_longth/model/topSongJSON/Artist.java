package school.coding.techkids.musicplayer_longth.model.topSongJSON;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class Artist {
    private String label;
    public Artist(String label){
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
        return "Artist{" +
                "label='" + label + '\'' +
                '}';
    }
}
