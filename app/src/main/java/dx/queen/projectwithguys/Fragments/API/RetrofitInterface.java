package dx.queen.projectwithguys.Fragments.API;

import java.util.List;

import dx.queen.projectwithguys.Model.Value;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("/p24api/pubinfo?json&exchange&coursid=5")
    Call<List<Value>> getValue();
}
