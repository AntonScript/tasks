import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Moderator {
    private FileManager fileManager;
    private List<String> blackList;
    private String readDirectory;
    private String writeDirectory;
    private static final String mark = "****";
    private static final String patch = "data";

    public Moderator(FileManager fileManager, List<String> blackList, String readDirectory, String writeDirectory) {
        this.fileManager = fileManager;
        this.blackList = blackList;
        this.readDirectory = readDirectory;
        this.writeDirectory = writeDirectory;
    }

    public void moderation(String nameFile){
        String filePath = patch+readDirectory+nameFile;
        String result = fileManager.readFile(filePath).toString();
        for (String forbiddenWord : blackList){
            result = result.replace(forbiddenWord,mark);
        }
        String pathToWrite = patch+writeDirectory+nameFile;
        fileManager.writeFile(result,pathToWrite);
    }

    public void CrawlingAllFiles(){
        try {
           Files.walk(Paths.get(patch+readDirectory))
                    .filter(Files::isRegularFile)
                    .map(path -> path.getFileName().toString())
                    .forEach(s -> moderation("/"+s));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
