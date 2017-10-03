package Operations;

import java.io.IOException;

public interface Operations {

    void addCash(int value) throws IOException;
    void giveCash(int value) throws IOException;
    void showClientDetails();
    void showBalance();
}
