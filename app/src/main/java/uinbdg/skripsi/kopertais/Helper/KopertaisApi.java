package uinbdg.skripsi.kopertais.Helper;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import uinbdg.skripsi.kopertais.Model.DataItemPerjalanan;
import uinbdg.skripsi.kopertais.Model.PerjalananResponse;
import uinbdg.skripsi.kopertais.Model.UniversitasResponse;

public interface KopertaisApi {

    @GET("universitas")
    Call<UniversitasResponse> getAllUniv();


    @GET("perjalanans")
    Call<PerjalananResponse> getAllPerjalanan();

    @POST("perjalanas")
    Call<PerjalananResponse> postPerjalanan(@Body DataItemPerjalanan itemPerjalanan);
}
