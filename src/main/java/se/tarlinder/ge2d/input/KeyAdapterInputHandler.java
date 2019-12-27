package se.tarlinder.ge2d.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

/**
 * Input handler based on KeyAdapter.
 */
public class KeyAdapterInputHandler extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_Q) {
            Input.qPressed = true;
        } else if (e.getKeyCode() == VK_W) {
            Input.wPressed = true;
        } else if (e.getKeyCode() == VK_E) {
            Input.ePressed = true;
        } else if (e.getKeyCode() == VK_A) {
            Input.aPressed = true;
        } else if (e.getKeyCode() == VK_S) {
            Input.sPressed = true;
        } else if (e.getKeyCode() == VK_D) {
            Input.dPressed = true;
        } else if (e.getKeyCode() == VK_Z) {
            Input.zPressed = true;
        } else if (e.getKeyCode() == VK_X) {
            Input.xPressed = true;
        } else if (e.getKeyCode() == VK_C) {
            Input.cPressed = true;
        } else if (e.getKeyCode() == VK_RIGHT) {
            Input.rightArrowPressed = true;
        } else if (e.getKeyCode() == VK_LEFT) {
            Input.leftArrowPressed = true;
        } else if (e.getKeyCode() == VK_UP) {
            Input.upArrowPressed = true;
        } else if (e.getKeyCode() == VK_DOWN) {
            Input.downArrowPressed = true;
        } else if (e.getKeyCode() == VK_SHIFT) {
            Input.shiftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == VK_Q) {
            Input.qPressed = false;
        } else if (e.getKeyCode() == VK_W) {
            Input.wPressed = false;
        } else if (e.getKeyCode() == VK_E) {
            Input.ePressed = false;
        } else if (e.getKeyCode() == VK_A) {
            Input.aPressed = false;
        } else if (e.getKeyCode() == VK_S) {
            Input.sPressed = false;
        } else if (e.getKeyCode() == VK_D) {
            Input.dPressed = false;
        } else if (e.getKeyCode() == VK_Z) {
            Input.zPressed = false;
        } else if (e.getKeyCode() == VK_X) {
            Input.xPressed = false;
        } else if (e.getKeyCode() == VK_C) {
            Input.cPressed = false;
        } else if (e.getKeyCode() == VK_RIGHT) {
            Input.rightArrowPressed = false;
        } else if (e.getKeyCode() == VK_LEFT) {
            Input.leftArrowPressed = false;
        } else if (e.getKeyCode() == VK_UP) {
            Input.upArrowPressed = false;
        } else if (e.getKeyCode() == VK_DOWN) {
            Input.downArrowPressed = false;
        } else if (e.getKeyCode() == VK_SHIFT) {
            Input.shiftPressed = false;
        }
    }
}
