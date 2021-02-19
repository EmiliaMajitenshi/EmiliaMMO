package me.EmiliaMMO.system.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import me.EmiliaMMO.players.classes.PlayerClass;
import me.EmiliaMMO.players.classes.PlayerClassPool;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CharacterClass {
    public static class ClassAnnotationHelper {
        public static void init(AnnotationLoader loader) throws Exception {
            int count = 0;
            for (Class<?> clazz : loader.getAnnotatedClasses(CharacterClass.class)) {
                Object object = clazz.getDeclaredConstructor().newInstance();
                PlayerClassPool.registerClass((PlayerClass) object);
                count = count + 1;
            }
        }
    }

}
