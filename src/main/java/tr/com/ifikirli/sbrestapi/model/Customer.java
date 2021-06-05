package tr.com.ifikirli.sbrestapi.model;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import tr.com.ifikirli.sbrestapi.util.AuthUtil;

@Document("customers")
public class Customer extends BaseModel {

    String email;
    String name;
    String surname;
    boolean isAdministrator;
    Binary salt;
    Binary password;

    public Customer(String email, String name, String surname, boolean isAdministrator) {

        super();
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.isAdministrator = isAdministrator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public Binary getSalt() {
        return salt;
    }

    public void setSalt(Binary salt) {
        this.salt = salt;
    }

    public Binary getPassword() {
        return password;
    }

    public void setPassword(Binary password) {
        this.password = password;
    }

    public void setBinaryFields(String password) {

        byte[] _salt = AuthUtil.generateSalt();
        this.salt = new Binary(BsonBinarySubType.BINARY, _salt);
        this.password = new Binary(BsonBinarySubType.BINARY, AuthUtil.generatePassword(password, _salt));
    }
}
