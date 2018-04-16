package uinbdg.skripsi.kopertais.Model.baru;

import com.google.gson.annotations.SerializedName;

import uinbdg.skripsi.kopertais.Model.Pegawai;
import uinbdg.skripsi.kopertais.Model.Universitas;

public class DataItemRekomendasi {

	@SerializedName("lama_pejalanan")
	private int lamaPejalanan;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("tanggal_kembali")
	private String tanggalKembali;

	@SerializedName("tanggal_berangkat")
	private String tanggalBerangkat;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("universitas")
	private Universitas universitas;

	@SerializedName("id")
	private int id;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("pegawai")
	private Pegawai pegawai;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_univ")
	private int idUniv;

	public void setLamaPejalanan(int lamaPejalanan){
		this.lamaPejalanan = lamaPejalanan;
	}

	public int getLamaPejalanan(){
		return lamaPejalanan;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
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

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setUniversitas(Universitas universitas){
		this.universitas = universitas;
	}

	public Universitas getUniversitas(){
		return universitas;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIdUser(int idUser){
		this.idUser = idUser;
	}

	public int getIdUser(){
		return idUser;
	}

	public void setPegawai(Pegawai pegawai){
		this.pegawai = pegawai;
	}

	public Pegawai getPegawai(){
		return pegawai;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
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
			"DataItemRekomendasi{" +
			"lama_pejalanan = '" + lamaPejalanan + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",tanggal_kembali = '" + tanggalKembali + '\'' + 
			",tanggal_berangkat = '" + tanggalBerangkat + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",universitas = '" + universitas + '\'' + 
			",id = '" + id + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",pegawai = '" + pegawai + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_univ = '" + idUniv + '\'' + 
			"}";
		}
}