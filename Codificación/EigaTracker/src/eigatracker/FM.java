package eigatracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hugse
 */
public class FM {
    
    public FM(final MainMenu mm){
        File Options = new File("src\\Options\\Options.txt");
        if(!Options.exists()) Write(Options, "[XAMPP PATH]\nC:\\xampp\n[START UP DELAY]\n1000", false);
        String[] ops = new String[2];
        try{
            ops[0] = ReadLine(Options, 1);
            System.out.println("1: " + ops[0] + " | " + ReadLine(Options, 0));
            ops[1] = ReadLine(Options, 3);
            System.out.println("2: " + ops[1] + " | " + ReadLine(Options, 2));
        }
        catch(Exception ex){
            System.exit(1);
        }
        mm.StartUP(ops);
    }
    
    public FM(){}
    
    public void Write(final File _f, final String _text, final boolean _overWrite){
        try {
            FileWriter fw = new FileWriter(_f, _overWrite);
            fw.write(_text);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public void Write(final String _f, final String _text, final boolean _append){
        try {
            File f = new File(_f);
            FileWriter fw = new FileWriter(f, _append);
            fw.write(_text);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public String Read(final File _f){
        String text = "";
        try {
            Scanner sc = new Scanner(_f);
            while(sc.hasNextLine()){
                text = text.concat(sc.nextLine()) + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return text;
    }
    
    public String ReadLine(final File _f, final int _l){
        try {
            Scanner sc = new Scanner(_f);
            int i = 0;
            while(sc.hasNextLine()){
                if(i == _l) return sc.nextLine();
                else{
                    i++;
                    sc.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return "Error";
    }
    
    public void WriteLine(final File _f, final String _newLine, final int _l){
        try {
            Scanner sc = new Scanner(_f);
            String text = "";
            int i = 0;
            while(sc.hasNextLine()){
                if(i == _l) {
                    text = text.concat(_newLine + "\n");
                    sc.nextLine();
                }
                else text = text.concat(sc.nextLine() + "\n");
                i++;
            }
            Write(_f, text, false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }
    
}
