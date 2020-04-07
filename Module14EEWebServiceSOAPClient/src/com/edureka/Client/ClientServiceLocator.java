/**
 * ClientServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edureka.Client;

public class ClientServiceLocator extends org.apache.axis.client.Service implements com.edureka.Client.ClientService {

    public ClientServiceLocator() {
    }


    public ClientServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClientServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Client
    private java.lang.String Client_address = "http://localhost:8080/Module14EEWebServiceSOAP/services/Client";

    public java.lang.String getClientAddress() {
        return Client_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClientWSDDServiceName = "Client";

    public java.lang.String getClientWSDDServiceName() {
        return ClientWSDDServiceName;
    }

    public void setClientWSDDServiceName(java.lang.String name) {
        ClientWSDDServiceName = name;
    }

    public com.edureka.Client.Client getClient() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Client_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClient(endpoint);
    }

    public com.edureka.Client.Client getClient(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edureka.Client.ClientSoapBindingStub _stub = new com.edureka.Client.ClientSoapBindingStub(portAddress, this);
            _stub.setPortName(getClientWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClientEndpointAddress(java.lang.String address) {
        Client_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.edureka.Client.Client.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edureka.Client.ClientSoapBindingStub _stub = new com.edureka.Client.ClientSoapBindingStub(new java.net.URL(Client_address), this);
                _stub.setPortName(getClientWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Client".equals(inputPortName)) {
            return getClient();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Client.edureka.com", "ClientService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Client.edureka.com", "Client"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Client".equals(portName)) {
            setClientEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
