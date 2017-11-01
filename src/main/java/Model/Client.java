package Model;

/**
 * Class describes model of ATM client;
 * Contain name, surname, login and bank account status fields;
 * Contain getters for all fields, setter for account status field;
 * toString(), equals(), hashcode() overridden for tests needs;
 */

public class Client {
    
    private String name;
    private String surname;
    private String login;
    private int balance;

    public Client(String name, String surname, String login, int balance) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        return balance == client.balance && name.equals(client.name)
                                         && surname.equals(client.surname)
                                         && login.equals(client.login);
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}