package com.trabalho.trabalhofinal;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.io.FileReader;
import java.io.BufferedReader;

@ApplicationPath("/api")
public class TemaApplication extends Application {
    public static final String PONTUACAO = "[!\\\"#$%&'()*+,-./:;<=>?@\\\\[\\\\]^_`{|}~]";

    protected static String extraiHTML(String url) throws IOException {
        // ArrayList<String> tags = new ArrayList<>(Arrays.asList("h1", "h2", "h3",
        // "h4", "p", "title", "a", "span"));

        String[] stopWords = { "de", "a", "o", "que", "e", "do", "da", "em", "um", "para", "é", "com", "não", "uma",
                "os", "no", "se", "na", "por", "mais", "as", "dos", "como", "mas", "foi", "ao", "ele", "das", "tem",
                "à", "seu", "sua", "ou", "ser", "quando", "muito", "há", "nos", "já", "está", "eu", "também", "só",
                "pelo", "pela", "até", "isso", "ela", "entre", "era", "depois", "sem", "mesmo", "aos", "ter", "seus",
                "quem", "nas", "me", "esse", "eles", "estão", "você", "tinha", "foram", "essa", "num", "nem", "suas",
                "meu", "às", "minha", "têm", "numa", "pelos", "elas", "havia", "seja", "qual", "será", "nós", "tenho",
                "lhe", "deles", "essas", "esses", "pelas", "este", "fosse", "dele", "tu", "te", "vocês", "vos", "lhes",
                "meus", "minhas", "teu", "tua", "teus", "tuas", "nosso", "nossa", "nossos", "nossas", "dela", "delas",
                "esta", "estes", "estas", "aquele", "aquela", "aqueles", "aquelas", "isto", "aquilo", "estou", "está",
                "estamos", "estão", "estive", "esteve", "estivemos", "estiveram", "estava", "estávamos", "estavam",
                "estivera", "estivéramos", "esteja", "estejamos", "estejam", "estivesse", "estivéssemos", "estivessem",
                "estiver", "estivermos", "estiverem", "hei", "há", "havemos", "hão", "houve", "houvemos", "houveram",
                "houvera", "houvéramos", "haja", "hajamos", "hajam", "houvesse", "houvéssemos", "houvessem", "houver",
                "houvermos", "houverem", "houverei", "houverá", "houveremos", "houverão", "houveria", "houveríamos",
                "houveriam", "sou", "somos", "são", "era", "éramos", "eram", "fui", "foi", "fomos", "foram", "fora",
                "fôramos", "seja", "sejamos", "sejam", "fosse", "fôssemos", "fossem", "for", "formos", "forem", "serei",
                "será", "seremos", "serão", "seria", "seríamos", "seriam", "tenho", "tem", "temos", "tém", "tinha",
                "tínhamos", "tinham", "tive", "teve", "tivemos", "tiveram", "tivera", "tivéramos", "tenha", "tenhamos",
                "tenham", "tivesse", "tivéssemos", "tivessem", "tiver", "tivermos", "tiverem", "terei", "terá",
                "teremos", "terão", "teria", "teríamos", "teriam" };

        Set<String> setStopWords = new HashSet<>(Arrays.asList(stopWords));
        try {
            Document doc = Jsoup.connect(url).get();
        } catch (Exception e) { // tentar ajeitar esse erro
            throw new IllegalArgumentException("URL inválida");
        }
        Document doc = Jsoup.connect(url).get();
        String txt = doc.body().text();
        String[] txt_separado = txt.split(" ");
        Set<String> setPalavras = new HashSet<>();
        for (int i = 0; i < txt_separado.length; i++) {
            if (setStopWords.contains(txt_separado[i]) == false) {
                setPalavras.add(txt_separado[i].toLowerCase());
            }
        }
        setPalavras = trataTexto(setPalavras);
        String tema = contarFreq(setPalavras);
        // html += "<p>" + tema + "</p>";
        return tema;
    }

    protected static Set<String> trataTexto(Set<String> setPalavras) {
        Set<String> setPalavrasTratadas = new HashSet<>();
        String aux = "";
        for (String s : setPalavras) {
            aux = s.replaceAll(TemaApplication.PONTUACAO, "");
            setPalavrasTratadas.add(aux);
        }
        return setPalavrasTratadas;
    }

    public static Set<String> palavrasTemas(String tema) throws IllegalArgumentException {
        Set<String> palavras = new HashSet<>();
        // String filepath = tema;
        try {
            String filepath = "C:\\Users\\rafin\\Documentos\\UFRJ\\2oPeriodo\\Computacao2\\trabalhoFinal\\src\\main\\java\\com\\trabalho\\" + tema + ".txt";
            //String filepath = "../" + tema + ".txt";

            // C:\Users\rafin\Documentos\UFRJ\2oPeriodo\Computacao2\trabalhoFinal\src\main\java\com\trabalho\trabalhofinal\culinaria.txt

            FileReader file = new FileReader(filepath);
            BufferedReader reader = new BufferedReader(file);
            String linha = reader.readLine(); // regras.
            while (linha != null) {
                palavras.add(linha);
                linha = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            throw new IllegalArgumentException("Arquivo não pode ser lido!");
        }

        return palavras;
    }

    public static String contarFreq(Set<String> setPalavrasTratadas) {
        String tema = "";
        Set<String> palavrasCulinaria = new HashSet<>(palavrasTemas("culinaria"));
        Set<String> palavrasEsporte = new HashSet<>(palavrasTemas("esporte"));
        Set<String> palavrasProgramacao = new HashSet<>(palavrasTemas("programacao"));
        int culinaria = 0;
        int programacao = 0;
        int esporte = 0;

        for (String s : setPalavrasTratadas) {
            if (palavrasCulinaria.contains(s)) {
                culinaria++;
            }
            if (palavrasEsporte.contains(s)) {
                esporte++;
            }
            if (palavrasProgramacao.contains(s)) {
                programacao++;
            }
        }
        if ((culinaria > programacao) && (culinaria > esporte)) {
            tema = "A página é sobre <b>culinária</b>";
        } else if ((esporte > programacao) && (esporte > culinaria)) {
            tema = "A página é sobre <b>esporte</b>";
        } else if ((programacao > esporte) && (programacao > culinaria)) {
            tema = "A página é sobre <b>programação</b>";
        } else {
            tema = "Não foi possível determinar o tema. Site ambíguo.";
        }
        return tema;
    }
}