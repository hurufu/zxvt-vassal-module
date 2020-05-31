package zxvt;

import zxvt.BadAttributeException;

class Attribute<Type> {
    final Class<Type> type;
    Type value;
    final String key;
    final String description;

    Attribute(final Class<Type> t, final String k, final Type v, final String d) {
        this.type = t;
        this.key = k;
        this.value = v;
        this.description = d;
    }

    void setValue(final Object v) throws BadAttributeException {
        if (v instanceof String) {
            value = type.cast(Integer.parseInt((String)v));
        } else if (v instanceof Integer) {
            value = type.cast(v);
        } else {
            throw new BadAttributeException("Unexpected attribute type");
        }
    }
}
