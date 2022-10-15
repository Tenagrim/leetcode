package contests.yandex.fast_track.first.secure_contaiment;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./input.txt"));
        PrintWriter writer = new PrintWriter("./output.txt", StandardCharsets.UTF_8);
        List<String> lines = reader.lines().collect(Collectors.toList());
        int n = Integer.valueOf(lines.get(0));
        List<Long> nums = Arrays.stream(lines.get(1).split(" ")).map(Long::valueOf).collect(Collectors.toList());

        if(process(n, nums))
            writer.println("YES");
        else
            writer.println("NO");
        writer.close();
    }

    public static boolean process(int n, List<Long> nums){
        if (n != 0 && (~(n & (n-1))) != -1) // n must be power of 2
            return false;
        if (n != nums.size()) // all servers must be used
            return false;
        int len = n;
        int processed = 0;
        long c = 0;
        nums.sort(Comparator.naturalOrder());
        while (n > 1){
            n /= 2;
            c = nums.get(processed);
            processed++;
            for (int i = processed; i < len - n; i++) {
                if (nums.get(processed) != c)
                    return false;
                processed++;
            }
        }
        return true;
    }

    private class Pair{
        int occur;
        long value;
    }

}
