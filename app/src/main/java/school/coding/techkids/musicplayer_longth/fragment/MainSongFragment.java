package school.coding.techkids.musicplayer_longth.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.BlurTransformation;
import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.databases.MiniSongModel;
import school.coding.techkids.musicplayer_longth.databases.TopSongModel;
import school.coding.techkids.musicplayer_longth.events.OnClickMiniSong;
import school.coding.techkids.musicplayer_longth.events.OnClickTopSong;

/**
 * Created by trongphuong1011 on 7/27/2017.
 */

public class MainSongFragment extends Fragment implements View.OnClickListener  {
    @BindView(R.id.tv_song)
    TextView tvSong;
    @BindView(R.id.tv_singer)
    TextView tvSinger;
    @BindView(R.id.iv_picture_middle)
    ImageView ivPictureMiddle;
    @BindView(R.id.iv_under_middle)
    ImageView ivPictureUnder;
    @BindView(R.id.fab_bottom)
    FloatingActionButton fabBottom;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    private TopSongModel topSongModel;


    public MainSongFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_song,container, false);
        ButterKnife.bind(this,view);

        setupUI(view);
        loadData();
        return view;
    }

    private void setupUI(View view) {
        EventBus.getDefault().register(this);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getFragmentManager().getBackStackEntryCount()>0){
                    getFragmentManager().popBackStack();
                } else{
                    Toast.makeText(getContext(),"co bug roi d m",Toast.LENGTH_SHORT).show();
                    RelativeLayout rlMini = getActivity().findViewById(R.id.rlayout_mini);
                    rlMini.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public MiniSongModel miniSongModel = new MiniSongModel();

    private void loadData() {
        tvSong.setText(topSongModel.getSongName().getLabel());
        tvSinger.setText(topSongModel.getSingerName().getLabel());
        Picasso.with(getContext()).load(topSongModel.getImage().getLabel()).into(ivPictureMiddle);
        Picasso.with(getContext()).load(topSongModel.getImage().getLabel()).transform(new BlurTransformation(getContext())).into(ivPictureUnder);
    }


    @Subscribe(sticky = true)
    public void received(OnClickTopSong onClickTopSong){
       topSongModel = onClickTopSong.getTopSongModel();
    }



    @Override
    public void onClick(View view) {

    }

}
