package com.trabalho.trabalhofinal;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@ApplicationPath("/api")
public class TemaApplication extends Application {
    public static final String PONTUACAO = "[!\\\"#$%&'()*+,-./:;<=>?@\\\\[\\\\]^_`{|}~]";

    protected static void extraiHTML() throws IOException {
        ArrayList<String> tags = new ArrayList<>(Arrays.asList("h1", "h2", "h3", "h4", "p", "title", "a", "span"));
        Document doc = Jsoup.connect("http://help.websiteos.com/websiteos_br/example_of_a_simple_html_page.htm").timeout(5000).get();
        //System.out.println(doc)

        Elements elementosTag;
        /*System.out.println("Elementos com a tag body:");
        elementosTag = doc.select("body");
        */

        /*for(String t : tags){
            elementosTag = doc.select(t);
            System.out.println("Elementos com a tag " + t + ":");
            for (Element el : elementosTag) {
                System.out.println(el.text());
            }
        }*/

        String txt = doc.body().text();
        String[] txt_separado = txt.split(" ");
        int freq = 0;
        for (int i = 0; i < txt_separado.length; i++) {
            if (txt_separado[i].toLowerCase().contains("página"))
                freq++;
            System.out.println(txt_separado[i]);
        }
        System.out.println("quantidade de vezes: " + freq);

    }

    protected static String trataTexto (String textoNaoTratado){
        String textoTratado = textoNaoTratado.toLowerCase();
        textoTratado = textoTratado.replaceAll(TemaApplication.PONTUACAO, "");

        return textoTratado;
    }

}