package school.coding.techkids.musicplayer_longth.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;

import school.coding.techkids.musicplayer_longth.fragment.DownloadFragment;
import school.coding.techkids.musicplayer_longth.fragment.FavouriteFragment;
import school.coding.techkids.musicplayer_longth.fragment.MusicTypeFragment;

/**
 * Created by trongphuong1011 on 7/16/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MusicTypeFragment tab1 = new MusicTypeFragment();
                return tab1;
            case 1:
                FavouriteFragment tab2 = new FavouriteFragment();
                return tab2;
            case 2:
                DownloadFragment tab3 = new DownloadFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

//    @Override
//    public Fragment getItem(int position) {
//        return null;
//    }
}
