import baekjoon.BackJoon;
import baekjoon.array.BOJ10808;
import baekjoon.function.*;
import baekjoon.stack.*;
import barkingdog.chap03.*;
import barkingdog.chap07.SolveBOJ;
import barkingdog.chap09.*;
import barkingdog.chap09.boj.BOJ1012;
import barkingdog.chap09.boj.BOJ2583;
import barkingdog.chap09.boj.BOJ7569;
import barkingdog.chap09.boj.BOJ9466;
import caseStudy.MyStart;
import inflearn.section2.Recursion7;
import springStudy.chap04.finalKeyword.Driver;
import springStudy.chap04.staticBlock.Driver01;
import springStudy.chap06.decorator.example.order.Customer;
import springStudy.chap06.singleton.example.Manage;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        MyStart start = new BOJ2583();
        start.start();

//        String []tt = {"cook","lock","cool"};
//        List<String> t = commonChars(tt);
//
//        for (String e:t)
//            System.out.println(e);

    }   // main method

    // slack 문제 다시 풀어보기
    public static List<String> commonChars(String[] A) {

        List<String> result = new ArrayList<>();

        for(int i=0; i < A.length; i++) {

            String tmp = A[i];
            if (i == 0){
                for(char e:tmp.toCharArray())
                    result.add(String.valueOf(e));
            } else {

                for (int j=0; j < result.size(); j++) {
                    if ( !tmp.contains(result.get(j)) )
                        result.remove(result.get(j));
                    else {
                        int in = tmp.indexOf(result.get(j));
                        tmp = tmp.substring(0, in) + tmp.substring(in+1);
                    }
                }

            }


        }

        return result;

    }

    static class ContentsInfo {

        double score;
        int x;
        int y;
        String contents;

        public ContentsInfo(int x, int y, String c, double score) {
            this.x = x;
            this.y = y;
            this.score = score;
            this.contents = c;
        }

    }

    // 1번 문
    private void num1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int people = Integer.parseInt(input);

        int chk = 0;

        int start_time = 0;
        int end_time = 2400;

        for (int i = 0; i < people * 2; i = i + 2) {

            String time = br.readLine();
            time = time.replaceAll(":", "");

            String[] times = time.split(" ");

            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[2]);

            if (start_time > end || end_time < start) {
                chk = -1;
            } else {

                if (start_time <= start && end_time > start) {
                    start_time = start;
                }

                if (end_time > end && start_time < end) {
                    end_time = end;
                }

            }

        }

        if (chk < 0) System.out.println(-1);
        else {
            System.out.printf("%02d:%02d ~ %02d:%02d", start_time / 100, start_time % 100, end_time / 100, end_time % 100);
        }
    }

    // 3번 문제
    private void number3() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int total = 0;
        int size_1 = 0;

        int n = Integer.parseInt(input);
        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {

            String line = br.readLine();

            for (int j = 0; j < n; j++) {

                int number = Integer.parseInt(line.substring(j, j + 1));

                if (number == 1) size_1++;
                array[i][j] = number;

            }

        }

        List<Integer> result = new ArrayList<>();
        result.add(size_1);

        for (int k = 1; k < n; k++) {

            int tmp = 0;
            for (int i = 0; i < n - k; i++) {

                for (int j = 0; j < n - k; j++) {

                    boolean chk = false;

                    for (int m = 0; m <= k; m++) {

                        for (int b = 0; b <= k; b++) {

                            if (array[i + m][j + b] == 1) {
//                                System.out.printf("check : (%d,%d) = %d\n", (i+m), (j+b), array[i+m][j+b]);
                                chk = true;
                            } else {
                                chk = false;
                                break;
                            }

                        }

                        if (chk == false) break;

                    }

                    if (chk) tmp++;

                }

            }

            result.add(tmp);

        }   // k 반복문

        for (Integer e : result)
            total += e;

        System.out.printf("total: %d\n", total);
        for (int i = 0; i < n; i++) {
//            if (result.get(i) == 0) break;
            System.out.printf("size[%d]: %d\n", (i + 1), result.get(i));
        }

    }

    // 4번 문제
    private void number4() throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] contentList = {"A", "B", "C", "D", "E"};

        Map<String, Double> score = new HashMap<>();

        String scoreInput = br.readLine();
        String tmpS[] = scoreInput.split(" ");

        score.put("A", Double.parseDouble(tmpS[0]));
        score.put("B", Double.parseDouble(tmpS[1]));
        score.put("C", Double.parseDouble(tmpS[2]));
        score.put("D", Double.parseDouble(tmpS[3]));
        score.put("E", Double.parseDouble(tmpS[4]));

        String input = br.readLine();

        int n = Integer.parseInt(input.substring(0, 1));
        int m = Integer.parseInt(input.substring(2));

        String[][] showed = new String[n][m];
        String[][] contents = new String[n][m];

        // 콘텐츠 소비 여부
        for (int i = 0; i < n; i++) {
            String showed_txt = br.readLine();
            for (int j = 0; j < m; j++) {
                showed[i][j] = showed_txt.substring(j, j + 1);
            }
        }

        // 콘텐츠별 장르
        for (int i = 0; i < n; i++) {
            String content_txt = br.readLine();
            for (int j = 0; j < m; j++) {
                contents[i][j] = content_txt.substring(j, j + 1);
            }
        }

        List<ContentsInfo> contents_Y = new ArrayList<>();
        List<ContentsInfo> contents_O = new ArrayList<>();
        List<ContentsInfo> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                String content = contents[i][j];
                if (showed[i][j].equals("Y")) {
                    contents_Y.add(new ContentsInfo(i, j, content, score.get(content)));
                } else if (showed[i][j].equals("O")) {
                    contents_O.add(new ContentsInfo(i, j, content, score.get(content)));
                }

            }
        }

        // 우선순위 1번 정렬
        for (int i = contents_Y.size() - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (contents_Y.get(j).score == contents_Y.get(j + 1).score) {

                    if (contents_Y.get(j).y > contents_Y.get(j + 1).y) {

                        ContentsInfo tmp = contents_Y.get(j);
                        contents_Y.set(j, contents_Y.get(j + 1));
                        contents_Y.set(j + 1, tmp);

                    } else if (contents_Y.get(j).y == contents_Y.get(j + 1).y) {

                        if (contents_Y.get(j).x > contents_Y.get(j + 1).x) {

                            ContentsInfo tmp = contents_Y.get(j);
                            contents_Y.set(j, contents_Y.get(j + 1));
                            contents_Y.set(j + 1, tmp);

                        }

                    }

                } else if (contents_Y.get(j).score < contents_Y.get(j + 1).score) {

                    ContentsInfo tmp = contents_Y.get(j);
                    contents_Y.set(j, contents_Y.get(j + 1));
                    contents_Y.set(j + 1, tmp);

                }

            }

        }

        for (int i = 0; i < contents_Y.size(); i++) {
            result.add(contents_Y.get(i));
        }

        // 우선순위 2번 정렬
        for (int i = contents_O.size() - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (contents_O.get(j).score == contents_O.get(j + 1).score) {

                    if (contents_O.get(j).y > contents_O.get(j + 1).y) {

                        ContentsInfo tmp = contents_O.get(j);
                        contents_O.set(j, contents_O.get(j + 1));
                        contents_O.set(j + 1, tmp);

                    } else if (contents_O.get(j).y == contents_O.get(j + 1).y) {

                        if (contents_O.get(j).x > contents_O.get(j + 1).x) {

                            ContentsInfo tmp = contents_O.get(j);
                            contents_O.set(j, contents_O.get(j + 1));
                            contents_O.set(j + 1, tmp);

                        }

                    }

                } else if (contents_O.get(j).score < contents_O.get(j + 1).score) {

                    ContentsInfo tmp = contents_O.get(j);
                    contents_O.set(j, contents_O.get(j + 1));
                    contents_O.set(j + 1, tmp);

                }

            }
        }

        for (int i = 0; i < contents_O.size(); i++) {
            result.add(contents_O.get(i));
        }

        for (int i = 0; i < result.size(); i++) {

            System.out.printf("%s %.1f %d %d\n", result.get(i).contents,
                    result.get(i).score,
                    result.get(i).x,
                    result.get(i).y);

        }

    }

}

