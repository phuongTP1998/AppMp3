package school.coding.techkids.musicplayer_longth.managers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.databases.MusicTypeModel;

/**
 * Created by trongphuong1011 on 7/19/2017.
 */

public class ScreenManager {
    public static MusicTypeModel musicTypeClicked;
    public static void openFragment(FragmentManager fragmentManager, Fragment fragment, int layoutID, MusicTypeModel musicTypeModel){
        musicTypeClicked = musicTypeModel;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_container, fragment);
        fragmentTransaction.commit();
    }
}
