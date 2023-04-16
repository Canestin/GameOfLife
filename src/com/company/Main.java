package com.company;
import GOL.Coord;
import GOL.GameOfLife;

public class Main {

    public static Coord[] InitialAliveCells(){
        Coord[] coords = new Coord[] {
                new Coord(0,0)
        };

        return coords;
    }

    public static void main(String[] args) {
        Coord[] initialCells = InitialAliveCells();
        GameOfLife gol = new GameOfLife(0, 0, initialCells);
        gol.ComputeNthGeneration(10);
    }
}
