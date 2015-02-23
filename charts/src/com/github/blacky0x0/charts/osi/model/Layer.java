package com.github.blacky0x0.charts.osi.model;

/**
 * User: blacky
 * Date: 23.02.15
 */
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public enum Layer {

    APPLICATION(
            "Application",
            "Data",
            "High-level APIs, including resource sharing, remote file access, directory services and virtual terminals",
            "HTTP, FTP, SMTP"),

    PRESENTATION("Presentation",
            "Data",
            "Translation of data between a networking service and an application; including character encoding, data compression and encryption/decryption",
            "ASCII, EBCDIC, JPEG" ),

    SESSION("Session",
            "Data",
            "Managing communication sessions, i.e. continuous exchange of information in the form of multiple back-and-forth transmissions between two nodes",
            "RPC, PAP" ),

    TRANSPORT("Transport",
            "Segments",
            "Reliable transmission of data segments between points on a network, including segmentation, acknowledgement and multiplexing",
            "TCP, UDP" ),

    NETWORK("Network",
            "Packet / Datagram",
            "Structuring and managing a multi-node network, including addressing, routing and traffic control",
            "IPv4, IPv6, IPsec" ),

    DATA_LINK("Data link",
            "Bit / Frame",
            "Reliable transmission of data frames between two nodes connected by a physical layer",
            "PPP, IEEE 802.2, L2TP" ),

    PHYSICAL("Physical",
            "Bit",
            "Transmission and reception of raw bit streams over a physical medium",
            "DSL, USB" );

    private StringProperty name;
    private StringProperty dataUnit;
    private StringProperty layerFunction;
    private StringProperty examples;

    private Layer(String name, String dataUnit, String layerFunction, String examples) {
        this.name = new SimpleStringProperty(name);
        this.dataUnit = new SimpleStringProperty(dataUnit);
        this.layerFunction = new SimpleStringProperty(layerFunction);
        this.examples = new SimpleStringProperty(examples);
    }

    // Properties are used in table element via reflection
    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty dataUnitProperty() {
        return dataUnit;
    }

    public StringProperty layerFunctionProperty() {
        return layerFunction;
    }

    public StringProperty examplesProperty() {
        return examples;
    }
}