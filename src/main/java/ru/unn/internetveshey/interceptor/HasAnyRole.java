package ru.unn.internetveshey.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ru.unn.internetveshey.dto.enums.Role;

/**
 * Разрешает доступ к API ресурсу при наличии хотя бы одной роли у пользователя из {@link Role}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface HasAnyRole {
}