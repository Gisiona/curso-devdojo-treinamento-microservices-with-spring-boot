package br.com.demospringboot.dto;

public class ResponseData<Data> {

	private Data data;

	public ResponseData(Data data) {
		super();
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
