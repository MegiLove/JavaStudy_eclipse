package com.sist.Prog10;

import java.util.*;

abstract class Book {
 int number = 0;
 String name = "", title = "";

 public int getNumber() {
  return number;
 }

 public void setNumber(int set_number) {
  number = set_number;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String set_title) {
  title = set_title;
 }

 public String getName() {
  return name;
 }

 public void setName(String set_name) {
  name = set_name;
 }

 public abstract void book();

 public abstract int getLateFees(int late);

 boolean equals(int book_number) {
  if (number == book_number)
   return true;
  else
   return false;
 }
}



