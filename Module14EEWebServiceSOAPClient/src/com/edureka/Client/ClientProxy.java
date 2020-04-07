package com.edureka.Client;

public class ClientProxy implements com.edureka.Client.Client {
  private String _endpoint = null;
  private com.edureka.Client.Client client = null;
  
  public ClientProxy() {
    _initClientProxy();
  }
  
  public ClientProxy(String endpoint) {
    _endpoint = endpoint;
    _initClientProxy();
  }
  
  private void _initClientProxy() {
    try {
      client = (new com.edureka.Client.ClientServiceLocator()).getClient();
      if (client != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)client)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)client)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (client != null)
      ((javax.xml.rpc.Stub)client)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.edureka.Client.Client getClient() {
    if (client == null)
      _initClientProxy();
    return client;
  }
  
  public int usdToInr(int dollar) throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    return client.usdToInr(dollar);
  }
  
  public java.lang.String sayHello() throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    return client.sayHello();
  }
  
  
}