package arrayproblem.minpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 需求编号:
 * 问题编号:100306AD0 000D1C70
 * 开发人员: caoxin
 * 创建日期:2019/10/19
 * 功能描述:找出数组中某个位置开始路径最小的两个点
 * 修改日期:2019/10/19
 * 修改描述:
 */
public class MinPath {
    // 声明一个二维数组
    private static int[][] arr = {{0, 1, 0,3,0}, {1, 0, 2,4,3}, {2, 0, 0,4,0},{0, 5, 6,5,6},{0, 3, 1,3,1}};
    // 当前所在位置
    private static int[] currentPosition = {};
    // 起始点List
    private static List<Position> startList = new ArrayList<>();
    // 结束点List
    private static List<Position> endList = new ArrayList<>();
    // 是否已经找到
    private static boolean flag = false;
    public static void findConnectSpot(int[][] arr, int[] currentPosition) {
        if (arr == null || arr.length == 0 || currentPosition[0] >= arr.length || currentPosition[1] >= arr[0].length ||arr[currentPosition[0]][currentPosition[1]] == 0) {
            return;
        }
        int[][] map = new int[arr.length][arr[0].length];
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();
        map[currentPosition[0]][currentPosition[1]] = 1;
        flag = true;
        rQ.add(currentPosition[0]);
        cQ.add(currentPosition[1]);
        Integer r = 0;
        Integer c = 0;
        while (!rQ.isEmpty() && flag) {
            r = rQ.poll();
            c = cQ.poll();
            if ((c == arr.length  && c == arr[0].length) || (r == 0 && c == 0)) {
                return;
            }
            walkTo(map[r][c], r - 1, c, arr, map, rQ, cQ);
            walkTo(map[r][c], r + 1, c, arr, map, rQ, cQ);
            walkTo(map[r][c], r, c - 1, arr, map, rQ, cQ);
            walkTo(map[r][c], r, c + 1, arr, map, rQ, cQ);
        }
    }

    private static void walkTo(int pre, int toR, int toC, int[][] arr, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
        if (toR < 0 || toR == arr.length || toC < 0 || toC == arr.length || (arr[toR][toC] != arr[currentPosition[0]][currentPosition[1]] && arr[toR][toC] != 0) || map[toR][toC] != 0 || flag == false) {
            return;
        }
        if (arr[currentPosition[0]][currentPosition[1]] == arr[toR][toC]) {
            startList.add(new Position(currentPosition[0], currentPosition[1]));
            endList.add(new Position(toR, toC));
            arr[currentPosition[0]][currentPosition[1]] = 0;
            arr[toR][toC] = 0;
            if (currentPosition[1] < arr[0].length -1){
                currentPosition[1]++;
            }
            flag = false;
        } else {
            map[toR][toC] = pre + 1;
            rQ.add(toR);
            cQ.add(toC);
        }

    }

    public static int[] findStartPosition(int[][] arr) {
        int[] startPostion = new int[]{0, 0};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] != 0) {
                    startPostion[0] = i;
                    startPostion[1] = j;
                    return startPostion;
                }
            }
        }
        return startPostion;
    }


    public static void printPostion(Position start, Position end) {
        System.out.println("[" + start.getLp() + "," + start.getRp() + "]->" + "[" + end.getLp() + "," + end.getRp() + "]");
    }
    public static void main(String[] args) {
        currentPosition = findStartPosition(arr);
        while (true) {
            if (currentPosition[0] >= arr.length) {
                // 打印
                for (int i = 0; i < startList.size(); i++) {
                    printPostion(startList.get(i), endList.get(i));
                }
                return;
            } else if (currentPosition[1] >= arr[0].length) {
                currentPosition[0]++;
                currentPosition[1] = 0;
                findConnectSpot(arr, currentPosition);
            } else if (arr[currentPosition[0]][currentPosition[1]] == 0) {
                currentPosition[1]++;
            } else {
                findConnectSpot(arr, currentPosition);
            }
        }
    }
}
