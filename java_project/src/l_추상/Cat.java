package l_추상;

public class Cat extends Animal{
	
	String getHeight() {
		return "25cm";
	}
	
	
	@Override
	String getVoice() {
		return "야옹~";
	}
	
	String getSound() {		 
		return "야옹~";
	}
	@Override
    int getWeight() {
    	return 0;
    }
	
	
}
