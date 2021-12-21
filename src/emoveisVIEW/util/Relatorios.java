/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emoveisVIEW.util;

import emoveisMODEL.Imovel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Wenderson
 */
public class Relatorios {
    
    public static void criarRelatorio(List<Imovel> imoveis) throws FileNotFoundException, IOException {
        
        String username = System.getProperty("user.name");
          
        String url = "C:\\Users\\" + username + "\\Documents\\E-moveis\\Relatorios";
        File diretorio = new File(url);
        diretorio.mkdirs();//retora true se criou com sucesso, retorna false se já tiver um diretorio 
        File file = new File(url + "\\planinha.xlsx");

        if (!file.exists()) {
            file.createNewFile();
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet linhas = workbook.createSheet("Imoveis");
        int numeroLinha = 0;
        for (Imovel i : imoveis) {
            Row linha = linhas.createRow(numeroLinha++);

            int celula = 0;

            Cell celtipo_imovel = linha.createCell(celula++);
            celtipo_imovel.setCellValue(i.getTipo_imovel());

            Cell celArea_imovel = linha.createCell(celula++);
            celArea_imovel.setCellValue(i.getArea_imovel());

            Cell celCor_imovel = linha.createCell(celula++);
            celCor_imovel.setCellValue(i.getCor_imovel());

            Cell celQtd_comodos_imovel = linha.createCell(celula++);
            celQtd_comodos_imovel.setCellValue(i.getQtd_comodos_imovel());

            Cell celEndereco_imovel = linha.createCell(celula++);
            celEndereco_imovel.setCellValue(i.getEndereco_imovel());

            Cell celValor_imovel = linha.createCell(celula++);
            celValor_imovel.setCellValue(i.getValor_imovel());

            String status = (i.isStatus_imovel() == true) ? "Disponivel" : "Indisponivel";

            Cell celStatus_imovel = linha.createCell(celula++);
            celStatus_imovel.setCellValue(status);

            Cell celId_imovel = linha.createCell(celula++);
            celId_imovel.setCellValue(i.getId_imovel());

        }

        try (FileOutputStream saida = new FileOutputStream(file)) {
            workbook.write(saida);
            saida.flush();
            java.awt.Desktop.getDesktop().open( new File(url + "\\planinha.xlsx") );
            System.out.println("Relatório Gerado");
        }

    }
    
}
