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

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new MusicTypeFragment();
                break;
            case 1:
                fragment = new FavouriteFragment();
                break;
            case 2:
                fragment = new DownloadFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
