package dx.queen.projectwithguys.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dx.queen.projectwithguys.AdapterRecycler;
import dx.queen.projectwithguys.R;
import dx.queen.projectwithguys.Fragments.API.ResponseJson;
import dx.queen.projectwithguys.Fragments.API.RetrofitInterface;
import dx.queen.projectwithguys.Model.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainFragment extends Fragment {

    InterfaceForFragments listener;
    private RecyclerView rv;
    private AdapterRecycler adapter;
    static List<Value> valuesList = new ArrayList<>();

    public static MainFragment newInstance( InterfaceForFragments interfaceForFragments) {
        MainFragment fragment = new MainFragment();
        fragment.setListener(interfaceForFragments);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        rv = v.findViewById(R.id.recycler_view);
        adapter = new AdapterRecycler();
        rv.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface ri = retrofit.create(RetrofitInterface.class);
        Call<List<Value>> getValue = ri.getValue();

        getValue.enqueue(new Callback<List<Value>>() {
            @Override
            public void onResponse(Call<List<Value>> call, Response<List<Value>> response) {
                ResponseJson rj = (ResponseJson) response.body();

                String name = rj.getCcy();
                String buy = rj.getBuy();
                String sale = rj.getSale();

                Value value = new Value(name, buy, sale);
                valuesList.add(value);


            }

            @Override
            public void onFailure(Call<List<Value>> call, Throwable t) {

            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof InterfaceForFragments){
            listener= (InterfaceForFragments) context;
        }else {
            throw new RuntimeException(context.toString());
        }
    }

    private void setListener(InterfaceForFragments listener) {
        this.listener = listener;
    }

    }

