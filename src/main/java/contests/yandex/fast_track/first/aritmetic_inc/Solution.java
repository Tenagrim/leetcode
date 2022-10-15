package contests.yandex.fast_track.first.aritmetic_inc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./input_yandex_cloud.txt"));
        PrintWriter writer = new PrintWriter("./output.txt", StandardCharsets.UTF_8);
        Map<Long, List<Node>> str = new TreeMap<>();
        Map<Long, Node> ids = new TreeMap<>();

        List<String> lines = reader.lines().collect(Collectors.toList());

        Integer count = Integer.valueOf(lines.get(0));

        for (int i = 1; i <= count; i++) {
            String line = lines.get(i);
            List<Integer> ints = Arrays.stream(line.split(" ")).map(Integer::valueOf).collect(Collectors.toList());

            switch (ints.get(0)) {
                case(1) : {
                    addNeNode(ints, str, ids);
                    break;
                }
                case(2) : {
                    deleteNode(ints, str, ids);
                    break;
                }
                case(3) : {
                    getFirstMinNode(writer, str, ids);
                    break;
                }
            }
        }
        writer.close();
    }

    private static void getFirstMinNode(PrintWriter writer, Map<Long, List<Node>> str, Map<Long, Node> ids) {

        Map.Entry<Long, List<Node>> it = str.entrySet().iterator().next();
        Optional<Node> min = it.getValue().stream().min(Comparator.comparing(Node::getId));
        if(min.isPresent()){
            Node tmp = min.get();
            writer.println(tmp.getA());

            List<Node> oldNodes = str.get(tmp.a);
            oldNodes.removeIf(el -> el.id == tmp.id);
            if (oldNodes.size() == 0){
                str.remove(tmp.a);
            }
            tmp.step();
            List<Node> listNode = str.get(tmp.a);
            if(Objects.nonNull(listNode)){
                listNode.add(tmp);
            }
            else
                str.put(tmp.a, new ArrayList<>(Collections.singletonList(tmp)));
        }
    }

    private static void deleteNode(List<Integer> ints, Map<Long, List<Node>> str, Map<Long, Node> ids) {
        Node node = ids.get(Long.valueOf(ints.get(1)));
        List<Node> nodes = str.get(node.a);
        nodes.removeIf(el -> el.id == node.id);
        ids.remove(node.id);
        if(nodes.isEmpty())
            str.remove(node.a);
    }

    private static void addNeNode(List<Integer> ints, Map<Long, List<Node>> str, Map<Long, Node> ids) {
        Node tmp = new Node(ints.get(1), ints.get(2), ints.get(3));

        List<Node> listNodes = str.get(tmp.a);

        if(Objects.nonNull(listNodes)){
            listNodes.add(tmp);
        }
        else
            str.put(tmp.a, new ArrayList<>(Collections.singletonList(tmp)));

        ids.put(tmp.id, tmp);
    }
}

class Node {
    long a;
    long d;
    long id;

    public Node(long a, long d, long id) {
        this.a = a;
        this.d = d;
        this.id = id;
    }

    public void step(){
        this.a += d;
    }

    public long getA() {
        return a;
    }
    public long getId() {
        return id;
    }
}
