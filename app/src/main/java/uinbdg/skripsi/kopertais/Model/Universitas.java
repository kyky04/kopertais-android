package uinbdg.skripsi.kopertais.Model;

import com.google.gson.annotations.SerializedName;

public class Universitas{

	@SerializedName("biaya_konsumsi")
	private int biayaKonsumsi;

	@SerializedName("nama")
	private String nama;

	@SerializedName("biaya_inap")
	private int biayaInap;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("jarak")
	private int jarak;

	@SerializedName("latidude")
	private double latidude;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_kota")
	private int idKota;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("alamat")
	private String alamat;

	public void setBiayaKonsumsi(int biayaKonsumsi){
		this.biayaKonsumsi = biayaKonsumsi;
	}

	public int getBiayaKonsumsi(){
		return biayaKonsumsi;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setBiayaInap(int biayaInap){
		this.biayaInap = biayaInap;
	}

	public int getBiayaInap(){
		return biayaInap;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setJarak(int jarak){
		this.jarak = jarak;
	}

	public int getJarak(){
		return jarak;
	}

	public void setLatidude(double latidude){
		this.latidude = latidude;
	}

	public double getLatidude(){
		return latidude;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIdKota(int idKota){
		this.idKota = idKota;
	}

	public int getIdKota(){
		return idKota;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"Universitas{" + 
			"biaya_konsumsi = '" + biayaKonsumsi + '\'' + 
			",nama = '" + nama + '\'' + 
			",biaya_inap = '" + biayaInap + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",jarak = '" + jarak + '\'' + 
			",latidude = '" + latidude + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id_kota = '" + idKota + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}