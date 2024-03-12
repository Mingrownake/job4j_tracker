package ru.job4j.ood.parkinglot;

public interface Parking {

    void parkTransport(Transport transport);  /*процесс парковки, уменьшение кол-ва свободных мест*/

    int getFreeLots();  /* получить кол-во свободных мест */

    int getOccupiedLots(); /* получить кол-во занятных мест */

}
