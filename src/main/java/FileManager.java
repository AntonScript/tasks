import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {

    public StringBuilder readFile(String patch){
        try {
            Stream<String> stream = Files.lines(Paths.get(patch));
            StringBuilder stringBuilder = new StringBuilder();
            stream.collect(Collectors.toList()).forEach(s -> stringBuilder.append(s+"\n"));
            return stringBuilder;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeFile(String s, String patch){
        try ( FileChannel fChan = (FileChannel)
                Files.newByteChannel(Paths.get(patch),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE))
        {
            ByteBuffer mBuf = ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8));
            mBuf.rewind();
            fChan.write(mBuf);
            fChan.close();

        } catch(InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }

}
