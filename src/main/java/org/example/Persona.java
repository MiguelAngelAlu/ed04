package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Constructor de contacto
 * @author Miguel Ángel
 * @version 1.0 14/03/2025
 */
class Persona {
    private String name;
    private List<String> phones;

    /**
     * Constructor del nombre y el número de teléfono
     * @param name String con el nombre del contacto
     * @param phone String con el número del contacto
     * @return devuelve un array
     */
    public Persona(String name, String phone) {
        this.setName(name);
        this.setPhones(new ArrayList<>());
        this.getPhones().add(phone);
    }

    /**
     * Getter del nombre
     * @return devuelve el nombre
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter del número
     * @return Devuelve el número de teléfono
     */
    public List<String> getPhones() {
        return this.phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}