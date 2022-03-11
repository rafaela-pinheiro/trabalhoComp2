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
1. Avaliar páginas (sabendo os temas delas)
- Contador de total de palavras da página
- Mapa/Dicionário de palavras lidas e suas frequências
- Armazenar em um arquivo as palavras mais frequentes
    - Sabemos que as páginas armazenadas se relacionam com o tema dito
- As palavras encontradas em páginas novas serão comparadas com as palavras nesses arquivos 
- Descobrir a porcentagem de palavras relacionadas ao tema em relação ao total de palavras (para usar para determinar se uma página desconhecida tem a ver com um dos 3 temas ou não)

2. Avaliar páginas desconhecidas
- Conjunto de palavras
- Cada palavra lida será relacionada a um dos três temas (ou a nenhum deles)
    - Três contadores, um para cada tema
- Ao final, se mais de x% (a calcular (média das frequencias de cada site que vamos testar)) das palavras do site forem relacionados a um dos temas, o site é sobre esse tema
- Substituir resposta pelo tema da página 
- Armazenar o último tema mostrado para poder substitui-lo pelo próximo 
- lista de tags html --> 'for' com select(tagAtual)
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
