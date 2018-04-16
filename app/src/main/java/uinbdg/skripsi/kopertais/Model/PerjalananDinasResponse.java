package uinbdg.skripsi.kopertais.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import uinbdg.skripsi.kopertais.Model.baru.DataItemPerjalananDinas;

public class PerjalananDinasResponse{

	@SerializedName("data")
	private List<DataItemPerjalananDinas> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemPerjalananDinas> data){
		this.data = data;
	}

	public List<DataItemPerjalananDinas> getData(){
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
			"PerjalananDinasResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}