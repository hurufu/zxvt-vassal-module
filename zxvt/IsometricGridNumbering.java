package zxvt;

import VASSAL.build.module.map.boardPicker.board.mapgrid.RegularGridNumbering;
import VASSAL.build.Buildable;

import java.awt.Point;
import javax.swing.JComponent;

public class IsometricGridNumbering extends RegularGridNumbering {

    public IsometricGridNumbering() {
    }

    @Override
    public Point getCenterPoint(int col, int row) {
        return new Point();
    }

    @Override
    protected JComponent getGridVisualizer() {
        return null;
    }

    @Override
    public int getRow(Point p) {
        return 0;
    }

    @Override
    public int getColumn(Point p) {
        return 0;
    }

    @Override
    public void addTo(Buildable parent) {
    }

    @Override
    public void removeFrom(Buildable parent) {
    }

    @Override
    public void draw(java.awt.Graphics g, java.awt.Rectangle bounds, java.awt.Rectangle visibleRect, double scale, boolean reversed) {
    }
}
