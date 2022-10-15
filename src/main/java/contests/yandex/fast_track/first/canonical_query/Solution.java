package contests.yandex.fast_track.first.canonical_query;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/// unapproved
public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("./output.txt", StandardCharsets.UTF_8);

        byte[] bytes = Files.readAllBytes(Path.of("./input.txt"));
        int len = bytes.length;

        char c = (char) bytes[0], prev;
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        for (int i = 1; i < len; i++) {
            prev = c;
            c = (char) bytes[i];
            if (c == ';'){
                sb.append(c);
                writer.println(sb.toString());
                sb = new StringBuilder();
            }else if (c == ' '){
                sb.append(' ');
                while ((char) bytes[i] != ' ')
                    i++;
            }else if (c == '('){
                int cn = 1;
                i++;
                while ( cn != 0){
                    if ((char) bytes[i] == '(')
                        cn ++;
                    if ((char) bytes[i] == ')')
                        cn --;
                    i++;
                }
                sb.append("(...) ");
            }
            else if(c == '"'){
                sb.append('?');
                i++;
                while ((char) bytes[i] != '"')
                    i++;
                //i++;
            }
            else if(c != '\n' && c != '\t' && c != '\r'){
                sb.append(c);
            }
            if (c == '\n')
                sb.append(' ');
        }
        writer.close();
    }
}
