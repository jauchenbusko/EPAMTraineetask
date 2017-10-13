package Operations;

/**
 * Operation interface describes operations which client can provide during interaction with ATM
 *
 * addCash() method must increases client account status by input value
 * checks if input value mod 5 is equal 0 because only 5, 10 and 20 bills are accepted
 *
 * giveCash() method must decreases client account status by input value
 * checks if input value mod 5 is equal 0 because only 5, 10 and 20 bills are accepted
 * checks if input value is lower than clients account status
 *
 * showClientDetails() method must print client Name and Surname fields
 *
 * showClientBalance() method must print current client account status
 */

public interface OperationsI {

    void addCash(int value);

    void giveCash(int value);

    void showClientDetails();

    void showClientBalance();
}
