package n_exception;

public class J0213_4_sub {

	int getTotal(String kor, String eng) throws Exception{// throws Exception : try로 감싸줘야함.
		int total = 0;
		try {
			 total = Integer.parseInt(kor)+Integer.parseInt(eng);
		}catch(Exception e) {
			System.out.println("오류!!!!!");
		}				
		return total;		
	}
	
	int getAve(int total, String count) throws Exception{
		int ave = 0;
		try {
		ave = total/Integer.parseInt(count);
		} catch(Exception e) {
			System.out.println("평균 오류~~~~");
		}
		return ave;
	}
	
}
