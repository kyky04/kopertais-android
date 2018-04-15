package uinbdg.skripsi.kopertais.Model;

import com.google.gson.annotations.SerializedName;

public class DataItemPerjalananDinas {

	@SerializedName("tanggal_keberangkatan")
	private String tanggalKeberangkatan;

	@SerializedName("kendaraan")
	private String kendaraan;

	@SerializedName("tempat_tujuan")
	private String tempatTujuan;

	@SerializedName("jabatan")
	private String jabatan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("pangkat")
	private String pangkat;

	@SerializedName("tempat_berangkat")
	private String tempatBerangkat;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("maksud_perjalanan")
	private String maksudPerjalanan;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("tanggal_kembali")
	private String tanggalKembali;

	@SerializedName("id")
	private int id;

	@SerializedName("lama_perjalanan")
	private int lamaPerjalanan;

	@SerializedName("status")
	private String status;

	public void setTanggalKeberangkatan(String tanggalKeberangkatan){
		this.tanggalKeberangkatan = tanggalKeberangkatan;
	}

	public String getTanggalKeberangkatan(){
		return tanggalKeberangkatan;
	}

	public void setKendaraan(String kendaraan){
		this.kendaraan = kendaraan;
	}

	public String getKendaraan(){
		return kendaraan;
	}

	public void setTempatTujuan(String tempatTujuan){
		this.tempatTujuan = tempatTujuan;
	}

	public String getTempatTujuan(){
		return tempatTujuan;
	}

	public void setJabatan(String jabatan){
		this.jabatan = jabatan;
	}

	public String getJabatan(){
		return jabatan;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setPangkat(String pangkat){
		this.pangkat = pangkat;
	}

	public String getPangkat(){
		return pangkat;
	}

	public void setTempatBerangkat(String tempatBerangkat){
		this.tempatBerangkat = tempatBerangkat;
	}

	public String getTempatBerangkat(){
		return tempatBerangkat;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setMaksudPerjalanan(String maksudPerjalanan){
		this.maksudPerjalanan = maksudPerjalanan;
	}

	public String getMaksudPerjalanan(){
		return maksudPerjalanan;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLamaPerjalanan(int lamaPerjalanan){
		this.lamaPerjalanan = lamaPerjalanan;
	}

	public int getLamaPerjalanan(){
		return lamaPerjalanan;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataItemPerjalananDinas{" +
			"tanggal_keberangkatan = '" + tanggalKeberangkatan + '\'' + 
			",kendaraan = '" + kendaraan + '\'' + 
			",tempat_tujuan = '" + tempatTujuan + '\'' + 
			",jabatan = '" + jabatan + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",pangkat = '" + pangkat + '\'' + 
			",tempat_berangkat = '" + tempatBerangkat + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",maksud_perjalanan = '" + maksudPerjalanan + '\'' + 
			",nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",tanggal_kembali = '" + tanggalKembali + '\'' + 
			",id = '" + id + '\'' + 
			",lama_perjalanan = '" + lamaPerjalanan + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}