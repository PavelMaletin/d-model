package cvr.vist.stat.quickforms.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface QTextTypeOptions
{

    public abstract int min() default 0;
    public abstract int max() default 100;
    public abstract boolean multiline() default false;
    public abstract int lines() default 5;
    public abstract boolean password() default false;
    public abstract String validationRegexp() default "";
    public abstract String validationErrorMessage() default "";


}
