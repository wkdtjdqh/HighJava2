package kr.or.ddit.basic.json;

public class Sample {
	private int id;
	private String name;
	
	// 기본 생성자 / ibatis는 내부적으로 기본 생성자를 통해서 객체를 만든다.
	public Sample() {}
	
	// 생성자
	public Sample(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
