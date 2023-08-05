package Tienda.Tienda.service;

import jakarta.mail.MessagingException;

public interface ICorreoService {
    public void enviarCorreoHtml(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
}