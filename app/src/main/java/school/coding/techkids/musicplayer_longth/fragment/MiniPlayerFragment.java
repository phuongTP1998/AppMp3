package school.coding.techkids.musicplayer_longth.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.databases.TopSongModel;
import school.coding.techkids.musicplayer_longth.events.OnClickTopSong;

/**
 * Created by trongphuong1011 on 7/24/2017.
 */

public class MiniPlayerFragment extends Fragment {
    @BindView(R.id.seekbar_mini_player)
    SeekBar sbMiniPlayer;
    @BindView(R.id.iv_avatar_mini_player)
    ImageView ivAvatarMini;
    @BindView(R.id.tv_song_name_mini_player)
    TextView tvSongMini;
    @BindView(R.id.tv_artist_mini_player)
    TextView tvArtistMini;
    private TopSongModel topSongModel;
    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_mini_player,container,false);
//        setupUI(view);
//        loadData();
//        return view;
//    }

    public void setupUI(View view) {
        ButterKnife.bind(this,view);
        EventBus.getDefault().register(this);
    }
    public void loadData(){
        if(topSongModel != null){
            tvSongMini.setText(topSongModel.getSongName().getLabel());
            tvArtistMini.setText(topSongModel.getSingerName().getLabel());
            Picasso.with(getContext()).load(topSongModel.getImage().getLabel()).transform(new CropCircleTransformation()).into(ivAvatarMini);
        }
    }

    @Subscribe(sticky = true)
    public void onReceivedTopSong(OnClickTopSong onClickTopSong){
        topSongModel = onClickTopSong.getTopSongModel();
    }
}
