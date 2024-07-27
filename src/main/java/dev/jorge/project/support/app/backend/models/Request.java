package dev.jorge.project.support.app.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private long id;

    private String name;

    public Request() {

    }

    public Request(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public Object getDescription() {
      
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public Object getRequesterName() {
      
        throw new UnsupportedOperationException("Unimplemented method 'getRequesterName'");
    }

    public void setRequesterName(Object requesterName) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setRequesterName'");
    }

    public void setDescription(Object description) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setDescription'");
    }

    public Object getSubject() {
    
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    public void setSubject(Object subject) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setSubject'");
    }

    public void setStatus(String string) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    }

}


