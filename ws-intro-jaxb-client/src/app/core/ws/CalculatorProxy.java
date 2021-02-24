package app.core.ws;

public class CalculatorProxy implements app.core.ws.Calculator {
  private String _endpoint = null;
  private app.core.ws.Calculator calculator = null;
  
  public CalculatorProxy() {
    _initCalculatorProxy();
  }
  
  public CalculatorProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculatorProxy();
  }
  
  private void _initCalculatorProxy() {
    try {
      calculator = (new app.core.ws.CalculatorServiceLocator()).getCalculatorPort();
      if (calculator != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculator)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculator != null)
      ((javax.xml.rpc.Stub)calculator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public app.core.ws.Calculator getCalculator() {
    if (calculator == null)
      _initCalculatorProxy();
    return calculator;
  }
  
  public java.lang.String greetStudent(app.core.ws.Student arg0) throws java.rmi.RemoteException{
    if (calculator == null)
      _initCalculatorProxy();
    return calculator.greetStudent(arg0);
  }
  
  public int sum(int arg0, int arg1) throws java.rmi.RemoteException{
    if (calculator == null)
      _initCalculatorProxy();
    return calculator.sum(arg0, arg1);
  }
  
  
}