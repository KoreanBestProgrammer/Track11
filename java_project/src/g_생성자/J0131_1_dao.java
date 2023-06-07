package g_생성자;

public class J0131_1_dao {
	J0131_1_dto getDto(String name, int kor, int eng, int mat){
		J0131_1_dto dto = new J0131_1_dto();
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);	
		
    	return dto;
     }
	
	void setTotal(J0131_1_dto dto) {
		int total = dto.getKor()+
				    dto.getEng()+
				    dto.getMat();
		dto.setTotal(total);
	}
   void setAve(J0131_1_dto dto) {
	   int ave = dto.getTotal()/3;
	   dto.setAve(ave);
   }
   
   void setPrint(J0131_1_dto dto) {
	   System.out.println("name : "+dto.getName());
	   System.out.println("kor : "+dto.getKor());
	   System.out.println("eng : "+dto.getEng());
	   System.out.println("name : "+dto.getMat());
	   System.out.println("total : "+dto.getTotal());
	   System.out.println("ave : "+dto.getAve());
   }
   
   
   void dtoArrPrint(J0131_1_dto[] arr){
          for(int k = 0 ; k < arr.length ; k++) {   	   
    	     System.out.println("성명 : "+arr[k].getName());
    	     System.out.println("총점 : " +arr[k].getTotal());
    	     System.out.println("평균 : "+arr[k].getAve());
   }
   
   
   
   
   }
}
   
   
   
   
	

