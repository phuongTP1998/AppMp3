package school.coding.techkids.musicplayer_longth.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import school.coding.techkids.musicplayer_longth.model.TopSongRespondJSON;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public interface GetTopSong {
    @GET("https://itunes.apple.com/us/rss/topsongs/limit=50/genre={user}/explicit=true/json")
    Call<TopSongRespondJSON> getTopSong(@Path("user") String user);
}
