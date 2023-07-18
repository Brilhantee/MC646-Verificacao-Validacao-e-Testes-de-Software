package com.mbtroads;

import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {
    TestExecutor executor1 = new TestExecutor(
      PathModelTest.class,
            MultiGraphModelTest.class,
            SingleGraphModelTest.class
    );

    Result result1 = executor1.execute(true);
    System.out.println("Done: [" + result1.getResults().toString(2) + "]");
  }
}
