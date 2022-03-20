package com.company;

public interface Storage {
    Integer getStorageCapacity();
    default void showStorage(Integer capacity)
    {
        System.out.println("mb"+capacity*1024);
        System.out.println("bytes"+capacity*1024*1024);
    }
}
