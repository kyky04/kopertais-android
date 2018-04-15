package uinbdg.skripsi.kopertais.Helper;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import uinbdg.skripsi.kopertais.Model.DataItemPerjalanan;
import uinbdg.skripsi.kopertais.Model.DataItemPerjalananDinas;
import uinbdg.skripsi.kopertais.Model.Pegawai;
import uinbdg.skripsi.kopertais.Model.PegawaiResponse;
import uinbdg.skripsi.kopertais.Model.PerjalananDinasResponse;
import uinbdg.skripsi.kopertais.Model.PerjalananResponse;
import uinbdg.skripsi.kopertais.Model.RekomendasiRequest;
import uinbdg.skripsi.kopertais.Model.RekomendasiResponse;
import uinbdg.skripsi.kopertais.Model.UniversitasResponse;

public interface KopertaisApi {

    @GET("universitas")
    Call<UniversitasResponse> getAllUniv();

    @GET("pegawais")
    Call<PegawaiResponse> getAllPegawai();


    @GET("perjalanans")
    Call<PerjalananResponse> getAllPerjalanan();

    @GET("rekomendasis")
    Call<RekomendasiResponse> getAllRekomendasi();

    @GET("perjalanan_dinas")
    Call<PerjalananDinasResponse> getAllPerjalananDinas();

    @POST("perjalanans")
    Call<PerjalananResponse> postPerjalanan(@Body DataItemPerjalanan itemPerjalanan);

    @POST("rekomendasis")
    Call<RekomendasiResponse> postRekomendasi(@Body RekomendasiRequest itemPerjalanan);

    @POST("perjalanan_dinas")
    Call<PerjalananDinasResponse> postPerjalananDinas(@Body DataItemPerjalananDinas itemPerjalanan);
}
