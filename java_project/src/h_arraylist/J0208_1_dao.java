package h_arraylist;

import java.util.ArrayList;

public class J0208_1_dao {
	
	
	int getTotalKor(ArrayList<J0208_1_dto> arr) {		
		int totalKor = 0;
		for(int k = 0 ; k < arr.size() ; k++) {			
			totalKor = totalKor + arr.get(k).getKor();
		}
			return totalKor;						
	}
	
	int getTotalEng(ArrayList<J0208_1_dto> arr) {
		int totalEng = 0;
		for(int k = 0 ; k < arr.size() ; k++) {
			totalEng = totalEng + arr.get(k).getEng();						
		}
		return totalEng;
	}	
	
	int getTotalMat(ArrayList<J0208_1_dto> arr) {
	    int	totalMat = 0;
		for(int k = 0 ; k < arr.size() ; k++) {
		    totalMat = totalMat + arr.get(k).getMat();
		}
	     return totalMat;
	
	}	
	
	
	int getTAveKor(ArrayList<J0208_1_dto> arr) {
		int totalave = 0;
		int totalkor = 0;
		for(int k = 0 ; k < arr.size() ; k++) {
			totalkor = totalkor + arr.get(k).getKor();
		}
		    totalave = totalkor/arr.get(0).getCount();
		    return totalave;
		
	}
	
	int getAveEng(ArrayList<J0208_1_dto> arr) {
		int totalave = 0;
		int totaleng = 0;
		for(int k = 0 ; k < arr.size() ; k++) {
			totaleng = totaleng + arr.get(k).getEng();
		}
		totalave = totaleng/arr.get(0).getCount();
		return totalave;
	}
	
	int getAveMat(ArrayList<J0208_1_dto> arr) {
		int totalave = 0;
		int totalmat = 0;
		for(int k = 0 ; k < arr.size() ; k++) {
			totalmat = totalmat + arr.get(k).getMat();			
		}
		totalave = totalmat/arr.get(0).getCount();
		return totalave;
	}
	
	
	
	

	
	
}

