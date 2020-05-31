package zxvt;

import java.lang.IllegalArgumentException;

class BadAttributeException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    BadAttributeException(final String msg) {
        super(msg);
    }

}
