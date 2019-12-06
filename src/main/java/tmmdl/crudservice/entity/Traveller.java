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
    @Column(name = "phone")
    private String contact;
    @Column(name = "comment")
    private String comment;
    @Column(name = "mail")
    private String mail;
    @Column(name = "seeker")
    private boolean seeker;

    public Traveller() {
    }

    public Traveller(String name, String destination, String date, String contact, String comment, String mail, boolean seeker) {
        this.name = name;
        this.destination = destination;
        this.date = date;
        this.contact = contact;
        this.comment = comment;
        this.mail = mail;
        this.seeker = seeker;
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

    public String getMail() {
        return mail;
    }

    public boolean isSeeker() {
        return seeker;
    }

    public void setSeeker(boolean seeker) {
        this.seeker = seeker;
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

    public void setMail(String mail) {
        this.mail = mail;
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
                ", phone='" + contact + '\'' +
                ", mail='" + mail + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
