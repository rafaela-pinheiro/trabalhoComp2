package com.trabalho.trabalhofinal;

import org.jsoup.Jsoup;
import javax.ws.rs.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

@Path("/index")
public class IndexResource {
    @GET
    @Produces("text/html")
    public String index() throws IOException {
        String caminho = "C:\\Users\\rafin\\Documentos\\UFRJ\\2oPeriodo\\Computacao2\\trabalhoFinal\\src\\main\\java\\com\\trabalho\\index.html";
        /*Class cls = this.getClass();
        ProtectionDomain pDomain = cls.getProtectionDomain();
        CodeSource cSource = pDomain.getCodeSource();
        URL loc = cSource.getLocation();
        String caminho = loc.toString();
        caminho = caminho.replace("file:\\","");
        /*String caminho = "../index.html";


        File arquivoHTML = new File(caminho);*/

        File arquivoHTML = new File(caminho);
        String html = Jsoup.parse(arquivoHTML, "UTF-8").toString();
        
        return html;
    }
}