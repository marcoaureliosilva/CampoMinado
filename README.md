# Campo Minado em Java 17

Este é um projeto de um jogo de Campo Minado desenvolvido em Java 17, utilizando o gerenciador de dependências Maven e a estrutura de testes JUnit. 
O objetivo é fornecer uma implementação simples e funcional do jogo clássico.

## Funcionalidades

- O jogo de Campo Minado é jogado em um tabuleiro retangular, onde os jogadores devem descobrir células vazias sem acertar as minas.
- O tabuleiro é gerado aleatoriamente a cada partida, com tamanho personalizável.
- Os jogadores podem marcar as células suspeitas de conterem minas com um #.
- O jogo termina quando todas as células vazias forem descobertas ou quando uma mina for acionada.
- O jogo exibe o estado do tabuleiro após cada jogada.
- Ao final do jogo, é exibida uma mensagem indicando a vitória ou a derrota

## Layout
![Campo Minado 1](https://github.com/marcoaureliosilva/CampoMinado/blob/main/CampoMinado01.png)

![Campo Minado 2](https://github.com/marcoaureliosilva/CampoMinado/blob/main/CampoMinado02.png)

## Requisitos

- Java 17
- Maven

## Configuração do Ambiente

1. Certifique-se de ter o Java 17 instalado em seu sistema. Você pode verificar a versão instalada executando o seguinte comando no terminal:

```shell
java --version
```
2. Certifique-se de ter o Maven instalado em seu sistema. Você pode verificar a versão instalada executando o seguinte comando no terminal:

```shell
mvn --version
```

## Como Executar o Jogo

1. Clone este repositório para o seu ambiente local.

```shell
git clone https://github.com/marcoaureliosilva/CampoMinado.git
```

2. Navegue até o diretório do projeto.
```shell
cd CampoMinado
```

3. Compile o projeto utilizando o Maven.
```shell
mvn compile
```

4. Execute o jogo.
```shell
mvn exec:java -Dexec.mainClass="org.marco.CampoMinado"
```

## Como Executar os Testes

O projeto utiliza a estrutura de testes JUnit para garantir a qualidade do código. Para executar os testes, siga as etapas abaixo:

1. Navegue até o diretório do projeto.
```shell
cd CampoMinado
```

2. Execute os testes utilizando o Maven.
```shell
mvn test
```
Os testes serão executados e você poderá ver o resultado no terminal.

## Licença
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE)

# Autor

Marco Aurélio da Silva

https://www.linkedin.com/in/maraureliosilva

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões para melhorar o jogo da velha, sinta-se à vontade para abrir uma issue ou enviar um pull request. Farei o possível para analisar e incorporar suas contribuições. 
