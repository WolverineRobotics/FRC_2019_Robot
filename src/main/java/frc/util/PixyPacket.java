package frc.util;

public class PixyPacket {

    public int x, y, height, width, area;

    public PixyPacket() {}

    public PixyPacket(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.area = height * width;
    }

    public int getArea() {
        return area;
    }
}