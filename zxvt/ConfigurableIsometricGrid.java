package zxvt;

import zxvt.IsometricGrid;
import zxvt.Attribute;
import VASSAL.build.AbstractConfigurable;
import VASSAL.build.Buildable;
import VASSAL.build.module.documentation.HelpFile;
import VASSAL.build.module.map.boardPicker.board.mapgrid.GridContainer;

public class ConfigurableIsometricGrid extends AbstractConfigurable {

    private Attribute<? extends Object>[] mAttrs = new Attribute<?>[] {
        new Attribute<Integer>(Integer.class, "hi", 12, "Test Hi"),
        new Attribute<Integer>(Integer.class, "oh", 34, "Test Oh")
    };
    private IsometricGrid mGrid = new IsometricGrid();

    @Override
    public Class<?>[] getAttributeTypes() {
        Class<?>[] types = new Class<?>[mAttrs.length];
        for (int i = 0; i < mAttrs.length; i++) {
            types[i] = mAttrs[i].value.getClass();
        }
        return types;
    }

    @Override
    public String[] getAttributeDescriptions() {
        String[] descs = new String[mAttrs.length];
        for (int i = 0; i < mAttrs.length; i++) {
            descs[i] = mAttrs[i].description;
        }
        return descs;
    }

    @Override
    public String getAttributeValueString(final String key) {
        for (int i = 0; i < mAttrs.length; i++) {
            if (mAttrs[i].key == key) {
                return mAttrs[i].value.toString();
            }
        }
        return null;
    }

    @Override
    public void setAttribute(final String key, final Object value) {
        for (int i = 0; i < mAttrs.length; i++) {
            if (mAttrs[i].key == key) {
                try {
                    mAttrs[i].setValue(value);
                } catch (final BadAttributeException e) {
                    // Just ignore
                    return;
                }
            }
        }
    }

    @Override
    public String[] getAttributeNames() {
        String[] names = new String[mAttrs.length];
        for (int i = 0; i < mAttrs.length; i++) {
            names[i] = mAttrs[i].key;
        }
        return names;
    }

    @Override
    public Class[] getAllowableConfigureComponents() {
        return new Class<?>[0];
    }

    @Override
    public HelpFile getHelpFile() {
        return new HelpFile();
    }

    @Override
    public void removeFrom(Buildable parent) {
        ((GridContainer)parent).removeGrid(mGrid);
    }

    @Override
    public void addTo(Buildable parent) {
        GridContainer container = (GridContainer) parent;
        container.setGrid(mGrid);
    }

}
