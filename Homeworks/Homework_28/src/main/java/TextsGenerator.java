import java.lang.*;
import java.io.*;
import java.util.*;
class TextsGenerator {
    private static List<String> wordsList;

    private static List<String> getWordsList() {
        return wordsList;
    };

    static void loadWords(String fileName) {
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String currentWord = bufferedReader.readLine();
            wordsList = new ArrayList<>();
            while (currentWord != null) {
                wordsList.add(currentWord);
                currentWord = bufferedReader.readLine();
            }
            //reader.close(); нужно ли закрывать отдельно?
            bufferedReader.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    };

    static void generateFile(String fileName) {
        try {
            fileName = Main.dictionaryName + fileName + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Random random = new Random();
            List <String> listWords = TextsGenerator.getWordsList();
            int listSize = listWords.size();

            String currentWord = null;
            String currentLine = null;
            int wordsInLine = 0;
            int wordsInFile = 0;

            for (int i = 0; i < Main.wordsCountInFile; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                while (wordsInLine < listSize) {
                    if (wordsInFile >= Main.wordsCountInFile) {
                        break;
                    }
                    currentWord = listWords.get(random.nextInt(listSize));
                    stringBuilder.append(currentWord).append(" ");
                    wordsInLine++;
                    wordsInFile++;
                }
                stringBuilder.append("\n");
                currentLine = stringBuilder.toString();
                wordsInLine = 0;
                bufferedWriter.write(currentLine);
            }
            bufferedWriter.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}