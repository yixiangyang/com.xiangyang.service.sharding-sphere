package com.yixiangyang.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

public class XMLWorkerDemo {
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\aa.txt");
		//读取内容
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = null;
		PdfWriter writer = new PdfWriter("F:\\tt.pdf");
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		while( (str=br.readLine())!=null ){
			System.out.println(str);
//			new Paragraph(Text)
			document.add(new Paragraph(str));
		}
		
		
		
		document.close();
	}
}
