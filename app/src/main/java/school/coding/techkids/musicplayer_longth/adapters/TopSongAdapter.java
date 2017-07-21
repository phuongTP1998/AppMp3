package school.coding.techkids.musicplayer_longth.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.fragment.TopSongFragment;
import school.coding.techkids.musicplayer_longth.model.TopSongJSONModel;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class TopSongAdapter extends RecyclerView.Adapter<TopSongAdapter.TopSongViewHolder> {
    private View view;
    private Context context;
    private List<TopSongJSONModel> musicTypeModelList = new ArrayList<>();
    private View.OnClickListener onClickListener;

    public void setOnItemClick(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public TopSongAdapter(Context context, List<TopSongJSONModel> musicTypeModelList) {
        this.context = context;
        this.musicTypeModelList = musicTypeModelList;
    }

    @Override
    public TopSongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_playlist,parent, false);
        view.setOnClickListener(onClickListener);
        return new TopSongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopSongViewHolder holder, int position) {
        holder.setData(musicTypeModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return musicTypeModelList.size();
    }


    public class TopSongViewHolder extends RecyclerView.ViewHolder{
            ImageView ivAvatar;
            TextView tvSongName;
            TextView tvArtist;
            public TopSongViewHolder(View itemView) {
                super(itemView);
                ivAvatar = itemView.findViewById(R.id.iv_avatarSong);
                tvSongName = itemView.findViewById(R.id.tv_song);
                tvArtist = itemView.findViewById(R.id.tv_artist);
                view = itemView;
            }
            public void setData(TopSongJSONModel topSongJSONModel){
                if(topSongJSONModel==null)
                    return;
                Picasso.with(context).load(topSongJSONModel.getSongImage().get(0).getLabel()).into(ivAvatar);
                tvSongName.setText(topSongJSONModel.getSongName().getLabel());
                tvArtist.setText(topSongJSONModel.getSongArtist().getLabel());
                view.setTag(topSongJSONModel);
            }
        }
}
