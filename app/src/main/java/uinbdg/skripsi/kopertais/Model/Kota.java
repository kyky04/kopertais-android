package uinbdg.skripsi.kopertais.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Kota implements Parcelable {

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_provinsi")
	private int idProvinsi;

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

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
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

	public void setIdProvinsi(int idProvinsi){
		this.idProvinsi = idProvinsi;
	}

	public int getIdProvinsi(){
		return idProvinsi;
	}

	@Override
 	public String toString(){
		return 
			"Kota{" + 
			"nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_provinsi = '" + idProvinsi + '\'' + 
			"}";
		}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.nama);
		dest.writeString(this.updatedAt);
		dest.writeString(this.createdAt);
		dest.writeInt(this.id);
		dest.writeParcelable((Parcelable) this.deletedAt, flags);
		dest.writeInt(this.idProvinsi);
	}

	public Kota() {
	}

	protected Kota(Parcel in) {
		this.nama = in.readString();
		this.updatedAt = in.readString();
		this.createdAt = in.readString();
		this.id = in.readInt();
		this.deletedAt = in.readParcelable(Object.class.getClassLoader());
		this.idProvinsi = in.readInt();
	}

	public static final Parcelable.Creator<Kota> CREATOR = new Parcelable.Creator<Kota>() {
		@Override
		public Kota createFromParcel(Parcel source) {
			return new Kota(source);
		}

		@Override
		public Kota[] newArray(int size) {
			return new Kota[size];
		}
	};
}