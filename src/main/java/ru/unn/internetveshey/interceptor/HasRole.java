package ru.unn.internetveshey.interceptor;

import ru.unn.internetveshey.dto.enums.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Позволяет определить ролевой доступ к API ресурсу
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface HasRole {

    /**
     * Список ролей, которым разрешен доступ к ресурсу.
     */
    Role[] value();
}