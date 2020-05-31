package zxvt;

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

    void setValue(final Object v) {
        value = type.cast(v);
    }
}
