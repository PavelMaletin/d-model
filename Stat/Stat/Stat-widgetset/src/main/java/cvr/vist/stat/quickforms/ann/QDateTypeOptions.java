package cvr.vist.stat.quickforms.ann;

import com.vaadin.shared.ui.datefield.Resolution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface QDateTypeOptions {

    public abstract Resolution resulution() default Resolution.DAY;

    public abstract String format() default "dd.MM.yyyy";

    public abstract String min() default "";

    public abstract String max() default "";
}
