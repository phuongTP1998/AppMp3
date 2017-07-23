package school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class Image {
    private String label;
    private Attribute attributes;
    public Image(String label, Attribute attribute){
        this.label = label;
        this.attributes = attribute;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attribute getAttribute() {
        return attributes;
    }

    public void setAttribute(Attribute attribute) {
        this.attributes = attribute;
    }

    @Override
    public String toString() {
        return "Image{" +
                "label='" + label + '\'' +
                ", attribute=" + attributes +
                '}';
    }
}
