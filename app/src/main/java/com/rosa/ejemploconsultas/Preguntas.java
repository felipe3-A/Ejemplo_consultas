package com.rosa.ejemploconsultas;

public class Preguntas {
    String id;
    String contenedor;
    String pregunta;
    String respuesta1;
    String respuesta2;
    String respuesta3;
    String respuesta4;


    public Preguntas() {
    }

    public Preguntas(String id, String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4,String contenedor) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
        this.contenedor=contenedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public String getContenedor() {
        return contenedor;
    }

    public void setContenedor(String contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public String toString() {
        return "El investigador con id "+contenedor+" Agrego :"+" Su pregunta es:" +" " +pregunta +"?"+ "  "+"Sus Respuestas Son : " + " \n " + respuesta1+ "\n" + respuesta2+ "\n" +respuesta3+ "\n"+respuesta4 ;
    }
}
