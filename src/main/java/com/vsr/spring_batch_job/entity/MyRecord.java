package com.vsr.spring_batch_job.entity
;

public class MyRecord {
	
	private int id;
	private String name;
	
	public MyRecord(int id2, String name2) {
		this.id = id2;
		this.name = name2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
