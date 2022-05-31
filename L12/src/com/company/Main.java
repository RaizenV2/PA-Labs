package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
	// write your code here
        out.println("L11 ");

        try {
            Class testClass = ClassLoader.getSystemClassLoader().loadClass("com.company.TestClass");
            out.println("Loaded class succsefully!:)");
            out.println("Name :"+testClass.getCanonicalName());
            out.println("Modifiers: "+ Modifier.toString(testClass.getModifiers()));
            out.println("Type Parameters! \n");
            TypeVariable[] tv = testClass.getTypeParameters();
            if(tv.length != 0 )
            {
                for(TypeVariable t : tv)
                {
                    out.print(" "+t.getName());
                }

            }
            else
            {
                out.println("No type parameters!\n");
            }
            out.println("Implemented Interfaces! : \n");
            Type[] intfs  = testClass.getGenericInterfaces();
            if(intfs.length !=0 )
            {
                for(Type intf : intfs)
                {
                    out.print(" "+intfs.toString());
                }
            }
            else
            {
                out.println("No Implemented Interfaces");
            }


            List<Class> l = new ArrayList<Class>();


            Annotation[] ann = testClass.getAnnotations();
            if (ann.length != 0) {
                for (Annotation a : ann)
                    out.println(a.toString());
            } else {
                out.println("No Annonations:");
            }


            Object t  = testClass;

            Method[] allMethods = testClass.getDeclaredMethods();
            for (Method m : allMethods) {
                String mname = m.getName();
                if (!mname.startsWith("test")
                        || (m.getGenericReturnType() != boolean.class)) {
                    continue;
                }
                Type[] pType = m.getGenericParameterTypes();
                if ((pType.length != 1)
                        || Locale.class.isAssignableFrom(pType[0].getClass())) {
                    continue;
                }
                out.format("invoking %s()%n", mname);


                m.setAccessible(true);
                Object o = m.invoke(t, new Locale(args[1], args[2], args[3]));
                out.format("%s() returned %b%n", mname, (Boolean) o);
            }





        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }
}
