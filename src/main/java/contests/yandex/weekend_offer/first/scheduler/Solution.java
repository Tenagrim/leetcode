package contests.yandex.weekend_offer.first.scheduler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./input.txt"));
        PrintWriter writer = new PrintWriter("./output.txt", StandardCharsets.UTF_8);
        List<String> lines = reader.lines().collect(Collectors.toList());
        int taskCount = Integer.parseInt(((String) lines.get(0)).split(" ")[0]);
        int workerCount = Integer.parseInt(((String) lines.get(0)).split(" ")[1]);
        int queueCount = Integer.parseInt(((String) lines.get(0)).split(" ")[2]);
        lines.remove(0);

        int[] a = new int[10];
        LinkedList<Queue<Task>> qQueues = new LinkedList<>();
        List<Queue<Task>> queues = new ArrayList<>();
        for (int i = 0; i < queueCount; i++) {
            Queue<Task> q = new LinkedList<>(); //PriorityQueue<>((t1,t2)->t2.create - t1.create);
            queues.add(q);
            qQueues.add(q);
        }


        List<Task> allTasks = new ArrayList<>();
        Queue<Task> toComplete = parseTasks(lines, allTasks, queues);
        int[] workers = new int[workerCount];

        int tick = 1;
        int completed = 0;
        Queue<Task> prev = null;
        boolean skip;
        while (completed < taskCount && !qQueues.isEmpty()) {
            for (int w = 0; w < workerCount; w++) {
                if (workers[w] == 0) {
                    skip = false;
                    if (!qQueues.isEmpty()) {
                        Queue<Task> q;
                        do {
                            q = qQueues.poll();
                        } while (!qQueues.isEmpty() && q.isEmpty());
                        if (!q.isEmpty()) {
                            Task t = q.poll();
                            t.start = tick;
                            t.workerId = w + 1;
                            workers[w] = t.time -1;
                            completed++;
                            qQueues.offer(q);
                        }
                    }
                } else
                    workers[w] = workers[w] - 1;
            }
            tick++;
        }

        for (Task t : allTasks)
            writer.println(String.format("%d %d", t.workerId, t.start));
        reader.close();
        writer.close();
    }

    private static Queue<Task> parseTasks(List<String> input, List<Task> allTasks, List<Queue<Task>> queues) {
        Queue<Task> res = new LinkedList<>();
        for (String s : input) {
            String[] sp = s.split(" ");
            int s_ = Integer.parseInt(sp[0]);
            int q = Integer.parseInt(sp[1]);
            int t = Integer.parseInt(sp[2]);
            Task tmp = new Task(s_, q, t);
            allTasks.add(tmp);
            queues.get(q-1).add(tmp);
            res.offer(tmp);
        }
        return res;
    }

    private static void reverseQeue(Queue<Queue<Task>> queue){
        Stack<Queue<Task>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
    }
    private static class Task {
        int start;
        int create;
        int workerId;
        int queueId;
        int time;

        public Task(int t) {
            this.time = t;
        }

        public Task(int create, int queueId, int t) {
            this.create = create;
            this.queueId = queueId;
            this.time = t;
        }
    }
}
