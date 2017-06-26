import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PortaTestTask {
    public static void main(String[] args) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            text.append(line);
        }
        char result = getAlgorithmResult(text.toString());
        System.out.println("Result: " + result);
    }

    private static char getAlgorithmResult(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isAlphabetic(c)) {
                builder.append(c);
            } else {
                if (builder.length() > 0) {
                    words.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
            if (i == text.length() - 1 && builder.length() > 0) {
                words.add(builder.toString());
                builder = new StringBuilder();
            }
        }

        StringBuilder characters = new StringBuilder();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                int cnt = s.replaceAll("[^" + c + "]", "").length();
                if (cnt == 1) {
                    characters.append(c);
                    break;
                }
            }
        }

        System.out.println("Characters: " + characters.toString());
        for (char c : characters.toString().toCharArray()) {
            int cnt = characters.toString().replaceAll("[^" + c + "]", "").length();
            if (cnt == 1) {
                return c;
            }
        }

        return ' ';
    }

}
