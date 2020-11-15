package main;
import business.*;
import util.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

import org.w3c.dom.*;
import java.io.IOException;
import java.io.File;
import java.util.UUID;

public class Main{
    public static void main(String[] args) {
        System.out.println("Welcome in jMusicHub,");
        System.out.println("Reading library...");
        XMLReaderWriter Reader = new XMLReaderWriter();
        NodeList albums = null;
        albums = Reader.parseXMLFile("files/albums.xml");
        Reader.readAlbumsXML("files/albums.xml");

    }
}
