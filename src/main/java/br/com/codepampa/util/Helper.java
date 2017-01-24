/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codepampa.util;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static final String pathUploadFile = "/resources/uploads/";
    public static final String EMAILORIGEM = "contato@codepampa.com.br";

    public static Date stringParaData(String data) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(data);
        return date;
    }

    public static String DataParaString(Date data) throws ParseException {
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result = out.format(data);
        return result;
    }

    //TODO verificar se com o navegador em PT-BR dá erro...
    public static Date inverterData(String data) throws ParseException {
        String temp[] = data.split("-");
        String dataInvetida = temp[2] + "/" + temp[1] + "/" + temp[0];
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(dataInvetida);
        return date;
    }


    public static String pathUploadInServer(String path) {
        return path.trim().replace("/", "\\");
    }

    public static List<Part> getAllParts(Part part) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getParts().stream().filter(p -> part.getName().equals(p.getName())).collect(Collectors.toList());
    }

    public static String returnPathArquivo(Part part) {
        return pathUploadFile + LocalDateTime.now()
                + "." + part.getContentType()
                .substring((part.getContentType().lastIndexOf("/")+1), part.getContentType().length());
    }

}
