import java.util.*;
import java.awt.*;
import java.io.*;
import lib.*;

public class Main
{
    public static void main(String[] args) 
    {
        if(args.length >= 2)
        {
            if(args[0].equals("-d"))
            {
                Debug debug = new Debug();
                debug.startDebug(Integer.parseInt(args[1]));
                return;
            }
            else
            {
                System.err.println("[!] Invalid Option! ");
            }
        }
        
        System.err.println("Calling main");
    }
}