// network/SimpleClient.java
// (c)2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
// Sends lines to the server and
// reads lines the server sends
// {ValidateByHand}
import java.net.*;
import java.io.*;

public class SimpleClient {
  public static void
  main(String[] args) throws IOException {
    // Produce the "Local Loopback" IP address
    // for testing on one machine w/o a network:
    InetAddress addr =
      InetAddress.getLoopbackAddress();
    System.out.println("addr = " + addr);
    Socket socket =
      new Socket(addr, SimpleServer.PORT);
    // Guard everything in a try-finally to make
    // sure that the socket is closed:
    try {
      System.out.println("socket = " + socket);
      BufferedReader in =
        new BufferedReader(
          new InputStreamReader(
            socket.getInputStream()));
      // Output is automatically flushed
      // by PrintWriter:
      PrintWriter out =
        new PrintWriter(
          new BufferedWriter(
            new OutputStreamWriter(
              socket.getOutputStream())),true);
      for(int i = 0; i < 10; i ++) {
        out.println("hello " + i);
        String str = in.readLine();
        System.out.println(str);
      }
      out.println("END");
    } finally {
      System.out.println("closing...");
      socket.close();
    }
  }
}
