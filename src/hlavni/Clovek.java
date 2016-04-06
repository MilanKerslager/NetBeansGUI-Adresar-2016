// třída pro objekt, který bude obsahovat vše o jednom
// záznamu v adresáři, tj. jméno, příjmení, ...

package hlavni;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clovek {
    private final String SOUBOR = "adresar.txt";
    private String jmeno;
    private String prijmeni;
    private boolean muz;

    public Clovek() {
        jmeno = "";
        prijmeni = "";
        muz = true;
        nactiSeZDisku();
    }
    
    public void ulozSeNaDisk() {
        BufferedWriter vystup;
        try {
            vystup = new BufferedWriter(new FileWriter(SOUBOR));
            vystup.write(this.jmeno+"\r\n");
            vystup.write(this.prijmeni+"\r\n");
            if (muz) {
                vystup.write("muž\r\n");
            } else {
                vystup.write("žena\r\n");
            }
            vystup.close();
        } catch (IOException ex) {
            Logger.getLogger(Clovek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final void nactiSeZDisku() {
        BufferedReader vstup;
        try {
            vstup = new BufferedReader(new FileReader(SOUBOR));
            String radek;
            while ((radek = vstup.readLine()) != null) {
                if (jmeno.isEmpty()) {
                    jmeno = radek;
                } else if (prijmeni.isEmpty()) {
                    prijmeni = radek;
                } else {
                    if (radek.equals("muž")) {
                        this.muz = true;
                    } else {
                        this.muz = false;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Clovek.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Clovek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public boolean isMuz() {
        return muz;
    }

    public void setMuz(boolean muz) {
        this.muz = muz;
    }
    
}
