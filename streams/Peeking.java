// streams/Peeking.java
// (c)2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.

class Peeking  {
  public static void
  main(String[] args) throws Exception {
    FileToWords.stream("Cheese.dat")
      .skip(21)
      .limit(4)
      .map(w -> w + " ")
      .peek(System.out::print)
      .map(String::toUpperCase)
      .peek(System.out::print)
      .map(String::toLowerCase)
      .forEach(System.out::print);
  }
}
/* Output:
Well WELL well it IT it s S s so SO so
*/
