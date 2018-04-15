package uinbdg.skripsi.kopertais.Model;

import com.google.gson.annotations.SerializedName;

public class RekomendasiRequest{

	@SerializedName("lama_pejalanan")
	private int lamaPejalanan;

	@SerializedName("tanggal_kembali")
	private String tanggalKembali;

	@SerializedName("tanggal_berangkat")
	private String tanggalBerangkat;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("id_univ")
	private int idUniv;

	public void setLamaPejalanan(int lamaPejalanan){
		this.lamaPejalanan = lamaPejalanan;
	}

	public int getLamaPejalanan(){
		return lamaPejalanan;
	}

	public void setTanggalKembali(String tanggalKembali){
		this.tanggalKembali = tanggalKembali;
	}

	public String getTanggalKembali(){
		return tanggalKembali;
	}

	public void setTanggalBerangkat(String tanggalBerangkat){
		this.tanggalBerangkat = tanggalBerangkat;
	}

	public String getTanggalBerangkat(){
		return tanggalBerangkat;
	}

	public void setIdUser(int idUser){
		this.idUser = idUser;
	}

	public int getIdUser(){
		return idUser;
	}

	public void setIdUniv(int idUniv){
		this.idUniv = idUniv;
	}

	public int getIdUniv(){
		return idUniv;
	}

	@Override
 	public String toString(){
		return 
			"RekomendasiRequest{" + 
			"lama_pejalanan = '" + lamaPejalanan + '\'' + 
			",tanggal_kembali = '" + tanggalKembali + '\'' + 
			",tanggal_berangkat = '" + tanggalBerangkat + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",id_univ = '" + idUniv + '\'' + 
			"}";
		}
}