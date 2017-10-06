package Model;


public class Client {
    
    private String name;
    private String surname;
    private String login;
    private int pin;
    private int saldo;

    public Client(String name, String surname, String login, int pin, int saldo) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.pin = pin;
        this.saldo = saldo;
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

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        return login.equals(client.login);
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}
