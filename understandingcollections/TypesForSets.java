// understandingcollections/TypesForSets.java
// (c)2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
// Methods necessary to put your own type in a Set
import java.util.*;
import java.util.function.*;

class SetType {
  int i;
  public SetType(int n) { i = n; }
  @Override
  public boolean equals(Object o) {
    return o instanceof SetType && (i == ((SetType)o).i);
  }
  @Override
  public String toString() { return Integer.toString(i); }
}

class HashType extends SetType {
  public HashType(int n) { super(n); }
  @Override
  public int hashCode() { return i; }
}

class TreeType extends SetType
implements Comparable<TreeType> {
  public TreeType(int n) { super(n); }
  @Override
  public int compareTo(TreeType arg) {
    return (arg.i < i ? -1 : (arg.i == i ? 0 : 1));
  }
}

public class TypesForSets {
  static <T> Set<T>
  fill(Set<T> set, Function<Integer, T> type) {
    for(int i = 0; i < 10; i++)
        set.add(type.apply(i));
    return set;
  }
  static <T> void
  test(Set<T> set, Function<Integer, T> type) {
    fill(set, type);
    fill(set, type); // Try to add duplicates
    fill(set, type);
    System.out.println(set);
  }
  public static void main(String[] args) {
    test(new HashSet<>(), HashType::new);
    test(new LinkedHashSet<>(), HashType::new);
    test(new TreeSet<>(), TreeType::new);
    // Things that don't work:
    test(new HashSet<>(), SetType::new);
    test(new HashSet<>(), TreeType::new);
    test(new LinkedHashSet<>(), SetType::new);
    test(new LinkedHashSet<>(), TreeType::new);
    try {
      test(new TreeSet<>(), SetType::new);
    } catch(Exception e) {
      System.out.println("Expected: " + e.getMessage());
    }
    try {
      test(new TreeSet<>(), HashType::new);
    } catch(Exception e) {
      System.out.println("Expected: " + e.getMessage());
    }
  }
}
/* Output:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
[8, 6, 3, 5, 4, 2, 2, 1, 0, 3, 6, 7, 9, 1, 3, 1, 5, 0, 9,
8, 0, 9, 8, 7, 4, 6, 2, 4, 7, 5]
[2, 2, 1, 4, 6, 6, 8, 4, 9, 3, 0, 4, 8, 5, 8, 1, 7, 5, 5,
3, 1, 9, 6, 0, 7, 0, 9, 7, 2, 3]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8,
9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8,
9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Expected: SetType cannot be cast to java.lang.Comparable
Expected: HashType cannot be cast to java.lang.Comparable
*/
