package br.edu.ifba.demo.backend.api.model;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "eventos")
public class EventosModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideventos")
    private Long ideventos;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "start", nullable = false)
    private Timestamp start;

    @Column(name = "end", nullable = false)
    private Timestamp end;

    @Column(name = "all_Day", nullable = false)
    private Boolean allDay;

    public EventosModel() {
        super();
    }    


    public EventosModel(long ideventos, String title, String color, Timestamp start, Timestamp end, Boolean allDay){
        super();
        this.ideventos = ideventos;
        this.title = title;
        this.color = color;
        this.start = start;
        this.end = end;
        this.allDay = allDay;
    }
   
}