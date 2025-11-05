package com.dobby.user_service.util;

import java.util.function.Consumer;

public class CheckNull {
    public static <T> void updateIfNotNull(T newValue, Consumer<T> setter) {
        if (newValue != null) {
            setter.accept(newValue);
        }
    }
}
