package zxvt;

import static java.lang.Math.abs;
import static java.lang.Math.floor;
import zxvt.IsometricGridNumbering;
import VASSAL.build.module.map.boardPicker.board.GeometricGrid;
import VASSAL.build.module.map.boardPicker.board.mapgrid.GridNumbering;
import java.awt.Point;
import java.awt.geom.Area;

public class IsometricGrid implements GeometricGrid {

    private GridNumbering mNumbering;

    @Override
    public Area getGridShape(final Point center, final int range) {
        return new Area();
    }

    @Override
    public Point snapTo(java.awt.Point p) {
        return p;
    }

    @Override
    public boolean isLocationRestricted(Point p) {
        return false;
    }

    @Override
    public String locationName(Point p) {
        return mNumbering != null ? mNumbering.locationName(p) : null;
    }

    @Override
    public String localizedLocationName(Point p) {
        return "";
    }

    @Override
    public Point getLocation(final String location) throws BadCoords {
        if (mNumbering == null) {
            throw new BadCoords("Can't get location if numbering isn't sepcified");
        }
        return mNumbering.getLocation(location);
    }

    @Override
    public int range(Point p1, Point p2) {
      return abs((int) floor((p2.x - p1.x) / 0.5))
           + abs((int) floor((p2.y - p1.y) / 0.5));
    }

    @Override
    public boolean isVisible() {
        return mNumbering != null ? mNumbering.isVisible() : null;
    }

    @Override
    public void draw(java.awt.Graphics g, java.awt.Rectangle bounds, java.awt.Rectangle visibleRect, double scale, boolean reversed) {
        if (mNumbering != null) {
            mNumbering.draw(g, bounds, visibleRect, scale, reversed);
        }
    }

    @Override
    public GridNumbering getGridNumbering() {
        return mNumbering;
    }

}
