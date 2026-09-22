package com.mycompany.riyadhmetromanagmentsystem;

public class Station {
	private int id;

	private String name;
	private String name_Line;
	private String facilities;
	public Station( int id , String name, String name_Line, String facilities) {
		this.id = id;
		this.name = name;
		this.name_Line = name_Line;
		this.facilities = facilities;
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
	public String getName_Line() {
		return name_Line;
	}
	public void setName_Line(String name_Line) {
		this.name_Line = name_Line;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", name_Line=" + name_Line + ", facilities=" + facilities + "]";
	}
	
	
}
