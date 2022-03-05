package com.trabalho.trabalhofinal;

import javax.ws.rs.*;
import org.jsoup.Jsoup;
import java.io.File;
import java.io.IOException;

@Path("/resposta")
public class RespostaResource {
    @GET
    @Produces("text/html")
    public String resposta(@QueryParam("url") @DefaultValue("") String url) throws IOException {
        String caminho = "C:\\Users\\rafin\\Documentos\\UFRJ\\2oPeriodo\\Computacao2\\trabalhoFinal\\src\\main\\java\\com\\trabalho\\resposta.html";

        //String caminho = "../resposta.html";
        File arquivoHTML = new File(caminho);
        String html = Jsoup.parse(arquivoHTML, "UTF-8").toString();

        String resposta = TemaApplication.extraiHTML(url);
        html = html.replace("$resposta", resposta);
        return html;
    }
}