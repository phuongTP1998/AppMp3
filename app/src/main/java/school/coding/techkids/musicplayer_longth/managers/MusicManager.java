package school.coding.techkids.musicplayer_longth.managers;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import hybridmediaplayer.HybridMediaPlayer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.databases.TopSongModel;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.search_song.DocObject;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.search_song.SearchMain;
import school.coding.techkids.musicplayer_longth.network.GetSearchSong;
import school.coding.techkids.musicplayer_longth.network.RetrofitFactory;
import school.coding.techkids.musicplayer_longth.utils.FuzzyMatch;

/**
 * Created by trongphuong1011 on 7/22/2017.
 */

public class MusicManager {
    private static final String TAG = "TrongPhuong";
    private static HybridMediaPlayer hybridMediaPlayer;

    public static void loadSearchSong(final TopSongModel topSongModel, final Context context, final FloatingActionButton floatingActionButton, final SeekBar sbMiniPlayer) {
        GetSearchSong getSearchSong = RetrofitFactory.getInstance().create(GetSearchSong.class);
        getSearchSong.getSearchSong("{\"q\":\""
                + topSongModel.getSongName()
                + " " + topSongModel.getSingerName() + "\", \"sort\":\"hot\", \"start\":\"0\", \"length\":\"10\"}").enqueue(new Callback<SearchMain>() {
            @Override
            public void onResponse(Call<SearchMain> call, Response<SearchMain> response) {
                if (response.body().getDocs().size() > 0) {
                    //1. list ratio
                    List<Integer> ratioList = new ArrayList<>();
                    for (DocObject docObject : response.body().getDocs()) {
                        int ratio = FuzzyMatch.getRatio(topSongModel.getSongName() + " " + topSongModel.getSingerName()
                                , docObject.getTitle() + " " + docObject.getArtist(), false);
                        ratioList.add(ratio);
                    }
                    //2.get Max
                    for (int i = 0; i < ratioList.size(); i++) {
                        if (Collections.max(ratioList) == ratioList.get(i)) {
                            String linkSource = response.body().getDocs().get(i).getSource().getLinkSource();
                            topSongModel.setLinkSource(linkSource);
                            Log.d(TAG, "onResponse: " + linkSource);
                            setupMusic(topSongModel, context);
                            updateSongRealTime(topSongModel, floatingActionButton, sbMiniPlayer);
                        }
                    }

                } else {
                    Toast.makeText(context, "Not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchMain> call, Throwable t) {
                Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void setupMusic(TopSongModel topSongModel, Context context) {
        if (hybridMediaPlayer != null) {
            hybridMediaPlayer.release();
        }
        hybridMediaPlayer = HybridMediaPlayer.getInstance(context);
        hybridMediaPlayer.setDataSource(topSongModel.getLinkSource());
        hybridMediaPlayer.prepare();
        hybridMediaPlayer.setOnPreparedListener(new HybridMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(HybridMediaPlayer hybrid) {
                hybridMediaPlayer.play();
            }
        });
    }

    public static void playPause() {
        if (hybridMediaPlayer != null) {
            if (hybridMediaPlayer.isPlaying()) {
                hybridMediaPlayer.pause();
            } else {
                hybridMediaPlayer.play();
            }
        }
    }

    public static void updateSongRealTime(TopSongModel topSongModel, final FloatingActionButton fbActionButton, final SeekBar sbMiniPlayer) {
        final android.os.Handler handler = new android.os.Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sbMiniPlayer.setMax(hybridMediaPlayer.getDuration());
                sbMiniPlayer.setProgress(hybridMediaPlayer.getCurrentPosition());
                if (hybridMediaPlayer.isPlaying()) {
                    fbActionButton.setImageResource(R.drawable.ic_pause_black_24dp);
                } else {
                    fbActionButton.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }
                handler.postDelayed(this, 100);
            }
        };
        runnable.run();
        final int[] currentPosition = new int[1];
        sbMiniPlayer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    currentPosition[0] = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                hybridMediaPlayer.seekTo(currentPosition[0]);
            }
        });
    }
}