package school.coding.techkids.musicplayer_longth.managers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public static void loadSearchSong(final TopSongModel topSongModel, final Context context) {
        GetSearchSong getSearchSong = RetrofitFactory.getInstance().create(GetSearchSong.class);
        getSearchSong.getSearchSong("{\"q\":\""
                + topSongModel.getSongName()
                + " " + topSongModel.getSingerName() + "\", \"sort\":\"hot\", \"start\":\"0\", \"length\":\"10\"}").enqueue(new Callback<SearchMain>() {
            @Override
            public void onResponse(Call<SearchMain> call, Response<SearchMain> response) {
                if(response.body().getDocs().size()>0){
                    //1. list ratio
                    List<Integer> ratioList = new ArrayList<>();
                    for(DocObject docObject : response.body().getDocs()) {
                        int ratio = FuzzyMatch.getRatio(topSongModel.getSongName() +" "+ topSongModel.getSingerName()
                                ,docObject.getTitle()+" "+docObject.getArtist(),false);
                        ratioList.add(ratio);
                    }
                    //2.get Max
                    for (int i = 0; i <ratioList.size();i++){
                        if(Collections.max(ratioList)== ratioList.get(i)){
                            String linkSource = response.body().getDocs().get(i).getSource().getLinkSource();
                            topSongModel.setLinkSource(linkSource);
                            Log.d(TAG,"onResponse: " + linkSource);
                        }
                    }

                }else{
                    Toast.makeText(context, "Not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchMain> call, Throwable t) {
                Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
