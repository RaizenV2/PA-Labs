package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("L11 ");

        try {
            Class testClass = ClassLoader.getSystemClassLoader().loadClass("com.company.TestClass");
            System.out.println("Loaded class succsefully!:)");
            System.out.println("Name :"+testClass.getCanonicalName());
            System.out.println("Modifiers: "+ Modifier.toString(testClass.getModifiers()));
            System.out.println("Type Parameters! \n");
            TypeVariable[] tv = testClass.getTypeParameters();
            if(tv.length != 0 )
            {
                for(TypeVariable t : tv)
                {
                    System.out.print(" "+t.getName());
                }

            }
            else
            {
                System.out.println("No type parameters!\n");
            }
            System.out.println("Implemented Interfaces! : \n");
            Type[] intfs  = testClass.getGenericInterfaces();
            if(intfs.length !=0 )
            {
                for(Type intf : intfs)
                {
                    System.out.print(" "+intfs.toString());
                }
            }
            else
            {
                System.out.println("No Implemented Interfaces");
            }

           
            List<Class> l = new ArrayList<Class>();


            Annotation[] ann = testClass.getAnnotations();
            if (ann.length != 0) {
                for (Annotation a : ann)
                    System.out.println(a.toString());
            } else {
                System.out.println("No Annonations:");
            }

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }
}
