package school.coding.techkids.musicplayer_longth;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import school.coding.techkids.musicplayer_longth.adapters.PagerAdapter;
import school.coding.techkids.musicplayer_longth.fragment.DownloadFragment;
import school.coding.techkids.musicplayer_longth.fragment.FavouriteFragment;
import school.coding.techkids.musicplayer_longth.fragment.MusicTypeFragment;
import school.coding.techkids.musicplayer_longth.model.AllMusicTypesJSONModel;
import school.coding.techkids.musicplayer_longth.network.GetMusicTypes;
import school.coding.techkids.musicplayer_longth.network.RetrofitFactory;

public class MusicPlayer extends AppCompatActivity {
    private TabLayout tabLayout;
    private android.support.v4.view.PagerAdapter pagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        this.setupTabIcons(tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setAlpha(255);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setAlpha(100);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab.getIcon().setAlpha(100);
            }
        });
    }
//ToDo: em định add vào Transaction thế này mà ko được, vướng cái PagerAdapter
//    public void addFragment(View view, int tabPosition){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        Fragment fragment = null;
//    if (view.getId()==R.id.tabs){
//        switch (tabPosition){
//            case 0: fragment = new MusicTypeFragment();
//                break;
//            case 1: fragment = new FavouriteFragment();
//                break;
//            case 2: fragment = new DownloadFragment();
//                break;
//        }
//    }
//        fragmentTransaction.add(R.id.viewpager,fragment);
//        fragmentTransaction.commit();
//    }


    private void setupTabIcons(TabLayout tabLayout) {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dashboard_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_file_download_black_24dp);
        tabLayout.getTabAt(0).getIcon().setAlpha(100);
        tabLayout.getTabAt(1).getIcon().setAlpha(100);
        tabLayout.getTabAt(2).getIcon().setAlpha(100);
    }
}


