package dailyTest;

import com.donvi.common.GraphTraverse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Donvi Yang on 2020/4/7.
 */
public class GraphSearch {
    public static void main(String[] args) {
        //用map和list存储图数据
        Map<Character, List> map = new HashMap<>();
        map.put('A',Arrays.asList('B','C'));
        map.put('B',Arrays.asList('A','C','D'));
        map.put('C',Arrays.asList('A','B','D','E'));
        map.put('D',Arrays.asList('B','C','E','F'));
        map.put('E',Arrays.asList('C','D'));
        map.put('F',Arrays.asList('D'));
        GraphTraverse.DFS(map, 'A');
    }
}
