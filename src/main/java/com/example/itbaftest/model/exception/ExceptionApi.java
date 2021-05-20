package com.example.itbaftest.model.exception;


public class ExceptionApi extends RuntimeException {
    private int codigo;
    private String mensaje;
    private String datos;

    public ExceptionApi(int codigo, String mensaje, String datos) {
        super(mensaje+(!datos.equals("")?"[" +datos+"]":""));
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.datos = datos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}
