package sh.now.afk.processing;

import org.apache.commons.lang3.RandomUtils;
import processing.core.PApplet;

public class Hello extends PApplet {
    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"a", "b", "c"}, new Hello());
    }

    char[] s;
    float fontSize = 50;

    @Override
    public void settings() {
        size(640, 480);
        smooth(10);
    }

    @Override
    public void setup() {
        background(255);
        noStroke();
        frameRate(1);
        textSize(fontSize);
        String hello_world = "HELLO WORLD";
        s = hello_world.toCharArray();
    }

    @Override
    public void draw() {
        background(255);
        translate(width / 7f, height / 7f);
        for (int i = 0; i < 8; i++) {
            float y = fontSize * i;
            for (int j = 0; j < s.length; j++) {
                float x = fontSize * j;
                float r = RandomUtils.nextFloat(0, 255);
                float g = RandomUtils.nextFloat(0, 255);
                float b = RandomUtils.nextFloat(0, 255);
                fill(r, g, b);
                text(s[j], x, y);
            }
        }
    }
}
