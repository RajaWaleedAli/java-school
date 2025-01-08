package Personenverwaltung;

public class PersonRepository {
    private Person[] p;
    Exception IDNotExistsException;
    Exception IDInUseException;
    Exception RepositoryFullException;

    public PersonRepository() {
        this.p = new Person[10];
        this.IDNotExistsException = new Exception("ID nicht Vorhanden!");
        this.IDInUseException = new Exception("ID schon Vorhanden!");
        this.RepositoryFullException = new Exception("Zu viele Personen!");
    }
    public void addPerson(Person p) throws Exception {
        for (int i = 0; i < this.p.length; i++) {
            if(this.p[i].getId()==p.getId()) {
                throw IDInUseException;
            }
            if (this.p[i] == null) {
                this.p[i] = p;
                return;
            }
        }
        throw RepositoryFullException;
    }
    public Person getPerson(int id) throws Exception {
        for (int i = 0; i < this.p.length; i++) {
            if(this.p[i].getId() == id) {
                return this.p[i];
            }
        }
        throw IDNotExistsException;
    }
    public void removePerson(Person p) throws Exception {
        for (int i = 0; i < this.p.length; i++) {
            if(this.p[i].getId() == p.getId()) {
                this.p[i] = null;
                return;
            }
        }
        throw IDNotExistsException;
    }
}
