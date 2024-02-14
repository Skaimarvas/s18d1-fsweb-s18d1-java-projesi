package com.example.s18d1jpa.util;

import com.example.s18d1jpa.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
  public static void checkname(String name){
      if(name == null || name.isEmpty()){
          throw new BurgerException("Name is null or empty!", HttpStatus.BAD_REQUEST);

      }
  }
}
