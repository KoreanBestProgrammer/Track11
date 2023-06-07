package g_생성자;

public class J0126_1 {

	public static void main(String[] args) {
		String name = "홍길동";
		System.out.println("name : "+name);
		
		J0126_dto dto = new J0126_dto();
		J0126_dto dto_2 = new J0126_dto("홍길동");
		System.out.println("name : "+dto.getName());
		System.out.println("name : "+dto_2.getName());

		
		/*System.out.println("dto : "+dto);
		
		System.out.println("name : "+dto.getName());
		
		dto.setName("홍길동");
		name = dto.getName();
		System.out.println("name : "+name);

		dto.setName("이상화");
		System.out.println("name : "+dto.getName());*/

		

	}

}
