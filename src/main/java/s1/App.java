package s1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

class Bar {}

class Foo {
    private Bar bar;
    Foo(Bar bar) { this.bar = bar; }
    @Override public String toString() {
        return super.toString() + "(" + bar + ")";
    }
}

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedAnnotationType {

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UninheritedAnnotationType {

}

@UninheritedAnnotationType
interface A {

}

@InheritedAnnotationType
interface B extends A {

}

interface C extends B {

}


@Configuration
class BaseAppConfig {
    @Bean
    public Foo foo() { return new Foo(bar()); }
    @Bean public Bar bar() { return new Bar(); }
}

/** Omitting @Configuration here */
class AppConfig extends BaseAppConfig {
    @Bean @Override public Bar bar() { return new Bar(); }
}

public class App {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppConfig.class)) {
            System.out.println(ctx.getBean(Foo.class).toString());
            System.out.println(ctx.getBean(Bar.class).toString());

            System.out.println(A.class.getAnnotation(InheritedAnnotationType.class));
            System.out.println(B.class.getAnnotation(InheritedAnnotationType.class));
            System.out.println(C.class.getAnnotation(InheritedAnnotationType.class));
            System.out.println("_________________________________");
            System.out.println(A.class.getAnnotation(UninheritedAnnotationType.class));
            System.out.println(B.class.getAnnotation(UninheritedAnnotationType.class));
            System.out.println(C.class.getAnnotation(UninheritedAnnotationType.class));
        }
    }
}