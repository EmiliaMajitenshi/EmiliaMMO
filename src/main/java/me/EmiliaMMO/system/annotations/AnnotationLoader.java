package me.EmiliaMMO.system.annotations;

import java.lang.annotation.Annotation;
import java.util.Set;

import org.reflections.Reflections;

public class AnnotationLoader {
    private Reflections reflections;

    public static void init() {
        try {
            new AnnotationLoader().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AnnotationLoader() {
        reflections = new Reflections("me.EmiliaMMO");
    }

    private void run() throws Exception {
        CharacterClass.ClassAnnotationHelper.init(this);
    }

    public Set<Class<?>> getAnnotatedClasses(Class<? extends Annotation> annotationClass) {
        return reflections.getTypesAnnotatedWith(annotationClass);
    }
}
