package br.com.mhbp.stacks.and.queues;

import java.util.ArrayDeque;
import java.util.Iterator;

public class DirectoryPathNormalization {

    public static String shortestEquivalentPath(String path) {


        if (path == null || path.trim().isEmpty()) throw new IllegalArgumentException("path must be not empty");

        ArrayDeque<String> stack = new ArrayDeque<>();


        String[] tokens = path.split("/");

        if(path.startsWith("/")) {
            stack.addFirst("/");
        }

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("..")) {

                if (stack.isEmpty() || stack.peekFirst().equals("..")) { //  ../.. then we should add it
                    stack.addFirst(tokens[i]);
                } else {
                    if (stack.peekFirst().equals("/")) { // we should remove but it is the root already, so it is an error
                        throw new IllegalArgumentException("Path erro, trying to go up root" + path);
                    }
                    stack.removeFirst(); //we just remove prom the top
                }
            } else if (!tokens[i].equals(".") && !tokens[i].trim().isEmpty()) { //we should add it
                stack.addFirst(tokens[i]);
            }


        }

        StringBuilder r = new StringBuilder();
        if (!stack.isEmpty()) {
            Iterator<String> iter = stack.descendingIterator();

            String prev = iter.next();
            r.append(prev);
            while (iter.hasNext()) {

                if (!prev.equals("/"))
                    r.append("/");

                prev = iter.next();
                r.append(prev);
            }
        }

        return r.toString();
    }
}
