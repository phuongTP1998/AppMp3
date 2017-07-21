package school.coding.techkids.musicplayer_longth.model.topSongJSON;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class Image {
    private String label;
    private Attribute attribute;
    public Image(String label, Attribute attribute){
        this.label = label;
        this.attribute = attribute;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Image{" +
                "label='" + label + '\'' +
                ", attribute=" + attribute +
                '}';
    }
}
