package uinbdg.skripsi.kopertais.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PerjalananResponse{

	@SerializedName("data")
	private List<DataItemPerjalanan> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemPerjalanan> data){
		this.data = data;
	}

	public List<DataItemPerjalanan> getData(){
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
			"PerjalananResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}