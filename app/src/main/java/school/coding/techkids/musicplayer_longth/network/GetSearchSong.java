package school.coding.techkids.musicplayer_longth.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.search_song.SearchMain;

/**
 * Created by trongphuong1011 on 7/22/2017.
 */

public interface GetSearchSong {
    @GET("http://api.mp3.zing.vn/api/mobile/search/song")
    Call<SearchMain> getSearchSong(@Query("requestdata") String request);
}
