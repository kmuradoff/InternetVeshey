package ru.unn.internetveshey.interceptor;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import ru.unn.internetveshey.dto.enums.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterceptorUtils {
    public static boolean isPermissionGranted(Object handler) {
        List<Role> roles = new ArrayList<>();

        if (handler instanceof HandlerMethod) {
            HasRole hasRole = ((HandlerMethod) handler).getMethodAnnotation(HasRole.class);

            if (hasRole != null)
                roles.addAll(Arrays.asList(hasRole.value()));

            Class<?> beanType = ((HandlerMethod) handler).getBeanType();

            hasRole = AnnotationUtils.findAnnotation(beanType, HasRole.class);

            if (hasRole != null) {
                roles.addAll(Arrays.asList(hasRole.value()));
            }
        }

        return CollectionUtils.isEmpty(roles);
    }
}