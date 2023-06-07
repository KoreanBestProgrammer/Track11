package m_interface;

public class J0210_main {

	public static void main(String[] args) {
	InterAA in = new Cat();
	System.out.println(in.getVoice());
	
    InterBB in2 = new Cat();
    System.out.println(in2.getColor());
    
    Animal in3 = new Cat();
    System.out.println(in3.getName());
    
    Cat in4 = new Cat();
    System.out.println(in4.getName());
    System.out.println(in4.getVoice());
    System.out.println(in4.getColor());
    
    
    Dog in5 = new Dog();
    InterAA in6 = new Dog();
    InterBB in7 = new Dog();
    
	}
	

}
