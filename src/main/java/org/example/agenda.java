package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lista de contactos de agenda
 * @author Miguel Ángel
 * @version 1.0 14/03/2025
 */
public class agenda implements interfazAgenda {
    private List<Persona> contacts; // Lista de Contacto

    /**
     *  Muestra un array de números
     * @return
     */
    public agenda() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Comprueba si el contacto nuevo existe dentro de la agenda, si no está, lo añade.
     * @param name String con el nombre del contacto
     * @param phone String con el número del contacto
     */
    @Override
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Persona newContact = new Persona(name, phone);
            contacts.add(newContact);
        }
    }

    /**
     * Nombre del contacto a eliminar, busca el nombre
     * @param name String con el nombre a eliminar
     */
    @Override
    public void removeContact(String name) {
        Iterator<Persona> it = contacts.iterator();

        while (it.hasNext()) {
            Persona c = it.next();

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
    @Override
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Persona c : contacts) {
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
    @Override
    public List<Persona> getContacts() {
        return this.contacts;
    }
}