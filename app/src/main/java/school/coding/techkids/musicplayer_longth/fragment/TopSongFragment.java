package school.coding.techkids.musicplayer_longth.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.adapters.TopSongAdapter;
import school.coding.techkids.musicplayer_longth.managers.ScreenManager;
import school.coding.techkids.musicplayer_longth.model.TopSongJSONModel;
import school.coding.techkids.musicplayer_longth.model.TopSongRespondJSON;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.Image;
import school.coding.techkids.musicplayer_longth.network.GetTopSong;
import school.coding.techkids.musicplayer_longth.network.RetrofitFactory;

/**
 * Created by trongphuong1011 on 7/20/2017.
 */

public class TopSongFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.rv_playlist)
    RecyclerView rvPlaylist;
    @BindView(R.id.tv_style_music)
    TextView tvMusicStyle;
    @BindView(R.id.tv_numberSongs)
    TextView tvNumberSongs;
    private static final String TAG = MusicTypeFragment.class.toString();
    List<TopSongJSONModel> topSongModelList = new ArrayList<>();
    TopSongAdapter topSongAdapter;
    public TopSongFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_song, container, false);
        ButterKnife.bind(this,view);
        setupUI(view);
        loadDatas();
        return view;
    }

    private void loadDatas() {
        final GetTopSong getTopSong = RetrofitFactory.getInstance().create(GetTopSong.class);
        getTopSong.getTopSong(ScreenManager.musicTypeClicked.getId()).enqueue(new Callback<TopSongRespondJSON>() {
            @Override
            public void onResponse(Call<TopSongRespondJSON> call, Response<TopSongRespondJSON> response) {
                List<TopSongJSONModel> entry = response.body().getFeed().getEntry();
                for(TopSongJSONModel topSongJSONModel : entry){
                    List<Image> images = new ArrayList<>();
                    for(Image image : topSongJSONModel.getSongImage()){
                        if(image.getAttribute().getHeight() == 170){
                            images.add(image);
                        }
                    }
                    topSongJSONModel.setSongImage(images);
                    topSongModelList.add(topSongJSONModel);
                }
                tvNumberSongs.setText(topSongModelList.size() + " songs");
                topSongAdapter.notifyDataSetChanged();
                Log.d(TAG, "\nOnResponseList:\n" + topSongModelList);
            }

            @Override
            public void onFailure(Call<TopSongRespondJSON> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupUI(View view) {
        ButterKnife.bind(this,view);
        topSongAdapter = new TopSongAdapter(getContext(),topSongModelList);
        rvPlaylist.setAdapter(topSongAdapter);
        appBar.setBackgroundResource(ScreenManager.musicTypeClicked.getImageID());
        tvMusicStyle.setText(ScreenManager.musicTypeClicked.getKey().toUpperCase());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvPlaylist.setLayoutManager(manager);
        topSongAdapter.setOnItemClick(this);
    }

    @Override
    public void onClick(View view) {
        TopSongJSONModel topSongJSONModel = (TopSongJSONModel) view.getTag();
    }
}
