package dungeon.crawler.core;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Waylon
 * Date: 1/25/12
 * Time: 6:36 PM
 * To change this template use File | Settings | File Templates.
 */
/*
Terrain types:
9 is stair room
0 is wa
 */
public class LevelGenerator {
    public void generateLevel(int levelNumber, int yLastStairs, int xLastStairs){
        Random generator = new Random();
        byte terrain;
        int stairs = yLastStairs * xLastStairs;
        int numberOfSquares = generator.nextInt(190) + 10;
        //create array to store world
        byte[] worldLevelOne = new byte[400];
        for (int increment = 0; increment < 400; increment ++){
            worldLevelOne[increment] = 0;
        }
        worldLevelOne[stairs] = 9;
        for (int increment = 0; increment <= numberOfSquares; increment ++){

        }
        try {
            writeWorldToFile(worldLevelOne, levelNumber);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public void writeWorldToFile(byte[] worldTemp, int timer) throws IOException {
        File levelDirectory = new File("level" + timer);
        levelDirectory.mkdir();
        String level = "level" + timer + "/LevelOne";
        File levelOne = new File(level);
        PrintStream worldOut = new PrintStream(levelOne);
        for (int increment = 0; increment < 400; increment++) {
            worldOut.println(worldTemp[increment]);
        }
    }
    public byte terrainGen(int x) {
        //change int to byte and add probability modifier stuff
        byte terrainType = 0;
        if (x == 9) terrainType = 3;
        if (x == 8) terrainType = 2;
        if (x == 7) terrainType = 1;
        if (x <= 6) terrainType = 0;
        return terrainType;
    }
}

