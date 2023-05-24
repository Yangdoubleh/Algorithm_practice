package baekjoon.bronze.p13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Double> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int idx = 0; idx < n; idx++) {
            list.add(Double.parseDouble(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        Double main = Double.parseDouble(st.nextToken());
        Double sub = Double.parseDouble(st.nextToken());
        long result = 0;
        result += list.size();
        list = list.stream().filter(item -> item - main > 0).collect(Collectors.toList());
        for (Double item : list) {
            result += (long)Math.ceil((item - main) / sub);
        }
        System.out.println(result);
    }
}
