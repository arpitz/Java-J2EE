/**
 * ClientService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edureka.Client;

public interface ClientService extends javax.xml.rpc.Service {
    public java.lang.String getClientAddress();

    public com.edureka.Client.Client getClient() throws javax.xml.rpc.ServiceException;

    public com.edureka.Client.Client getClient(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
