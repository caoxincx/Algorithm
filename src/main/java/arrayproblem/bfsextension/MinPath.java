package arrayproblem.bfsextension;

import java.util.*;

/**
 * 需求编号:
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/10/19
 * 功能描述:广度优先搜索+拐弯值最少的两个点元素 最少转弯问题
 * 修改日期:2019/10/19
 * 修改描述:
 */
public class MinPath {
    // 声明一个二维数组
    // private static int[][] arr = {{0, 1, 0, 0, 0}, {0, 2, 0, 0, 0}, {0, 0, 0, 4, 5}, {0, 0, 0, 0, 0}, {0, 0, 3, 1,0}};
    private static int[][] arr = {
            {0,16,9,28,11,27,26,10,18,25,0,21,24,9,30,18,29,4,-11},
            {18,33,0,5,31,9,0,21,25,20,0,0,12,5,0,15,0,0,0},
            {7,0,0,0,11,0,0,0,29,0,0,0,8,0,0,0,0,0,0},
            {0,0,0,21,0,0,0,32,0,28,0,-9,20,9,0,0,0,27,0},
            {0,26,10,4,0,0,0,30,0,2,32,11,0,0,17,31,0,2,21},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,26},
            {0,0,-11,0,0,3,0,16,0,25,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,5,23,0,26,0,0,0,22,0,20,0,29,20,12,0},
            {0,0,0,0,-12,0,0,0,25,0,0,0,-14,0,0,0,7,0,0},
            {33,29,0,-14,14,30,0,-9,18,15,0,22,2,30,0,7,19,32,0},
            {23,7,10,14,6,3,-12,12,11,24,12,2,5,19,10,8,32,6,17}
    };

    // Position
    private static Position startPosition;
    // 方向
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static Position findConnectSpot() {
        if (arr == null || arr.length == 0 || startPosition.getLp() >= arr.length || startPosition.getRp() >= arr[0].length || arr[startPosition.getLp()][startPosition.getRp()] == 0) {
            return null;
        }
        // 记录走过的格子，防止重复走
        int[][] map = new int[arr.length][arr[0].length];
        // 初始化
        Deque<Position> q = new LinkedList<>();
        q.add(startPosition);
        map[startPosition.getLp()][startPosition.getRp()] = 1;
        Position position = null;
        while (!q.isEmpty()) {
            // 头元素拿出来
            position = q.poll();
            if ((position.getLp() == arr.length && position.getRp() == arr[0].length)) {
                return null;
            }
            for (int i = 0; i < 4; i++) {// 先往某个方向不断查找，如果找不到则换一个方向
                int toR = position.getLp() + dx[i];
                int toC = position.getRp() + dy[i];
                while (toR >= 0 && toR < arr.length &&  // 下一个x不超出格子
                        toC >= 0 && toC < arr[0].length && // 下一个y不超出格子
                        (arr[toR][toC] == 0 || arr[toR][toC] == arr[startPosition.getLp()][startPosition.getRp()]) && // 命中需要找的或者为空
                        map[toR][toC] == 0) { // 没走过的格子
                    // 添加下一个可能是拐点的元素
                    q.add(new Position(toR, toC, position.getTurnNumber() + 1));
                    map[toR][toC] = map[position.getLp()][position.getRp()] + 1;
                    if (arr[toR][toC] == arr[startPosition.getLp()][startPosition.getRp()]) {
                        // 如果当前起点已经命中则回去为拐点元素的turnNumber，如果是起点一定能
                        if (position.getTurnNumber() <= 2) {
                            // 将找到的值设置为空并且打印
                            arr[startPosition.getLp()][startPosition.getRp()] = 0;
                            arr[toR][toC] = 0;
                            printPostion(startPosition, q.getLast());
                        }
                        return new Position(toR, toC, 0);
                    }
                    toR = toR + dx[i];
                    toC = toC + dy[i];
                }
            }
        }
        return null;
    }

    public static boolean isEmpty(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void printPostion(Position start, Position end) {
        System.out.println("[" + start.getLp() + "," + start.getRp() + "]->" + "[" + end.getLp() + "," + end.getRp() + "]");
    }

    public static void main(String[] args) {
        //while (!isEmpty(arr)) {
        //    for (int i = 0; i < arr.length; i++) {
        //        for (int j = 0; j < arr[0].length; j++) {
        //            if (arr[i][j] == 0) {
        //                continue;
        //            }
                    startPosition = new Position(7, 4, 0);
                    Position connectSpot = findConnectSpot();
            //    }
            //}
        //}
    }
}