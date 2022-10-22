package contests.yandex.weekend_offer.first.photo_strip;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./input.txt"));
        PrintWriter writer = new PrintWriter("./output.txt", StandardCharsets.UTF_8);
        List<String> lines = reader.lines().collect(Collectors.toList());
        int width = Integer.parseInt(lines.get(0));
        int n = Integer.parseInt(((String)lines.get(1)).split(" ")[0]);
        int k = Integer.parseInt(((String)lines.get(1)).split(" ")[1]);

        lines.remove(0);
        lines.remove(0);

        List<Long> heights = parsePhotos(lines, width);

        long minSum = heights.stream().sorted((el1,el2)-> (int) (el1-el2)).limit(k).mapToLong(Long::longValue).sum();
        long maxSum = heights.stream().sorted((el1,el2)-> (int) (el2-el1)).limit(k).mapToLong(Long::longValue).sum();

        writer.println(minSum);
        writer.println(maxSum);

        reader.close();
        writer.close();
    }
    private static List<Long> parsePhotos (List<String> input, int width){
        List<Long> res = new ArrayList<>();
        for(String s : input){
            String[] sp = s.split("x");
            int w = Integer.parseInt(sp[0]);
            int h = Integer.parseInt(sp[1]);
            Long nH = width == 0 ? 0 : (long) Math.ceil((h * width) / (double) w);
            res.add(nH);
        }
        return res;
    }
}
