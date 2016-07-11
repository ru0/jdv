package org.ruos.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class JavaSer {

	public static void main(String[] args) throws Exception {
				
	    // 将序列化对象写入文件object.db中
	    FileOutputStream fos = new FileOutputStream("C:\\Users\\chen\\workspace\\JavaSeri\\src\\org\\ruos\\test\\object.dat");
	    ObjectOutputStream os = new ObjectOutputStream(fos);
	    os.writeObject(new ShowInfo());
	    os.close();
	    
	 
	    // 从文件object.db中读取数据
	    FileInputStream fis = new FileInputStream("C:\\Users\\chen\\workspace\\JavaSeri\\src\\org\\ruos\\test\\object.dat");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	 
	    // 通过反序列化恢复对象obj
	    //在进行反序列话的时候，并没有调用类的构造方法
	    ShowInfo obj2 = (ShowInfo)ois.readObject();
	    obj2.setUserName("ruo");
	    obj2.showName();
	    ois.close();

	}
	
}
