<h1 align="center">
    Trabalho final de Computação II (2021.2)
</h1>

---

## 💡 Objetivo

Avaliar o conteúdo de uma página web e dizer se ela é de Esportes, Culinária ou de Programação. 

---
## ✅ Feito
- [x] Esquema de raspagem de dados
- [x] Método para classificação de cada página
- [x] Listagem de palavras mais frequentes
- [x] Implementação das páginas e sua lógica
- [x] Estilização das páginas
- [x] Testes
---
## 📖 Regras
Criamos 3 Sets de palavras ("culinaria", "programacao" e "esporte"), e acrescentamos palavras relacionadas a esses temas.
Avaliando páginas desconhecidas:
- As palavras lidas são armazenadas em um Set
- Cada palavra lida será comparada com as palavras dos 3 Sets de tema. Então, será relacionada a um desses temas (ou a nenhum deles)
- Existem três contadores, um para cada tema. A cada palavra do site que se relacione a um tema X, o contador X será incrementado em 1
- Ao final, se o contador do tema X for maior do que os outros dois, determinamos que o site é sobre o tema X
- Se dois ou mais contadores forem iguais, dizemos que não podemos determinar o tema
---
### Pré-requisitos

É necessário ter instalado na sua máquina para execução desse projeto:
- <a href='https://javaee.github.io/glassfish/download'>glassfish 4.0</a>
- <a href='https://jsoup.org/'>Jsoup</a>

### Executando

Instalando as dependências, 'biuldar' basta dar um deploy no .war gerado :
```
$ asadmin deploy ...\trabalhoFinal-1.0-SNAPSHOT.war
```
---
## 👨‍💻 Desenvolvedores
### Rafaela Pinheiro🙊([@rafaela-pinheiro](https://github.com/rafaela-pinheiro))
### Mariana Furriel🙉([@marianafurriel](https://github.com/marianafurriel))
### Gabriel Amaral🙈([@amaral220x](https://github.com/amaral220x)) 

---
