package television;

public class Program {
	
	//наименование передачи
	private String name;
	
	//выводим наименование передачи 
	public void printName() {
		System.out.println(this.name);
	}
	
	//получить имя передачи
	public String getName() {
		return this.name;
	}
	
	//запретим создавать объект через конструктор по умолчанию
	private Program() {
		
	}	
	
	//задать имя передачи
	public Program(String name) {
		this.name = name;
	}
}
