package uinbdg.skripsi.kopertais.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataItem implements Parcelable {

	@SerializedName("biaya_konsumsi")
	private int biayaKonsumsi;

	@SerializedName("kota")
	private Kota kota;

	@SerializedName("jarak")
	private int jarak;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_kota")
	private int idKota;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("nama")
	private String nama;

	@SerializedName("biaya_inap")
	private int biayaInap;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("latidude")
	private double latidude;

	@SerializedName("id")
	private int id;

	@SerializedName("longitude")
	private double longitude;

	public void setBiayaKonsumsi(int biayaKonsumsi){
		this.biayaKonsumsi = biayaKonsumsi;
	}

	public int getBiayaKonsumsi(){
		return biayaKonsumsi;
	}

	public void setKota(Kota kota){
		this.kota = kota;
	}

	public Kota getKota(){
		return kota;
	}

	public void setJarak(int jarak){
		this.jarak = jarak;
	}

	public int getJarak(){
		return jarak;
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

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
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

	public void setLatidude(int latidude){
		this.latidude = latidude;
	}

	public double getLatidude(){
		return latidude;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"biaya_konsumsi = '" + biayaKonsumsi + '\'' + 
			",kota = '" + kota + '\'' + 
			",jarak = '" + jarak + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id_kota = '" + idKota + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",nama = '" + nama + '\'' + 
			",biaya_inap = '" + biayaInap + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",latidude = '" + latidude + '\'' + 
			",id = '" + id + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.biayaKonsumsi);
		dest.writeParcelable(this.kota, flags);
		dest.writeInt(this.jarak);
		dest.writeString(this.createdAt);
		dest.writeInt(this.idKota);
		dest.writeParcelable((Parcelable) this.deletedAt, flags);
		dest.writeString(this.alamat);
		dest.writeString(this.nama);
		dest.writeInt(this.biayaInap);
		dest.writeString(this.updatedAt);
		dest.writeDouble(this.latidude);
		dest.writeInt(this.id);
		dest.writeDouble(this.longitude);
	}

	public DataItem() {
	}

	protected DataItem(Parcel in) {
		this.biayaKonsumsi = in.readInt();
		this.kota = in.readParcelable(Kota.class.getClassLoader());
		this.jarak = in.readInt();
		this.createdAt = in.readString();
		this.idKota = in.readInt();
		this.deletedAt = in.readParcelable(Object.class.getClassLoader());
		this.alamat = in.readString();
		this.nama = in.readString();
		this.biayaInap = in.readInt();
		this.updatedAt = in.readString();
		this.latidude = in.readDouble();
		this.id = in.readInt();
		this.longitude = in.readDouble();
	}

	public static final Parcelable.Creator<DataItem> CREATOR = new Parcelable.Creator<DataItem>() {
		@Override
		public DataItem createFromParcel(Parcel source) {
			return new DataItem(source);
		}

		@Override
		public DataItem[] newArray(int size) {
			return new DataItem[size];
		}
	};
}