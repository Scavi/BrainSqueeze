package com.scavi.brainsqueeze.codefight.i.hsq;

import java.util.Deque;
import java.util.LinkedList;

public class SimplyfyPath {
    String simplifyPath(String path) {
        String[] pathTokens = path.split("/");
        Deque<String> pathCache = new LinkedList<>();
        for (String token : pathTokens) {
            if (!token.isEmpty() && !token.equals(".")) {
                if (token.equals("..")) {
                    if (pathCache.size() > 0) {
                        pathCache.removeLast();
                    }
                } else {
                    pathCache.addLast(token);
                }
            }
        }
        StringBuilder newPathBuilder = new StringBuilder();
        newPathBuilder.append("/");
        for (String newPath : pathCache) {
            newPathBuilder.append(newPath).append("/");
        }
        return newPathBuilder.length() > 1 ? newPathBuilder.substring(0, newPathBuilder.length() - 1) :
                newPathBuilder.toString();
    }
}