package m_interface;

public class Cat extends Animal implements InterAA, InterBB {
	
	@Override
	public String getVoice() {
		
		return "야옹";
	}
	
	@Override
	String getName() {
		
		return "cat";
	}
	
	@Override
	public String getColor() {
		
		return "노랑";
	}
	
	
}
