import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.sun.javafx.image.impl.ByteBgra.setter;
import static com.sun.javafx.image.impl.IntArgb.getter;

/**
 * Created by Vlad on 16.12.2016.
 */
public class BeanUtils {

    boolean isCompatible(Method setter, Method getter) {
        Class returnType = getter.getReturnType();
        Class parameterType = setter.getParameterTypes()[0];
        return parameterType.isAssignableFrom(returnType);
    }

    public void assign(Object to, Object from) {



        try {

            // from
            PropertyDescriptor[] fromDescriptors = new PropertyDescriptor[0];

            fromDescriptors = Introspector.getBeanInfo(from.getClass()).getPropertyDescriptors();
            List<Method> getters = new ArrayList<>();
            List<Class> typesGetters = new ArrayList<>();
            for (PropertyDescriptor descriptor : fromDescriptors) {
                Method getter = descriptor.getReadMethod();
                if (getter.getName().equals("getClass")) {
                    continue;
                }
                getters.add(getter);
                typesGetters.add(descriptor.getPropertyType());
            }


            // to
            PropertyDescriptor[] toDescriptors = new PropertyDescriptor[0];


            toDescriptors = Introspector.getBeanInfo(to.getClass()).getPropertyDescriptors();
            List<Method> setters = new ArrayList<>();
            List<Class> typesSetters = new ArrayList<>();
            for (PropertyDescriptor descriptor : toDescriptors) {
                Method setter = descriptor.getWriteMethod();
                setters.add(setter);
                typesSetters.add(descriptor.getPropertyType());
            }

            /*for (int i = 0; i < setters.size(); ++i) {
                for (int j = 0; j < getters.size(); ++j) {
                    if (isCompatible(setters.get(i), getters.get(j))) {
                        setters.get(i).invoke(to, getters.get(j).invoke(from));
                    }
                }
            }*/
            for (Method setter : setters) {
                if (setter == null ) { // КОСТЫЛЬ
                    continue;
                }
                for (Method getter : getters) {
                    if (isCompatible(setter, getter)) {
                        setter.invoke(to, getter.invoke(from));
                        break;
                    }
                }

            }


        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }


}

