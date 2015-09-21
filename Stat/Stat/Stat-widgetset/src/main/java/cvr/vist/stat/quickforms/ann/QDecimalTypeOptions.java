package cvr.vist.stat.quickforms.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface QDecimalTypeOptions {

    public abstract double min() default Double.MIN_VALUE;

    public abstract double max() default Double.MAX_VALUE;

    public abstract String validationMinimumErrorMessage() default "";

    public abstract String validationMaximumErrorMessage() default "";

}
