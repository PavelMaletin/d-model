package cvr.vist.stat.quickforms.ann;


import cvr.vist.stat.quickforms.api.QFormFieldType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface QFormField
{

    public abstract String title() default "#field";
    public abstract String hint() default "";
    public abstract String description() default "";
    public abstract boolean required() default false;
    public abstract String location();
    public abstract String width() default "100%";
    public abstract String height() default "";
    public abstract boolean visible() default true;
    public abstract QFormFieldType type() default QFormFieldType.Auto;
    public abstract String requiredFieldErrorMessage() default "";


}
