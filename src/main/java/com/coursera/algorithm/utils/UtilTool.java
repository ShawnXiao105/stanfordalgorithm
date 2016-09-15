package com.coursera.algorithm.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilTool {
	public static List<Integer> readDataFromFile(String fileName)
	{
		List<Integer> result = new ArrayList<Integer>();
		BufferedReader in = null;
		try
		{
			in= new BufferedReader(new FileReader(fileName));

			String line;
			while((line = in.readLine()) != null)
			{
			   int foo = Integer.parseInt(line);
			   result.add(foo);
			}
		}
		catch(IOException e)
		{
		
		}
		finally
		{
			if(in!=null)
			{
				try
				{in.close();}
				catch(IOException e)
				{}
			}				
		}
		return result;
	}
}
