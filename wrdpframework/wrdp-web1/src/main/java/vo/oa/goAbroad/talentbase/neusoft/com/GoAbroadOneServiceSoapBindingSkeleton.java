/**
 * GoAbroadOneServiceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package vo.oa.goAbroad.talentbase.neusoft.com;

public class GoAbroadOneServiceSoapBindingSkeleton implements vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadAction, org.apache.axis.wsdl.Skeleton {
    private vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadAction impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("com.neusoft.talentbase.goAbroad.oa.vo", "goAbroadInformationHRToOA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("goAbroadInformationHRToOA", _params, new javax.xml.namespace.QName("com.neusoft.talentbase.goAbroad.oa.vo", "goAbroadInformationHRToOAReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:java:com.neusoft.talentbase.goAbroad.oa.vo", "GoAbroadVO"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "goAbroadInformationHRToOA"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("goAbroadInformationHRToOA") == null) {
            _myOperations.put("goAbroadInformationHRToOA", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("goAbroadInformationHRToOA")).add(_oper);
    }

    public GoAbroadOneServiceSoapBindingSkeleton() {
        this.impl = new vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadOneServiceSoapBindingImpl();
    }

    public GoAbroadOneServiceSoapBindingSkeleton(vo.oa.goAbroad.talentbase.neusoft.com.GoAbroadAction impl) {
        this.impl = impl;
    }
    public vo.oa.goAbroad.talentbase.neusoft.com.java.GoAbroadVO goAbroadInformationHRToOA(java.lang.String goAbroadInformationHRToOA) throws java.rmi.RemoteException
    {
        vo.oa.goAbroad.talentbase.neusoft.com.java.GoAbroadVO ret = impl.goAbroadInformationHRToOA(goAbroadInformationHRToOA);
        return ret;
    }

}
