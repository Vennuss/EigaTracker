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
        else OptionsStructureFixer();
        String[] ops = new String[2];
        try{
            ops[0] = ReadLine(Options, 1);
            ops[1] = ReadLine(Options, 3);
        }
        catch(Exception ex){
            System.exit(1);
        }
        mm.StartUP(ops);
    }
    
    public FM(){}
    
    public void Write(final File _f, final String _text, final boolean _append){
        try {
            FileWriter fw = new FileWriter(_f, _append);
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
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }
    
    public String Read(final File _f){
        String text = "";
        try {
            Scanner sc = new Scanner(_f);
            while(sc.hasNextLine()){
                text = text.concat(sc.nextLine()) + "\n";
            }
            sc.close();
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
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return "Error";
    }
    
    private boolean SizeCheck(final File _f, final int _s){
        Scanner sc;
        int i = 0;
        try {
            sc = new Scanner(_f);
            while(sc.hasNextLine()){
                i++;
                sc.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return i == _s;
    }
    
    private void OptionsStructureFixer(){
        File ops = new File("src\\Options\\Options.txt");
        if(false == SizeCheck(ops, 4)){
            try {
                Scanner sc = new Scanner(ops);
                String text = "";
                String line;
                int n = 0;
                while(sc.hasNextLine()){
                    line = sc.nextLine();
                    if(!line.isBlank()){
                        for(int i = 0; i < line.length(); i++){
                            if(line.charAt(i) == ']')
                                text = text.concat("]\n");
                            else if(line.charAt(i) == '[' && n != 0)
                                text = text.concat("\n[");
                            else text = text.concat(Character.toString(line.charAt(i)));
                        }
                        n++;
                    }
                }
                Write(ops, text, false);
                sc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
