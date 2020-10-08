package com.company.pixel_lines;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = (x2 - x1 >= 0 ? 1 : -1);
        int dy = (y2 - y1 >= 0 ? 1 : -1);

        int lengthX = Math.abs(x2 - x1);//B
        int lengthY = Math.abs(y2 - y1);//A

        int length = Math.max(lengthX, lengthY);

        if (length == 0) {
            pd.drawPixel(x1, y1, Color.red);
        }

        if (lengthY < lengthX) {
            // Начальные значения
            int x = x1;
            int y = y1;
            int d = -lengthX;

            // Основной цикл
            length++;
            while (length > 0) {
                pd.drawPixel(x, y, Color.red);
                x += dx;
                d += 2 * lengthY;
                if (d > 0) {
                    d -= 2 * lengthX;
                    y += dy;
                }
                length--;
            }
        } else {
            // Начальные значения
            int x = x1;
            int y = y1;
            int d = -lengthY;

            // Основной цикл
            length++;
            while (length> 0) {
                pd.drawPixel(x, y, Color.red);
                y += dy;
                d += 2 * lengthX;
                if (d > 0) {
                    d -= 2 * lengthY;
                    x += dx;
                }
                length--;
            }
        }
    }
}
