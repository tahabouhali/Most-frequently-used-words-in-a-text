
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TopWords {
    public static List<String> top3(String text) {
        final Map<String, Integer> wordsCount = new HashMap<>();
        Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z']*");
        Matcher matcher = pattern.matcher(text);
        // first extract all words and then put them into a map
        while (matcher.find()) {
            String textFinded = matcher.group().toLowerCase();
            wordsCount.put(s, wordsCount.getOrDefault(textFinded, 1)+1 );
        }
        List<Map.Entry<String, Integer>> topWords = new ArrayList<>(wordsCount.entrySet());
        //sort the list
        topWords.sort(Map.Entry.comparingByValue());
        ArrayList<String> result = new ArrayList<>();
        int j = 0;
        //add the 3 top element to a list and return it =)
        for (int i = topWords.size() - 1; i >= 0; i--) {
            String s = topWords.get(i).getKey();
            if (j > 2 || s == null || s.length() == 0) {
                break;
            }
            if (Character.isAlphabetic(s.charAt(0))) {
                result.add(j, topWords.get(i).getKey());
                j++;
            }
        }

        result.trimToSize();
        return result;
    }
}
