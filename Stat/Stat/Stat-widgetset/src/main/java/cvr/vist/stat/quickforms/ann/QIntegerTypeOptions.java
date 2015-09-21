package cvr.vist.stat.quickforms.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface QIntegerTypeOptions
{

    public abstract long min() default Long.MIN_VALUE;
    public abstract long max() default Long.MAX_VALUE;
    public abstract String validationMinimumErrorMessage() default "";
    public abstract String validationMaximumErrorMessage() default "";


}
