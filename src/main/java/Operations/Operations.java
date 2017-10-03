package Operations;

import java.io.IOException;

public interface Operations {

    public void addCash(int value) throws IOException;
    public void giveCash(int value) throws IOException;
    public void showBalance();
}
