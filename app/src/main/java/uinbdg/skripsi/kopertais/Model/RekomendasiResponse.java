package uinbdg.skripsi.kopertais.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RekomendasiResponse{

	@SerializedName("data")
	private List<DataItemRekomendasi> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemRekomendasi> data){
		this.data = data;
	}

	public List<DataItemRekomendasi> getData(){
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
			"RekomendasiResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}