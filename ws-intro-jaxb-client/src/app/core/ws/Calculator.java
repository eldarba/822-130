/**
 * Calculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package app.core.ws;

public interface Calculator extends java.rmi.Remote {
    public java.lang.String greetStudent(app.core.ws.Student arg0) throws java.rmi.RemoteException;
    public int sum(int arg0, int arg1) throws java.rmi.RemoteException;
}
