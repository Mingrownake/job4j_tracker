package ru.job4j.ood.parkinglot;

import java.util.ArrayList;
import java.util.List;

public interface Parking {

    List<Transport> PARKINGLOTS = new ArrayList<>(); /* кол-во парковочных мест всего */

    void parkTransport(Transport transport);  /*процесс парковки, уменьшение кол-ва свободных мест*/

    int getFreeLots();  /* получить кол-во свободных мест */

    int getOccupiedLots(); /* получить кол-во занятных мест */

}
