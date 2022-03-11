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

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class TemaApplication extends Application {
    // Criação de Strings que serão importantes para o funcionamento do nosso
    // sistema.
    public static final String PONTUACAO = "[!\\\"#$%&'()*+,-./:;<=>?@\\\\[\\\\]^_`{|}~]";
    public static String[] stopWords = { "de", "a", "o", "que", "e", "do", "da", "em", "um", "para", "é", "com", "não",
            "uma", "os", "no", "se", "na", "por", "mais", "as", "dos", "como", "mas", "foi", "ao", "ele", "das", "tem",
            "à", "seu", "sua", "ou", "ser", "quando", "muito", "há", "nos", "já", "está", "eu", "também", "só", "pelo",
            "pela", "até", "isso", "ela", "entre", "era", "depois", "sem", "mesmo", "aos", "ter", "seus", "quem", "nas",
            "me", "esse", "eles", "estão", "você", "tinha", "foram", "essa", "num", "nem", "suas", "meu", "às", "minha",
            "têm", "numa", "pelos", "elas", "havia", "seja", "qual", "será", "nós", "tenho", "lhe", "deles", "essas",
            "esses", "pelas", "este", "fosse", "dele", "tu", "te", "vocês", "vos", "lhes", "meus", "minhas", "teu",
            "tua", "teus", "tuas", "nosso", "nossa", "nossos", "nossas", "dela", "delas", "esta", "estes", "estas",
            "aquele", "aquela", "aqueles", "aquelas", "isto", "aquilo", "estou", "está", "estamos", "estão", "estive",
            "esteve", "estivemos", "estiveram", "estava", "estávamos", "estavam", "estivera", "estivéramos", "esteja",
            "estejamos", "estejam", "estivesse", "estivéssemos", "estivessem", "estiver", "estivermos", "estiverem",
            "hei", "há", "havemos", "hão", "houve", "houvemos", "houveram", "houvera", "houvéramos", "haja", "hajamos",
            "hajam", "houvesse", "houvéssemos", "houvessem", "houver", "houvermos", "houverem", "houverei", "houverá",
            "houveremos", "houverão", "houveria", "houveríamos", "houveriam", "sou", "somos", "são", "era", "éramos",
            "eram", "fui", "foi", "fomos", "foram", "fora", "fôramos", "seja", "sejamos", "sejam", "fosse", "fôssemos",
            "fossem", "for", "formos", "forem", "serei", "será", "seremos", "serão", "seria", "seríamos", "seriam",
            "tenho", "tem", "temos", "tém", "tinha", "tínhamos", "tinham", "tive", "teve", "tivemos", "tiveram",
            "tivera", "tivéramos", "tenha", "tenhamos", "tenham", "tivesse", "tivéssemos", "tivessem", "tiver",
            "tivermos", "tiverem", "terei", "terá", "teremos", "terão", "teria", "teríamos", "teriam" };

    public static Set<String> setStopWords = new HashSet<>(Arrays.asList(stopWords));

    public static String[] culinaria = { "ovo", "ovos", "clara", "receita", "receitas", "provar", "prova", "comida",
            "comidas", "preparo", "gema", "tempero", "temperatura", "cozinhar", "cozinha", "gosto", "gostoso", "forno",
            "fogão", "xícara", "medida", "fermento", "vinagre", "azeite", "pimenta", "colher", "colheres", "leite",
            "manteiga", "margarina", "bolo", "pré-aquecer", "resfriar", "liquidificador", "batedeira", "garfo",
            "refratário", "travessa", "frango", "cebola", "cebolas", "limão", "limões", "laranja", "laranjas", "milho",
            "lata", "latas", "caixa", "caixas", "cozimento", "goiaba", "maçã", "banana", "manga", "uva", "açúcar",
            "xícara", "xícaras", "copo", "copos", "sopa", "fermento", "forma", "untada", "farinha", "assar",
            "condensado", "creme", "óleo", "frigideira", "fouet", "fuê", "salada", "agrião",
            "rúcula", "arroz", "culinária", "alimento", "gastronomia", "gastronomico", "food", "louça", "louças" };
    

    public static String[] esporte = { "jogo", "estádio", "jogador", "time", "tabela", "final", "semi", "quartas",
            "oitavas", "classificação", "eliminação", "prêmio", "campeão ", "campeonato", "torneio", "escalação",
            "treinador", "torcedor", "vencedor", "perdedor", "vence", "perde", "perdeu", "venceu", "empate", "gol",
            "futebol", "volei ", "basquete", "tenis", "ping pong", "boliche", "skate", "fadinha", "golfe", "areia",
            "praia", "campo", "gramado", "ponto", "esporte", "prática", "partida", "lesão ", "técnica", "contra",
            "cesta", "bola", "raquete", "derrota", "empate", "público", "torcida", "fluminense", "flamengo", "vasco",
            "botafogo", "cruzeiro", "atlético", "palmeiras", "são paulo ", "corinthians ", "santos", "bahia ",
            "vitória", "américa ", "portuguesa", "grêmio ", "internacional", "milan", "psg", "barcelona", "neymar",
            "messi", "suarez", "cristiano ", "ronaldo", "kane", "son", "tottenham ", "chelsea ", "arsenal",
            "manchester", "real ", "chute", "chuteira", "aposta", "asa", "técnico", "treino", "treinar" };

    public static String[] programacao = { "código", "python", "java", "html", "css", "html/css", "c", "c++", "c#",
            ".net", "windows", "linux", "script", "ide", "terminal", "comando", "index", "size", "length", "front",
            "back", "end", "git", "github", "js", "javascript", "py", "função", "feature", "build", "teste", "testar",
            "main ", "lua ", "laravel ", "servidor", "php", "clean", "documentação", "code", "vs", "intelij", "ide",
            "repetição", "loop", "for", "view", "form", "programação" };

    // Transformando em set para facilitar a comparação
    public static Set<String> setCulinaria = new HashSet<>(Arrays.asList(culinaria));
    public static Set<String> setEsporte = new HashSet<>(Arrays.asList(esporte));
    public static Set<String> setProgramacao = new HashSet<>(Arrays.asList(programacao));

    protected static String extraiHTML(String url) throws IOException {
        Document doc;
        try { // Abrindo o site e esperando algum erro
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            throw new IllegalArgumentException("URL inválida");
        }
        doc = Jsoup.connect(url).get();
        String txt = doc.body().text();
        String[] txt_separado = txt.split(" ");
        Set<String> setPalavras = new HashSet<>();
        for (int i = 0; i < txt_separado.length; i++) {
            if (setStopWords.contains(txt_separado[i]) == false) {
                setPalavras.add(txt_separado[i].toLowerCase()); // "Tratando" o texto para deixar tudo em lowercase
            }
        }
        setPalavras = trataTexto(setPalavras); // Agora sim tratando, retirando a "sujeira" das strings
        String tema = DescobreTema(setPalavras);

        return tema;
    }

    protected static Set<String> trataTexto(Set<String> setPalavras) {
        Set<String> setPalavrasTratadas = new HashSet<>();
        String aux;
        for (String s : setPalavras) {
            aux = s.replaceAll(TemaApplication.PONTUACAO, "");
            setPalavrasTratadas.add(aux);
        }
        return setPalavrasTratadas;
    }

    public static String DescobreTema(Set<String> setPalavrasTratadas) {
        String tema = "";
        int culinaria = 0;
        int programacao = 0;
        int esporte = 0;

        for (String s : setPalavrasTratadas) {
            if (setCulinaria.contains(s)) {
                culinaria++;
            }
            if (setEsporte.contains(s)) {
                esporte++;
            }
            if (setProgramacao.contains(s)) {
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
