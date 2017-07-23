package school.coding.techkids.musicplayer_longth.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import school.coding.techkids.musicplayer_longth.R;
import school.coding.techkids.musicplayer_longth.adapters.MusicTypeAdapter;
import school.coding.techkids.musicplayer_longth.databases.MusicTypeModel;
import school.coding.techkids.musicplayer_longth.events.OnClickMusicType;
import school.coding.techkids.musicplayer_longth.managers.ScreenManager;
import school.coding.techkids.musicplayer_longth.model.AllMusicTypesJSONModel;
import school.coding.techkids.musicplayer_longth.model.MusicTypeJSONModel;
import school.coding.techkids.musicplayer_longth.network.GetMusicTypes;
import school.coding.techkids.musicplayer_longth.network.RetrofitFactory;

public class MusicTypeFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.rv_music_type)
    RecyclerView rvMusicTypes;
    MusicTypeAdapter musicTypeAdapter;
    private List<MusicTypeModel> musicTypeModelList = new ArrayList<>();

    public MusicTypeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_type, container, false);
        ButterKnife.bind(this,view);

        setupUI(view);
        loadData();
        // Inflate the layout for this fragment
        return view;
    }

    private void loadData() {
        final GetMusicTypes getMusicTypes = RetrofitFactory.getInstance().create(GetMusicTypes.class);
        getMusicTypes.getMusicTypes().enqueue(new Callback<AllMusicTypesJSONModel>() {
            @Override
            public void onResponse(Call<AllMusicTypesJSONModel> call, Response<AllMusicTypesJSONModel> response) {
                for(MusicTypeJSONModel musicTypeJSONModle: response.body().getSubgenres()){
                    MusicTypeModel musicTypeModel = new MusicTypeModel();
                    musicTypeModel.setId(musicTypeJSONModle.getId());
                    musicTypeModel.setKey(musicTypeJSONModle.getTranslation_key());
                    musicTypeModel.setImageID(getContext().getResources()
                            .getIdentifier("genre_x2_" + musicTypeJSONModle.getId(),"raw",getContext().getPackageName()));
                    musicTypeModelList.add(musicTypeModel);
                }

                musicTypeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<AllMusicTypesJSONModel> call, Throwable t) {
                Toast.makeText(getContext(),"No connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupUI(View view) {
        ButterKnife.bind(this,view);

        musicTypeAdapter = new MusicTypeAdapter(musicTypeModelList, getContext());
        rvMusicTypes.setAdapter(musicTypeAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position % 3 == 0 ? 2 : 1;
            }
        });
        rvMusicTypes.setLayoutManager(gridLayoutManager);
        musicTypeAdapter.setOnItemClick(this);
    }

    @Override
    public void onClick(View view) {
        MusicTypeModel musicTypeModel = (MusicTypeModel) view.getTag();
        EventBus.getDefault().postSticky(new OnClickMusicType(musicTypeModel));
        ScreenManager.openFragment(getActivity().getSupportFragmentManager(),new TopSongFragment(),R.id.layout_container);
    }
}
