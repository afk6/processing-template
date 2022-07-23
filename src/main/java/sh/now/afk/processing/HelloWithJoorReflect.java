package sh.now.afk.processing;

import org.apache.commons.lang3.RandomUtils;
import processing.core.PApplet;

import static org.joor.Reflect.on;

public class HelloWithJoorReflect extends PApplet {
    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"a", "b", "c"}, new HelloWithJoorReflect());
    }

    byte[] s;
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
        s = on((Object) hello_world).get("value");
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
                text((char) (s[j]), x, y);
            }
        }
    }
}
