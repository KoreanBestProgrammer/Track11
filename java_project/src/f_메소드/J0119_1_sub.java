package f_메소드;

public class J0119_1_sub {

	
	
	String getNoodle(int gram) {
		  String result = "";
		  		  
		  if(gram == 100) result = "소";
		  else if(gram == 200) result = "중";
		  else if(gram == 300) result = "대";
		  		  
		  return result;		  		  
	  }  
	
	  String getName(){
		    String name = "홍길동";
		    return name;	
	  } 
	  
	  int getPoint() {	
		  int point = 100;
		  return point;		  
	  }
	  String getkor() {
		  String kor = "90";
		  return kor;
	  }
	  
	  int geteng() {
		  int eng = 80;
		  return eng;
	  }
	  boolean gettf() {
		  boolean tf = true;
		  return tf;
	  }
	  
	  String getPass(int gram) {
		  String result = "";
		  
		  if(gram > 0 && gram <= 100) { 
		   if(gram >=50 && gram <=100) result = "합격~";			  		  
		   else if(gram >= 1 && gram <=49) result = "불합격";
		  }
		   else result = "점수입력오류"; 
		  
		  return result;
	  }
	    
	  
	   }

	


