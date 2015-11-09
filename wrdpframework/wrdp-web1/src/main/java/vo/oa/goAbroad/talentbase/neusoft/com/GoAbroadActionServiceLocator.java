/**
 * GoAbroadActionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package vo.oa.goAbroad.talentbase.neusoft.com;

public class GoAbroadActionServiceLocator extends org.apache.axis.client.Service implements vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadActionService {

    public GoAbroadActionServiceLocator() {
    }


    public GoAbroadActionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GoAbroadActionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GoAbroadOneService
    private java.lang.String GoAbroadOneService_address = "http://localhost:8080/yy/services/GoAbroadOneService";

    public java.lang.String getGoAbroadOneServiceAddress() {
        return GoAbroadOneService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GoAbroadOneServiceWSDDServiceName = "GoAbroadOneService";

    public java.lang.String getGoAbroadOneServiceWSDDServiceName() {
        return GoAbroadOneServiceWSDDServiceName;
    }

    public void setGoAbroadOneServiceWSDDServiceName(java.lang.String name) {
        GoAbroadOneServiceWSDDServiceName = name;
    }

    public vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadAction getGoAbroadOneService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GoAbroadOneService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGoAbroadOneService(endpoint);
    }

    public vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadAction getGoAbroadOneService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadOneServiceSoapBindingStub _stub = new vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadOneServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getGoAbroadOneServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGoAbroadOneServiceEndpointAddress(java.lang.String address) {
        GoAbroadOneService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadAction.class.isAssignableFrom(serviceEndpointInterface)) {
                vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadOneServiceSoapBindingStub _stub = new vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadOneServiceSoapBindingStub(new java.net.URL(GoAbroadOneService_address), this);
                _stub.setPortName(getGoAbroadOneServiceWSDDServiceName());
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
        if ("GoAbroadOneService".equals(inputPortName)) {
            return getGoAbroadOneService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("com.neusoft.talentbase.goAbroad.oa.vo", "GoAbroadActionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("com.neusoft.talentbase.goAbroad.oa.vo", "GoAbroadOneService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GoAbroadOneService".equals(portName)) {
            setGoAbroadOneServiceEndpointAddress(address);
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
