package l_추상;

public class J0210_main {

	public static void main(String[] args) {
		Cat cat = new Cat();
		String voice = cat.getVoice();
		String height = cat.getHeight();
		System.out.println("고양이소리 : "+voice);
		
		Animal cat2 = new Cat();
		System.out.println(cat2.getVoice());
	    Animal dog2 = new Dog();
		System.out.println(dog2.getVoice());
		
		Dog dog = new Dog();
		voice = dog.getVoice();
		System.out.println("강아지소리 : "+voice);
		
		
	}

}
