package m_interface;

public class Dog implements InterAA, InterBB {

	@Override
	public String getColor() {
		
		return "검정";
	}

	@Override
	public String getVoice() {
		
		return "멍멍";
	}

}
