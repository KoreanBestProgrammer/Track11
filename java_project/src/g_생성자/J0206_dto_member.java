package g_생성자;

public class J0206_dto_member {
String id, name, result;
double height, weight;

public J0206_dto_member(String id, String name, double height, double weight, String result) {
	
	this.id = id;
	this.name = name;
	this.height = height;
	this.weight = weight;
	this.result = result;
}
public String getId() {
	return id;
}
public String getName() {
	return name;
}
public String getResult() {
	return result;
}
public double getHeight() {
	return height;
}
public double getWeight() {
	return weight;
}
	
	
	
}
