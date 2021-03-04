import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        StringBuilder blackListStr = fileManager.readFile("data/black-list.txt");
        String[] strings = blackListStr.toString().split("\n");
        List<String> blackList = Arrays.asList(strings);
        Moderator moderator = new Moderator(fileManager, blackList, "/input","/output");
        moderator.CrawlingAllFiles();
    }
}
