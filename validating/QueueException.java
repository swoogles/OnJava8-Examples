// validating/QueueException.java
// (c)2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
package validating;

public class QueueException extends RuntimeException {
  public QueueException(String why) { super(why); }
}
