package com.donvi.common;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by Donvi Yang on 2020/4/7.
 */
public class GraphTraverse {

    // Breadth First Search
    public static void BFS(Map<Character, List> map, char startNode){
        // using Queue
        // 将要遍历的开始节点队列
        Queue<Character> queue = new LinkedList<>();
        // 当前节点已遍历的节点集合
        Set<Character> set = new HashSet<>();
        queue.offer(startNode);
        set.add(startNode);
        // queue非空，需继续遍历
        while (!queue.isEmpty()){
            char visitNode = ((LinkedList<Character>) queue).pop();
            System.out.print(visitNode);
            // 邻接点
            List<Character> adjacentNode = map.get(visitNode);
            if (!CollectionUtils.isEmpty(adjacentNode)){
                adjacentNode.forEach(node -> {
                    if (!set.contains(node)){
                        ((LinkedList<Character>) queue).offer(node);
                        set.add(node);
                    }
                });
            }
        }
    }

    // Depth First Search
    public static void DFS(Map<Character, List> map, char startNode){
        // using Stack
        // 将要遍历的开始节点
        Stack<Character> stack = new Stack<>();
        // 已遍历的节点集合
        Set<Character> set = new HashSet<>();
        stack.push(startNode);
        set.add(startNode);
        // stack非空，需继续遍历
        while(!stack.isEmpty()){
            char visitNode = stack.pop();
            System.out.print(visitNode);
            List<Character> list = map.get(visitNode);
            if (!CollectionUtils.isEmpty(list)){
                list.forEach(node -> {
                    if(!set.contains(node)){
                        stack.push(node);
                        set.add(node);
                    }
                });
            }
        }


    }

}
