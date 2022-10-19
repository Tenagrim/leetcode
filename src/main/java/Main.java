public class Main {
    public static void main(String[] args) {
        solution(new int[]{10, 100, 9,2});
    }


    private static void solution(int[] arr) {
        int sum = 0;
        for(int t  :arr){
            if (t <= 999 && t >= 10)
                sum+=t;
        }
        System.out.println(sum);
    }
}
