package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import resources.JsonDataReaderWriter;

public class Testing {
	JsonDataReaderWriter json;

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		JsonDataReaderWriter json=new JsonDataReaderWriter();;

		String str=json.readdata();
		System.out.println(str);
		

	}

}
