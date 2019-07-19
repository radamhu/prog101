package caesar2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author tothj
 */
public class Kodolo {
    private int kulcs;

    public Kodolo(int kulcs) {
        this.kulcs = kulcs;
    }
    
    public void masol(FileInputStream be, FileOutputStream ki) 
                      throws IOException {
        while (true) {
            int c = be.read();
            if (c == -1)
                return;
            ki.write(kodol(c));
        }
    }
    
    private int kodol(int c) {
        return (c+kulcs) % 256;
    }
}
