package com.vti.entity;

public class Car {
	private String name;
	private String type;
		
	public void Show(Engine E) {
		System.out.println("Name: "+name+" | Type: "+type+" | EngineType: "+E.Show());
	}
	
	public class Engine{
		private String engineType;

		public Engine() {
		}

		public Engine(String engineType) {
			this.engineType = engineType;
		}

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}
		public String Show() {
			return engineType;
		}
		
	}
	public Car() {	
	}
	
	public Car(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
