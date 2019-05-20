package television;
import java.util.Random;

public class Channel {
	
	//название канала
	private String name;
	
	//номер канала
	private int number;
	
	//список передач у канала
	private Program[] programs;
	
	//рандомно выбираем передачу
	public Program getCurrentProgram() {
		if (programs.length > 0) {
			Random random = new Random();
			return programs[random.nextInt(programs.length - 1)];
		}
		System.err.println("No program at the channel #" + number);
		return null;
	}
	public void setPrograms(Program[] programs) {
		this.programs = programs;
	}
	
	//запретим создавать объекты через конструктор по умолчанию
	private Channel() {
		
	}
	
	//запретим создавать объекты через конструктор по умолчанию
	public Channel(String name, int number) {
		this.name = name;
		this.number = number;
	}	
	
	//вернем имя канала
	public String getName() {
		return this.name;
	}		
	
	//вернем номер канала
	public int getNumber() {
		return this.number;
	}			
}
