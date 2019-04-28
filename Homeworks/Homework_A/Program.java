/*
сгенерировать в файл миллион чисел от 0 до 1000, далее в консоле отобразить гистограмму распределения этих чисел
Вопросы: насколько критично указывать в import "*" вместо конкретного импортируемого класса?
*/
import java.io.*;
class Program{
	public static void main(String[] args) {
		System.out.println("Program started");
		final int diapason = 1000;
		// попытаемся создать новый файл и заполнить его данными 
        try(FileWriter writer = new FileWriter("data.txt", false)) // создаем или перезаписываем файл
        {
           // запись всей строки
            for (int i = 0; i < 1000000; i++) {
                writer.write((int)(Math.random() * diapason) + "\n");	
            }
            writer.flush();
           // запись всей строки
            for (int i = 0; i < 1000000; i++) {
                writer.write((int)(Math.random() * diapason) + "\n");	
            }
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
        // считаем данные и построим гистограмму
		try {
            File file = new File("data.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            int distr[] = new int[diapason]; //распределение
            // считаем сначала первую строку
            String line = reader.readLine();
            int value;
            while (line != null) {
            	value = Integer.parseInt(line);	
            	distr[value]++; 
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            // найдем минимальное значение из распределения, чтобы не печатать неинформативную длину столбца гистограммы
            int max = distr[0];
            int min = distr[0];
            int i_max = 0;
            int i_min = 0;
            for (int i = 0; i < diapason; i++) {
            	if (max < distr[i]) {
            		max = distr[i];
            		i_max = i;
            	};
            	if (min > distr[i]) {
            		min = distr[i];
            		i_min = i;
            	};
            }
            System.out.println("min = " + min + " i_min = " + i_min);
            System.out.println("max = " + max + " i_max = " + i_max);	
            // отобразим гистограмму в консоле
            for (int i = 0; i < diapason; i++) {
				String repeated = "";
				for (int j = 0; j <= (distr[i] - min); j++) {
					repeated = repeated + "-";	
				}
				repeated = repeated + i + "/" + distr[i];
            	System.out.println(repeated);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }        
        System.out.println("Program finished"); 
	}
}