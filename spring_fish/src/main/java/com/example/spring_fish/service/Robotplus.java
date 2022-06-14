package com.example.spring_fish.service;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;

@Component
public class Robotplus extends Robot {
    @Override
    public synchronized void mouseMove(int x, int y) {
        super.mouseMove(x, y);
    }

    @Override
    public synchronized void mousePress(int buttons) {
        super.mousePress(buttons);
    }

    @Override
    public synchronized void mouseRelease(int buttons) {
        super.mouseRelease(buttons);
    }

    @Override
    public synchronized void mouseWheel(int wheelAmt) {
        super.mouseWheel(wheelAmt);
    }

    @Override
    public synchronized void keyPress(int keycode) {
        super.keyPress(keycode);
    }

    @Override
    public synchronized void keyRelease(int keycode) {
        super.keyRelease(keycode);
    }

    @Override
    public synchronized Color getPixelColor(int x, int y) {
        return super.getPixelColor(x, y);
    }

    @Override
    public synchronized BufferedImage createScreenCapture(Rectangle screenRect) {
        return super.createScreenCapture(screenRect);
    }

    @Override
    public synchronized boolean isAutoWaitForIdle() {
        return super.isAutoWaitForIdle();
    }

    @Override
    public synchronized void setAutoWaitForIdle(boolean isOn) {
        super.setAutoWaitForIdle(isOn);
    }

    @Override
    public synchronized int getAutoDelay() {
        return super.getAutoDelay();
    }

    @Override
    public synchronized void setAutoDelay(int ms) {
        super.setAutoDelay(ms);
    }

    @Override
    public synchronized void delay(int ms) {
        super.delay(ms);
    }

    @Override
    public synchronized void waitForIdle() {
        super.waitForIdle();
    }

    @Override
    public synchronized String toString() {
        return super.toString();
    }

    public Robotplus() throws AWTException {
    }

    public Robotplus(GraphicsDevice screen) throws AWTException {
        super(screen);
    }


}
