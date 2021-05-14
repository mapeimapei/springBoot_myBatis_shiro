package com.mapei.www.exception;


import javax.validation.*;
import java.util.Set;

public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws ValidationException 校验不通过，则报ValidationException异常
     */
    public static void validateEntity(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            constraintViolations.forEach(o -> {
                String field = o.getPropertyPath().toString();
                String code = o.getMessage();
                String message = String.format("%s:%s", field, code);
                throw new ValidationException(message);
            });
        }
    }
}