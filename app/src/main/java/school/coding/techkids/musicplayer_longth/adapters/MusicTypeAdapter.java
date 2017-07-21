package school.coding.techkids.musicplayer_longth.adapters;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.databases.MusicTypeModel;

/**
 * Created by trongphuong1011 on 7/19/2017.
 */


public class MusicTypeAdapter extends RecyclerView.Adapter<MusicTypeAdapter.MusicTypeViewHolder>{
    private List<MusicTypeModel> musicTypeModelList = new ArrayList<>();
    private Context context;
    private View.OnClickListener onClickListener;
    View view;

    public void setOnItemClick(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public MusicTypeAdapter(List<MusicTypeModel> musicTypeModelList, Context context) {
        this.musicTypeModelList = musicTypeModelList;
        this.context = context;
    }

    //tạo View nếu cần
    @Override
    public MusicTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_music_types, parent, false);
        view.setOnClickListener(onClickListener);

        return new MusicTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicTypeViewHolder holder, int position) {
        holder.setData(musicTypeModelList.get(position));
    }

    // vào hàm này đầu tiên nhé!
    @Override
    public int getItemCount() {
        return musicTypeModelList.size();
    }

    public class MusicTypeViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public MusicTypeViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_music);
            textView = itemView.findViewById(R.id.tv_item_music_type);
            view = itemView;
        }

        public void setData(MusicTypeModel musicTypeModel){
            if(musicTypeModel != null) {
                Picasso.with(context).load(musicTypeModel.getImageID()).into(imageView);
                textView.setText(musicTypeModel.getKey());

                view.setTag(musicTypeModel);
            }
        }
    }
}
