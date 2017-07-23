package school.coding.techkids.musicplayer_longth.events;

import school.coding.techkids.musicplayer_longth.databases.MusicTypeModel;

/**
 * Created by trongphuong1011 on 7/22/2017.
 */

public class OnClickMusicType {
    private MusicTypeModel musicTypeModel;

    public OnClickMusicType(MusicTypeModel musicTypeModel) {
        this.musicTypeModel = musicTypeModel;
    }

    public MusicTypeModel getMusicTypeModel() {
        return musicTypeModel;
    }

    public void setMusicTypeModel(MusicTypeModel musicTypeModel) {
        this.musicTypeModel = musicTypeModel;
    }
}
