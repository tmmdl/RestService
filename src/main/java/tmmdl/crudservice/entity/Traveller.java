package tmmdl.crudservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "traveller")
public class Traveller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "destination")
    private String destination;
    @Column(name = "date")
    private String date;
    @Column(name = "contact")
    private String contact;
    @Column(name = "comment")
    private String comment;

    public Traveller() {
    }

    public Traveller(String name, String destination, String date, String contact, String comment) {
        this.name = name;
        this.destination = destination;
        this.date = date;
        this.contact = contact;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getContact() {
        return contact;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", contact='" + contact + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
