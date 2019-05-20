/*
Реализовать предметную область "Программа передач"
Есть телевизор, В телевизоре есть набор каналов
Канал имеет набор передач, У канала есть название и номер, закрепленный на пульте, Канал может показать текущю передачу.
Есть пульт, который может выбирать каналы.
У передачи есть название, которое выводится на экран.
*/

/*
вопросы:
1. какова должна быть последовательность описания класса в зависимости от модификаторов доступа и описания поля, метода или конструктора
2. если есть у класса поле "name" и есть геттер getName(), то как принято использовать "name" внутри описания класса через поле или через геттер?
*/
package television;

public class Main {

    public static void main(String[] args) {
		Channel[] channels = new Channel[5];
		for (int i = 0; i < channels.length; i++) {
			channels[i] = new Channel("Channel #" + i, i); 
			Program[] programs = new Program[10];
			for (int k = 0; k < programs.length; k++) {
				programs[k] = new Program("Channel #" + i + ". Program #" + k); 
			}
			channels[i].setPrograms(programs);
		}
		
		//создаем экземпляр телевизора
		Tv tv = new Tv();
		
		//увязываем телевизор со списком каналов
		tv.setChannels(channels);
		
		//создаем экземпляр пульта
		Manager manager = new Manager();
		
		//переключаем на канал #1 
		manager.setChannel(tv, 1);
		
		Channel currChannel;
		
		//выводим наименование программы
		currChannel = tv.getCurrentChannel();
		if (currChannel != null) {
			System.out.print("TV is showing :");
			currChannel.getCurrentProgram().printName();
		}	
		
		//переключаем на канал #1 
		manager.setChannel(tv, 6);		
		
		//выводим наименование программы
		currChannel = tv.getCurrentChannel();
		if (currChannel != null) {
			System.out.print("TV is showing :");
			currChannel.getCurrentProgram().printName();
		}	
    }
}
