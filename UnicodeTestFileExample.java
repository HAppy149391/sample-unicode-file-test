import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnicodeTestFileExample {

    public static void main(String[] args) throws IOException {
        //File Path
        String uri = "/Users/happy/Desktop/HAppy/Java/Core Java/test_file.txt";
        //Counter variable for input occurrences in given file
        AtomicLong counter = new AtomicLong(0);
        File file = new File(uri);
        //File Length Check Condition
        if(file.length()==0){
            System.out.println("Given file is Empty");
        }

        //INPUT unicode value
        String input = "\uD835\uDC07\uD835\uDC00\uD835\uDC11\uD835\uDC08";
        System.out.println("Given input value : " + input);
        Pattern p = Pattern.compile(input);

        try (Stream<String> lines = Files.lines(Paths.get("/Users/happy/Desktop/HAppy/Java/Core Java/test_file.txt"), StandardCharsets.UTF_8);){
                    lines.filter(line -> {
                        Matcher matcher = p.matcher(line);
                        while (matcher.find()) {
                            counter.getAndIncrement();
                        }
                        return false;
                    }).count();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Given INPUT '"+ input + "' occurrence in " + counter +" times");
    }
}
