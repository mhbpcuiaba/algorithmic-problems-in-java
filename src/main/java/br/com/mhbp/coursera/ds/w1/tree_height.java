package br.com.mhbp.coursera.ds.w1;

import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	class Node {
    	int element;
    	int height;
    	List<Node> children = new ArrayList<>();
	}
	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeightOriginal() {
                        // Replace this code with a faster implementation
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}

		int computeHeight() {
                        // Replace this code with a faster implementation

			Node[] nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node();
			}

			int root = -1;
			for (int i = 0; i < n; i++) {
				if (parent[i] == -1) {
					root = i;
				} else {
					nodes[parent[i]].children.add(nodes[i]);
				}
			}

			LinkedList<Node> queue = new LinkedList<>();
			nodes[root].height = 1;
			queue.offer(nodes[root]);

			while (!queue.isEmpty()) {
				Node node = queue.poll();
				for (int i = 0; i < node.children.size() ; i++) {
					Node n = node.children.get(i);
					n.height = node.height + 1;
					queue.offer(node.children.get(i));
				}
			}

			int maxHeight = 0;
			for (int i = 0; i < n; i++) {
				if (maxHeight < nodes[i].height) {
					maxHeight = nodes[i].height;
				}
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
