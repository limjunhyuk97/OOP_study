package car;

public enum VanSize{
	
	A("����"), B("����"), C("����");
	
	private String name;
	private VanSize(String str) {
		this.name = str;
	}
	public String toString() {
		return name;
	}
}