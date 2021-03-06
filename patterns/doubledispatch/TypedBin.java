// patterns/doubledispatch/TypedBin.java
// (c)2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
// A List that can grab the right type
package patterns.doubledispatch;
import patterns.trash.*;
import java.util.*;

public abstract class TypedBin {
  List<Trash> v = new ArrayList<>();
  protected boolean addIt(Trash t) {
    v.add(t);
    return true;
  }
  public boolean add(Aluminum a) {
    return false;
  }
  public boolean add(Paper a) {
    return false;
  }
  public boolean add(Glass a) {
    return false;
  }
  public boolean add(Cardboard a) {
    return false;
  }
}
