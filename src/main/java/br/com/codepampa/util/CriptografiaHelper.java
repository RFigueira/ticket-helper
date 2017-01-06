package br.com.codepampa.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriptografiaHelper{

    public static String getCriptografada(String senha) {
        //Irá guardar a senha criptografada.
        String senhaCripto = "";
        
        try {            
            
            /**
            *  @Author  Carlos Emilio
            *  Obtém uma instância de MessaDigest, classe responsável por gerenciar algoritmos de criptografia.
            *    Neste caso, usaremos o algoritmo MD5 para geração de um código hash para senha.
            */
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            /*   
            *   O método digest() de MessageDigest é o responsável por gerar um número inteiro grande o qual
            *   representa o código hash. O método retorna um vetor de bytes o qual é passado para o construtor
            *   de BigInteger como segundo parâmetro (magnitude). O primeiro parâmetro representa o sinal, que
            *   neste caso deve indicar que o vetor de bytes representa um número inteiro.
            */
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            
            //Convertemos o número gerado em uma String representando o número em Hexadecimal.
            senhaCripto = hash.toString(16);
            
        } catch (NoSuchAlgorithmException ex) {
            /* 
            *   A classe Logger é utilizada para registro de atividades da aplicação. Neste caso, registra
            *   e mostra no console a mensagem de erro originada na exceção.
            */
            Logger.getLogger(CriptografiaHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //O método retorna a senha criptografada na forma de uma String.
        return senhaCripto;
    }

}
