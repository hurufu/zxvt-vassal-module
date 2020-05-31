package zxvt;

import zxvt.IsometricGrid;
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
                mAttrs[i].setValue(value);
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

    private class Attribute<Type> {
        private final Class<Type> type;
        public Type value;
        public final String key;
        public final String description;

        public Attribute(final Class<Type> t, final String k, final Type v, final String d) {
            this.type = t;
            this.key = k;
            this.value = v;
            this.description = d;
        }

        public void setValue(final Object v) {
            value = type.cast(v);
        }
    }

}
