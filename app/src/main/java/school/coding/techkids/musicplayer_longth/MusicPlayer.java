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

    private int[] tabIcons = {
            R.drawable.dash_board,
            R.drawable.favorite,
            R.drawable.download
    };
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setupTabIcons();

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
//                addFragment(viewPager,tab.getPosition());
                setupTabIcons();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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


    private void setupTabIcons() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
    }
}


