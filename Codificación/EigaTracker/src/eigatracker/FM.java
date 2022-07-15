package eigatracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hugse
 */
public class FM {
    
    public static String ROUTE = "";
    
    public FM(final MainMenu mm){
        try{
            ROUTE = new File(FM.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI()).getParent();
            JOptionPane.showMessageDialog(null, ROUTE);
            File Options = new File(ROUTE + "\\Options\\Options.txt");
            File Parent = new File(ROUTE + "\\Options");
            if(!Parent.exists()) Parent.mkdir();
            if(!Options.exists())
                Write(Options, "[XAMPP PATH]\nC:\\xampp\n[START UP DELAY]\n2000", false);
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
        catch(URISyntaxException ex){
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public FM(){
        try {
            ROUTE = new File(FM.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI()).getParent();
        } catch (URISyntaxException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Write(final File _f, final String _text, final boolean _append){
        try {
            try (FileWriter fw = new FileWriter(_f, _append)) {
                fw.write(_text);
            }
        } catch (IOException ex) {
            Logger.getLogger(FM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public void Write(final String _f, final String _text, final boolean _append){
        try {
            try (FileWriter fw = new FileWriter(new File(_f), _append)) {
                fw.write(_text);
            }
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
        File ops = new File(ROUTE + "\\Options\\Options.txt");
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
