package uinbdg.skripsi.kopertais.Model;


import com.google.gson.annotations.SerializedName;

public class DataItemPerjalanan {

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("waktu")
	private String waktu;

	@SerializedName("status_keuangan")
	private int statusKeuangan;

	@SerializedName("status_bendahara")
	private int statusBendahara;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("universitas")
	private Universitas universitas;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_universitas")
	private int idUniversitas;

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

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setStatusKeuangan(int statusKeuangan){
		this.statusKeuangan = statusKeuangan;
	}

	public int getStatusKeuangan(){
		return statusKeuangan;
	}

	public void setStatusBendahara(int statusBendahara){
		this.statusBendahara = statusBendahara;
	}

	public int getStatusBendahara(){
		return statusBendahara;
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

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setIdUniversitas(int idUniversitas){
		this.idUniversitas = idUniversitas;
	}

	public int getIdUniversitas(){
		return idUniversitas;
	}

	@Override
 	public String toString(){
		return 
			"DataItemPerjalanan{" +
			"nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",waktu = '" + waktu + '\'' + 
			",status_keuangan = '" + statusKeuangan + '\'' + 
			",status_bendahara = '" + statusBendahara + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",universitas = '" + universitas + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_universitas = '" + idUniversitas + '\'' + 
			"}";
		}
}