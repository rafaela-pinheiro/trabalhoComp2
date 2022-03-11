/*
--- TEMA 1 ---
Alunos:
Rafaela Pinheiro - 121038166
Gabriel Amaral - 121069963
Mariana Furriel - 121088886

--- INSTRUÇÕES ---
Utilizar Glassfish 4.1.2

*/

package com.trabalho.trabalhofinal;

import javax.ws.rs.*;
import java.io.IOException;

@Path("/resposta")
public class RespostaResource {
    @GET
    @Produces("text/html")
    public String resposta(@QueryParam("url") @DefaultValue("") String url) throws IOException {
        String html = "<!DOCTYPE html><html><head> <meta charset='utf-8'> <title>Resposta</title> <meta name='viewport' content='width=device-width, initial-scale=1'> <link rel='stylesheet' type='text/css' media='screen' href='main.css'> <link href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700\" rel=\"stylesheet\"><link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.4.1/css/all.css"+"\"integrity=\"sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz\" crossorigin=\"anonymous\"></head><style>html, body { display: flex; justify-content: center; height: 100%; } html{ width: 100%; height: 100%; position: absolute; background: linear-gradient(45deg,#F17C58, #E94584, #24AADB , #27DBB1,#FFDC18, #FF3706); background-size: 600% 100%; animation: gradient 16s linear infinite; animation-direction: alternate; } @keyframes gradient { 0% {background-position: 0%} 100% {background-position: 100%} } body, div, h1, h2, form, input, p { padding: 0; margin: 0; outline: none; font-family: Roboto, Arial, sans-serif; font-size: 16px; color: #fff; } h1 { padding: 10px 0; font-size: 32px; font-weight: 300; text-align: center; } p { font-size: 15px; text-align: center; } hr { color: #fff; opacity: 0.3; } .main-block { max-width: 340px; min-width: 220px; padding: 10px 0; margin: auto; border-radius: 5px; border: solid 1px #2b3445; box-shadow: 1px 2px 5px rgba(0,0,0,.31);  background: #2b3445; width: 100px; } .btn-block { margin-top: 10px; text-align: center; } button { width: 85%; padding: 10px 0; margin: 10px auto; border-radius: 5px;  border: none; background: #1c87c9; font-size: 14px; font-weight: 600; color: #fff; } button:hover { background: #278fd2; cursor: pointer; }</style><body> <div class=\"main-block\">  <p>$resposta</p>  <div class=\"btn-block\">   <a href=\"index\"><button>Voltar</button></a>  </div> </div></body></html>";

        String resposta = TemaApplication.extraiHTML(url);
        html = html.replace("$resposta", resposta);
        return html;
    }
}
