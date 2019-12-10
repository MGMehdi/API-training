package objects;

/**
 * Client
 */
public class Client {

    private int _id;
    private String _name;
    private String _mail;

    public Client() {
    }

    public Client(String _mail) {
        this._mail = _mail;
    }

    public Client(String _name, String _mail) {
        this._name = _name;
        this._mail = _mail;
    }

    public Client(int _id, String _name, String _mail) {
        this._id = _id;
        this._name = _name;
        this._mail = _mail;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_mail() {
        return _mail;
    }

    public void set_mail(String _mail) {
        this._mail = _mail;
    }

    
    
}