package com.fiji.fivm.test;
public class NullBooleanArrayLoad {
   public static void main(String[] v) {
      boolean[] array=null;
      System.out.println(array[Integer.parseInt(v[0])]);
      System.out.println("got to here.");
   }
}
