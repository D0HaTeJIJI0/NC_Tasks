package com.netcracker.edu.travnichev.exception;

import com.netcracker.edu.travnichev.view.Viewer;

public class NoBouquetException extends Exception {
    public NoBouquetException() {
        super();
    }

    public void printInfo() {
        Viewer.printNoBouquet();
        Viewer.pause();
    }
}
