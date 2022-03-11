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

@Path("/index")
public class IndexResource {
    @GET
    @Produces("text/html")
    public String index() throws IOException {
        String html = "<!DOCTYPE html><html><head><meta charset='utf-8'><title>Descobrindo o tema da página</title>"
                +
                "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
                "<link href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700\" rel=\"stylesheet\">" +
                "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.4.1/css/all.css\"" +
                "\"integrity=\"sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz\"crossorigin=\"anonymous\">"
                +
                "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"></head>" +
                "<style>html, body {display: flex;justify-content: center;height: 100%;}" +
                "html{width: 100%;height: 100%;position: absolute;background: linear-gradient(45deg,#F17C58, #E94584, #24AADB , #27DBB1,#FFDC18, #FF3706);"
                +
                "background-size: 600% 100%;animation: gradient 16s linear infinite;animation-direction: alternate;}" +
                "@keyframes gradient {0% {background-position: 0%}100% {background-position: 100%}}" +
                "body, div, h1, form, input, p { padding: 0;margin: 0;outline: none;font-family: Roboto, Arial, sans-serif;font-size: 16px;color: #fff;}"
                +
                "h1 {padding: 10px 0;font-size: 32px;font-weight: 300;text-align: center;}p {font-size: 15px;text-align: center;}"
                +
                "hr {color: #fff;opacity: 0.3;}.main-block {max-width: 340px; min-height: 220px; padding: 10px 0;margin: auto;"
                +
                "border-radius: 5px;border: solid 1px #2b3445;box-shadow: 1px 2px 5px rgba(0,0,0,.31); background: #2b3445;}"
                +
                "form {margin: 0 30px;}input[type=radio] {display: none;}label#link-icon {margin: 0;border-radius: 5px 0 0 5px;}"
                +
                "input[type=text] {width: calc(100% - 57px);height: 36px;margin: 13px 0 0 -5px;padding-left: 10px; border-radius: 0 5px 5px 0;"
                +
                "border: solid 1px #cbc9c9;box-shadow: 1px 2px 5px rgba(0,0,0,.09); background: #fff;color: #202731;}" +
                "input[type=password] {margin-bottom: 15px;}#link-icon {display: inline-block;padding: 9.3px 15px;box-shadow: 1px 2px 5px rgba(0,0,0,.09);"
                +
                "background: #1c87c9;color: #fff;text-align: center;}.btn-block {margin-top: 10px;text-align: center;}"
                +
                "button {width: 100%;padding: 10px 0;margin: 10px auto;border-radius: 5px; border: none;background: #1c87c9;font-size: 14px;font-weight: 600;color: #fff;}"
                +
                "button:hover {background: #278fd2;cursor: pointer;}#github-icon{width: 30px;height: 30px;position: fixed;"
                +
                "top: 1%;left: 1%;z-index: 20;}.material-icons{font-size: 33px;color: black;}.popup{position: fixed;top: 1%;left: 50px;z-index: 20;text-display: none;}"
                +
                ".popup:hover{z-index: 30;cursor: default;}.popup span.show-popup-on-hover{display: none;}" +
                ".popup:hover span.show-popup-on-hover{display: block;position: absolute;font-size: 13px;line-height: 15px;top: 35px;"
                +
                "left: 20px;width: 500%;padding: 10px;border: 1px solid #fff;background-color: #202731;color: #fff;text-align: center;}"
                +
                "</style></head><body><a href=\"https://github.com/rafaela-pinheiro/trabalhoComp2\" target=\"_blank\" rel=\"noopener noreferrer\">"
                +
                "<img src=\"https://cdn-icons-png.flaticon.com/512/25/25231.png\" id=\"github-icon\"></a><div class=\"popup\">"
                +
                "<i class=\"material-icons\">lightbulb</i><span class=\"show-popup-on-hover\">Site feito pelos alunos Gabriel Amaral, Mariana Furriel e Rafaela Pinheiro</span>"
                +
                "</div><div class=\"main-block\"><h1>Adivinhar o tema da página</h1><form method=\"GET\" action=\"resposta\">"
                +
                "<label id=\"link-icon\"><i class=\"fa fa-link\"></i></label><input type=\"text\" name=\"url\" id=\"name\""
                + "placeholder=\"Link\" required/><div class=\"btn-block\"><button type=\"submit\">Analisar</button>" +
                "</div><hr><p>Descobriremos se a página é de Culinária, Esportes ou de Programação</p><hr></form></div></body></html>";

        return html;
    }
}
