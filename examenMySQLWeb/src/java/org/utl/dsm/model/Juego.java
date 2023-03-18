/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.model;

/**
 *
 * @author carlossanchez
 */
public class Juego {

    private int idJuego;
    private String nombre;
    private String desarrollador;
    private String categoria;
    private String clasificacion;
    private String plataforma;
    private int precio;
    private int estatus;

    public Juego() {
    }

    public Juego(String nombre, String desarrollador, String categoria, String clasificacion, String plataforma, int precio, int estatus) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.categoria = categoria;
        this.clasificacion = clasificacion;
        this.plataforma = plataforma;
        this.precio = precio;
        this.estatus = estatus;
    }

    public Juego(int idJuego, String nombre, String desarrollador, String categoria, String clasificacion, String plataforma, int precio, int estatus) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.categoria = categoria;
        this.clasificacion = clasificacion;
        this.plataforma = plataforma;
        this.precio = precio;
        this.estatus = estatus;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Juego{" + "idJuego=" + idJuego + ", nombre=" + nombre + ", desarrollador=" + desarrollador + ", categoria=" + categoria + ", clasificacion=" + clasificacion + ", plataforma=" + plataforma + ", precio=" + precio + ", estatus=" + estatus + '}';
    }
}
