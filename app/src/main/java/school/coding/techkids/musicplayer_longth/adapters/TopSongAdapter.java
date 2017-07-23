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

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.databases.TopSongModel;
import school.coding.techkids.musicplayer_longth.model.topSongJSON.top_song.TopSongJSONModel;

/**
 * Created by trongphuong1011 on 7/21/2017.
 */

public class TopSongAdapter extends RecyclerView.Adapter<TopSongAdapter.TopSongViewHolder> {
    private View view;
    private Context context;
    private List<TopSongModel> topSongModels = new ArrayList<>();
    private View.OnClickListener onClickListener;

    public void setOnItemClick(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public TopSongAdapter(Context context, List<TopSongModel> topSongModels) {
        this.context = context;
        this.topSongModels = topSongModels;
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
        holder.setData(topSongModels.get(position));
    }

    @Override
    public int getItemCount() {
        return topSongModels.size();
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
            public void setData(TopSongModel topSongModel){
                if(topSongModel != null)
//                Picasso.with(context).load(topSongJSONModel.getSongImage().get(0).getLabel()).into(ivAvatar);
                    Picasso.with(context).load(topSongModel.getImage().getLabel()).transform(new CropCircleTransformation()).into(ivAvatar);
                    tvSongName.setText(topSongModel.getSongName().getLabel());
                    tvArtist.setText(topSongModel.getSingerName().getLabel());
                    view.setTag(topSongModel);
                }
            }
        }
