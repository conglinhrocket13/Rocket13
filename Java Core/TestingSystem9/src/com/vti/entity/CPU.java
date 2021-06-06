package com.vti.entity;

public class CPU {
	private int price;
	
	
	public CPU() {		
	}

	public CPU(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public static class  Processor{
		private int coreAmount; 
		private String manufacturer;

		public Processor() {
		}

		public Processor(int coreAmount, String manufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.manufacturer = manufacturer;
		}
		
		public int getCoreAmount() {
			return coreAmount;
		}

		public void setCoreAmount(int coreAmount) {
			this.coreAmount = coreAmount;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public static float getCache() {
			return 4.3f;
		}
	}
	
	public class  Ram{
		private int coreAmount; 
		private String manufacturer;
		
		public Ram() {
		}

		public Ram(int coreAmount, String manufacturer) {
			this.coreAmount = coreAmount;
			this.manufacturer = manufacturer;
		}

		public int getCoreAmount() {
			return coreAmount;
		}

		public void setCoreAmount(int coreAmount) {
			this.coreAmount = coreAmount;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public float getClockSpeed() {
			return 5.5f;
		}
	}
}
