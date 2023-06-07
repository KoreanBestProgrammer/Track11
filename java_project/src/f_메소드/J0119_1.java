package f_메소드;

import java.util.Scanner;

public class J0119_1 {

	public static void main(String[] args) {		
		J0119_1_sub sub = new J0119_1_sub();
		
		String pass = sub.getPass(100);
		String re   = sub.getNoodle(100);
		String re2  = sub.getNoodle(200);
		String name = sub.getName();    
        int point   = sub.getPoint();
        String kor  = sub.getkor();
        int eng     = sub.geteng(); 
        boolean tf  = sub.gettf();
       
        
       System.out.println("name : "+name);
       System.out.println("point : "+point);
       System.out.println("kor : "+kor);
       System.out.println("eng : "+eng);
       System.out.println("tf : "+tf);
       System.out.println("re : "+re);
       System.out.println("re2 : "+re2);
       System.out.println("pass : "+pass);
	}

}
