package zxvt;

import zxvt.IsometricGridNumbering;

import VASSAL.build.module.map.boardPicker.board.GeometricGrid;
import VASSAL.build.module.map.boardPicker.board.mapgrid.GridNumbering;
import VASSAL.build.module.documentation.HelpFile;
import VASSAL.build.AbstractConfigurable;
import VASSAL.build.Buildable;

import java.awt.Point;
import java.awt.geom.Area;

public class IsometricGrid extends AbstractConfigurable implements GeometricGrid {

    @Override
    public Class<Integer>[] getAttributeTypes() {
        return null;
    }

    @Override
    public String[] getAttributeDescriptions() {
        return null;
    }

    @Override
    public String getAttributeValueString(String key) {
        return "";
    }

    @Override
    public void setAttribute(String key, Object value) {
    }

    @Override
    public String[] getAttributeNames() {
        return null;
    }

    @Override
    public void addTo(Buildable parent) {
    }

    @Override
    public Class[] getAllowableConfigureComponents() {
        return null;
    }

    @Override
    public HelpFile getHelpFile() {
        return new HelpFile();
    }

    @Override
    public void removeFrom(Buildable parent) {
    }

    @Override
    public Area getGridShape(Point center, int range) {
        return new Area();
    }

    @Override
    public Point snapTo(java.awt.Point p) {
        return new Point();
    }

    @Override
    public boolean isLocationRestricted(Point p) {
        return false;
    }

    @Override
    public String locationName(Point p) {
        return "";
    }

    @Override
    public String localizedLocationName(Point p) {
        return "";
    }

    @Override
    public Point getLocation(String location) throws BadCoords {
        return new Point();
    }

    @Override
    public int range(Point p1, Point p2) {
        return 0;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public void draw(java.awt.Graphics g, java.awt.Rectangle bounds, java.awt.Rectangle visibleRect, double scale, boolean reversed) {
    }

    @Override
    public GridNumbering getGridNumbering() {
        return new IsometricGridNumbering();
    }

}
