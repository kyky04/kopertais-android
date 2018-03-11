package uinbdg.skripsi.kopertais.Helper;


import retrofit2.Call;
import retrofit2.http.GET;
import uinbdg.skripsi.kopertais.Model.UniversitasResponse;

public interface KopertaisApi {

    @GET("universitas")
    Call<UniversitasResponse> getAllUniv();

}
