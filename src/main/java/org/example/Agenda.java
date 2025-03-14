package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lista de contactos de agenda
 * @author Miguel Ángel
 * @version 1.0 14/03/2025
 */
public class Agenda {
    private List<Contacto> contacts; // Lista de Contacto

    /**
     *  Muestra un array de números
     * @return
     */
    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Comprueba si el contacto nuevo existe dentro de la agenda, si no está, lo añade.
     * @param name String con el nombre del contacto
     * @param phone String con el número del contacto
     */
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Contacto c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Contacto newContact = new Contacto(name, phone);
            contacts.add(newContact);
        }
    }

    /**
     * Nombre del contacto a eliminar, busca el nombre
     * @param name String con el nombre a eliminar
     */
    public void removeContact(String name) {
        Iterator<Contacto> it = contacts.iterator();

        while (it.hasNext()) {
            Contacto c = it.next();

            if (c.getName().equalsIgnoreCase(name)) {
                it.remove();
            }
        }
    }

    /**
     * Modifica el contacto de la agenda
     * @param name String con el nombre del contacto
     * @param oldPhone String con el número antigüo del contacto
     * @param newPhone String con el número nuev del contacto
     */
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Contacto c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                List<String> phones = c.getPhones();

                int index = phones.indexOf(oldPhone);

                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

    /**
     * Muestra los contactos
     * @return devuelve una lista
     */
    public List<Contacto> getContacts() {
        return this.contacts;
    }
}