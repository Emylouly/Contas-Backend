package br.edu.ifba.demo.backend.api.dto;


import java.sql.Date;
import java.sql.Timestamp;

import br.edu.ifba.demo.backend.api.model.EventosModel;
import lombok.Data;


@Data
public class EventosDTO {
    private Long ideventos;
    private String title;
    private String color;
    private Timestamp start;
    private Timestamp end;
    private Boolean allDay;

    public static EventosDTO converter(EventosModel eventosModel) {
        EventosDTO eventos = new EventosDTO();
        eventos.setIdeventos(eventosModel.getIdeventos());
        eventos.setTitle(eventosModel.getTitle());
        eventos.setColor(eventosModel.getColor());
        eventos.setStart(eventosModel.getStart());
        eventos.setEnd(eventosModel.getEnd());
        eventos.setAllDay(eventosModel.getAllDay());
        return eventos;
    }
}