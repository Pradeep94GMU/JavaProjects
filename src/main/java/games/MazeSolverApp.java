package games;

import java.util.List;

public class MazeSolverApp {
        public static void main(String[] args) {
            int[][] maze = MazeGenerator.generateMaze();
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();
            }
            List<Cell> path = DijkstraSolver.solveMaze(maze);

            // Print the path
            for (Cell cell : path) {
                System.out.println("(" + cell.x + ", " + cell.y + ")");
                maze[cell.x][cell.y] = 2; // Mark the path in the maze
            }

            // Print the maze with the path marked
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

