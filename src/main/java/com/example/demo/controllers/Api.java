package com.example.demo.controllers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// @RestController
public class Api {
  // @GetMapping("/hello")
  // public String hello() {
  // return "hello string boot";
  // }
  @FunctionalInterface
  interface A {
    @SuppressWarnings("unchecked")
    <T extends Object> T maxslidingwindow(T... t);
  }

  <T> List<? extends T> maxslidingwindow(List<? extends T> list, Predicate<?> predicate) {
    List<? extends T> ans = null;
    return ans;
  }

  public static void main(String[] args) {

    A x = new A() {
      @SuppressWarnings("unchecked")
      @Override
      public <T> T maxslidingwindow(T... t) {
        var list = (Integer[]) t[0];
        var k = (int) t[1];
        var ans = new Integer[list.length - k + 1];
        var queue = new ArrayDeque<Integer>();

        for (var i = 0; i < list.length; i++) {

          while (!queue.isEmpty() && list[queue.peekLast()] < list[i])
            queue.pollLast();

          queue.offer(i);

          if (i + 1 >= k) {
            ans[i - k + 1] = list[queue.peekFirst()];
            if (i - queue.peekFirst() + 1 >= k)
              queue.pollFirst();

          }
        }
        return (T) ans;
      }

    };
    var ans = (Integer[]) x.maxslidingwindow(new Integer[] { 6, 1, 3, 5, 4, 2, 6, 7, 8, 3 }, 3);
    System.out.println(Arrays.toString(ans));
    ArrayList<Double> y = new ArrayList<>();
    ArrayList<? extends Number> list = y;
    list.add(null);

  }

}
