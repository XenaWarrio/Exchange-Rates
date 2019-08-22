package dx.queen.projectwithguys.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import dx.queen.projectwithguys.AdapterRecycler;
import dx.queen.projectwithguys.Fragments.API.RetrofitInterface;
import dx.queen.projectwithguys.Model.Value;
import dx.queen.projectwithguys.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainFragment extends Fragment {

    InterfaceForFragments listener;
    private RecyclerView rv;
    private AdapterRecycler adapter;
    public static List<Value> valuesList = new ArrayList<>();

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("TAG", "RETROFIT IS WORKING");

        RetrofitInterface ri = retrofit.create(RetrofitInterface.class);
        Call<List<Value>> getValue = ri.getValue();

        getValue.enqueue(new Callback<List<Value>>() {
            @Override
            public void onResponse(Call<List<Value>> call, Response<List<Value>> response) {
                String rj = response.body().toString();
                jsonStuff(rj);



            }

            @Override
            public void onFailure(Call<List<Value>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString() + "ОШибка с ретрофитом", Toast.LENGTH_SHORT);

            }
        });

        return v;
    }

    private void jsonStuff(String rj){
        try{
            JSONObject obj =  new JSONObject(rj);
            JSONArray ja =  obj.getJSONArray("data");

             for(int i= 0 ; i < ja.length(); i++){
                 Value ry = new Value();
                 JSONObject objForArray = ja.getJSONObject(i);

                 ry.setValueName(objForArray.getString("ccy"));
                 ry.setBuy(objForArray.getString("buy"));
                 ry.setSale(objForArray.getString("sale"));

                 valuesList.add(ry);
                 Log.d("OOOOHMYYY" , ry.getBuy() + "вроде как работает");

                 }

            adapter = new AdapterRecycler();
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(getContext()));

        } catch (JSONException e) {
            e.printStackTrace();
        }



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

