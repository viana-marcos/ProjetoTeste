package com.teste.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.List;

import com.teste.model.Processamento;

public class FileUtil {
    public  void gerarArquivo(List<Processamento> processamentolist, String nomeArquivo) {
    	File dir = null;
    	dir = new File("c:\\processamento");
//		try {
//			dir = new File(getClass().getResource("com/teste/processamento/").toURI());
//		} catch (URISyntaxException e1) {			
//			e1.printStackTrace();
//		}    	
       
        File arq = new File(dir, nomeArquivo + ".txt");

        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            for (Processamento processamento : processamentolist) {
                printWriter.print("Id: " + processamento.getId() + ";");
                printWriter.print("Loja: " + processamento.getLoja() + ";");
                printWriter.print("Data: " + processamento.getData() + ";");
                printWriter.print("PDV: " + processamento.getPdv() + ";");
                printWriter.println("STATUS: " + processamento.getStatus());
               
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
