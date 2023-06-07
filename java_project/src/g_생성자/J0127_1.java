package g_생성자;

public class J0127_1 {

	public static void main(String[] args) {
    
		J0127_dto dto = new J0127_dto();
		
		dto.setId("101");
		String id = dto.getId();
		
		dto.setId("201");
		id = dto.getId();		
		System.out.println(id);
		
		dto.setName("홍길동");
		String name = dto.getName();
		System.out.println(name);
		
		
		J0127_dto dto2 = new J0127_dto("301");
		id = dto2.getId();
		dto2.setName("홍길동");
		name = dto2.getName();
		
		J0127_dto dto3 = new J0127_dto("301","이상화","대전",25);
		id = dto3.getId();
		name = dto3.getName();
		String area = dto3.getArea();
		int age  = dto3.getAge();
		
		
		J0127_dto dto4 = new J0127_dto();
		dto4.setId("301");
		dto4.setName("이상화");
		dto4.setArea("대전");
		dto4.setAge(25);

		

		
		
	}

}
