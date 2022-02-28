package com.trabalho.trabalhofinal;
import org.jsoup.Jsoup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@Path("/index")
public class IndexResource {
    @GET
    @Produces("text/html")
    public String index() throws IOException {
        //Document doc = Jsoup.connect(url).get();
        String html = "<html><head><meta charset=\"UTF-8\"><title>Tipo de conteúdo de URL</title></head>";
        String tag = "p";
        Document doc = Jsoup.connect("https://ge.globo.com/futebol/times/fluminense/").get();
        Elements elementosTag = doc.select(tag);
        html += "<h2>Elementos com a tag " + tag + "</h2>";
        //System.out.println("Elementos com a tag h:");

        for (Element el : elementosTag) {
            //System.out.println(el.text());
            html += "<p>" + el.text() +"</p>";
        }
        return html;
    }
}