package com.company;

import com.company.gameObjects.*;
import com.company.input.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable {
    GameWindow gameWindow;
    private final double UPDATES_PER_SECOND = 60.0;
    private String playerName;
    public boolean gameActive = false;
    private int updateCounter = 0;
    private int frameRate;
    Keyboard keyboard = new Keyboard();
    Mouse mouse = new Mouse();
    GameObjectHandler handler = new GameObjectHandler();
    Score score;
    Thread thread;

    public Game() {
        this.playerName = this.getNameFromPlayer();
        gameWindow = new GameWindow(this);
        score = new Score(this.playerName);
        addListeners();
        createPlayer(new Vector2D(GameWindow.SCREEN_WIDTH / 2d, GameWindow.SCREEN_HEIGHT / 2d));
        createAsteroids(3);
    }

    private String getNameFromPlayer() {
        String name = "";
        JFrame frame = new JFrame("SpaceShooter");
        while (name == null || name.equals("")) {
            name = JOptionPane.showInputDialog(frame,
                    "You control the spaceship with the \"WASD\" keys and shoot with the spacebar\n" +
                            "Please write your name\n" +
                            "Press \"OK\" to start the game");
        }
        return name;
    }

    private void addListeners() {
        this.addKeyListener(keyboard);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
    }

    private void createPlayer(Vector2D playerPosition) {
        handler.add(new Player(playerPosition, this.handler));
    }

    private void createAsteroids(int numberOfAsteroids) {
        Vector2D playerPosition = handler.getPlayer().position;
        int size = 200;
        for (int i = 0; i < numberOfAsteroids; i++) {
            double randomX;
            double randomY;
            do {
                randomX = Math.random() * (GameWindow.SCREEN_WIDTH - size * 2) + size;
                randomY = Math.random() * (GameWindow.SCREEN_HEIGHT - size * 2) + size;
            } while (playerPosition.getDistanceBetween(randomX, randomY) < size / 2d + 25d);
            handler.add(new Asteroid(randomX, randomY, size, handler, score));
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        gameActive = true;
    }

    public synchronized void stop() {
        gameWindow.dispatchEvent(new WindowEvent(gameWindow, WindowEvent.WINDOW_CLOSING));
        try {
            thread.join();
            gameActive = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void update() {
        gameWindow.setTitle(String.format("SpaceShooter| Player: %s | frames per second: %d", this.playerName, frameRate));
        if (handler.hasPlayer()) {
            handler.update();
            updateCounter++;
            if (updateCounter % (UPDATES_PER_SECOND * 5) == 0) {
                createAsteroids(2);
            }
        } else {
            this.gameActive = false;
        }
    }

    private void showGameOverWindow() {
        HighScore highScore = new HighScore();
        highScore.addScore(this.score);
    }

    private void draw() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        Graphics graphics;
        try {
            graphics = bufferStrategy.getDrawGraphics();
            enableAntialiasing((Graphics2D) graphics);
            drawBackground(Color.black, graphics);
            drawScoreOnScreen(GameWindow.SCREEN_WIDTH / 2, 32, 32, graphics);
            handler.display(graphics);
            graphics.dispose();
            bufferStrategy.show();
        } catch (IllegalStateException e) {
            this.gameActive = false;
        }
    }

    private void enableAntialiasing(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private void drawScoreOnScreen(int x, int y, int size, Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Monospaced", Font.BOLD, size));
        String text = String.format("SCORE: %S", score.getScore());
        int textWidth = graphics.getFontMetrics().stringWidth(text);
        graphics.drawString(text, x - textWidth / 2, y);
    }

    private void drawBackground(Color color, Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void addScoreToHighScoreFile() {
        HighScore highScore = new HighScore();
        highScore.addScore(this.score);
        highScore.writeFile();
    }

    private void printHighScoresToConsole() {
        HighScore highScore = new HighScore();
        System.out.println("HighScores:");
        ArrayList<Score> scores = highScore.getScores();
        for (int i = scores.size() - 1; i >= 0; i--) {
            Score score = scores.get(i);
            System.out.printf("%d.%s\t%d\n", scores.size() - i, score.getName(), score.getScore());
        }
    }

    private void showGameOverDialog() {
        JFrame frame = new JFrame("SpaceShooter");
        JOptionPane.showMessageDialog(frame, String.format("GAME OVER\nYour score was: %d", this.score.getScore()));
    }

    public void run() {
        this.createBufferStrategy(3);
        long lastTime = System.nanoTime();
        double nanoSecondsPerFrame = 1000000000 / UPDATES_PER_SECOND;
        double delta = 0;
        while (gameActive) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nanoSecondsPerFrame;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            if (gameActive) {
                draw();
            }
            frameRate = (int) (1000000000 / (System.nanoTime() - now));
        }
        this.addScoreToHighScoreFile();
        this.printHighScoresToConsole();
        showGameOverDialog();
        this.stop();
    }
}
