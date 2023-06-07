package n_exception;

public class J0213_3 {

	public static void main(String[] args) {
		String[] str = new String[2];
		str[0] = "100";
		str[1] = "이백";
		int kor = 0, eng = 0, total = 0;
		try {
			kor = Integer.parseInt(str[0]);
			eng = Integer.parseInt(str[1]);
			total = kor + eng;
		}catch(Exception e) {
			System.out.println("catch 11~~~");
		}finally {
			
		}
	System.out.println("kor : "+kor);
	System.out.println("eng : "+eng);
	System.out.println("total : "+total);
    System.out.println("종료~~");
	}

	}


