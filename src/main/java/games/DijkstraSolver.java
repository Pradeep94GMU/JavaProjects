package games;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Cell implements Comparable<Cell> {
    int x, y;
    int dist;
    Cell prev;

    Cell(int x, int y, int dist, Cell prev) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.prev = prev;
    }

    public int compareTo(Cell other) {
        return this.dist - other.dist;
    }
}

public class DijkstraSolver {
    public static List<Cell> solveMaze(int[][] maze) {
        PriorityQueue<Cell> queue = new PriorityQueue<>();
        queue.offer(new Cell(1, 1, 0, null)); // Start cell with distance 0

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.x == maze.length - 2 && current.y == maze[0].length - 2) { // Check if exit is reached
                List<Cell> path = new ArrayList<>();
                while (current.prev != null) {
                    path.add(current);
                    current = current.prev;
                }
                Collections.reverse(path);
                return path;
            }

            // Check all four directions
            for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int x = current.x + dir[0];
                int y = current.y + dir[1];

                // Check bounds and if it's a wall
                if (x > 0 && y > 0 && x < maze.length - 1 && y < maze[0].length - 1 && maze[x][y] == 0) {
                    queue.offer(new Cell(x, y, current.dist + 1, current));
                    maze[x][y] = -1; // Mark as visited
                }
            }
        }
        return Collections.emptyList(); // Return empty path if no path is found
    }
}

