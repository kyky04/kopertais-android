package uinbdg.skripsi.kopertais.Model.baru;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PegawaiResponse {

	@SerializedName("data")
	private List<DataItemPegawai> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemPegawai> data){
		this.data = data;
	}

	public List<DataItemPegawai> getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"PegawaiResponse{" +
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}