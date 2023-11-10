# Padrões de projeto em Java

Alguns exemplos de padrões de projetos feito na linguagem java
para aprendizado.

## Comportamental

### Strategy

O Strategy é um padrão de projeto comportamental que permite que você defina uma família de algoritmos, coloque-os em classes separadas, e faça estes objetos serem intercambiáveis
[refactoring.guru](https://refactoring.guru/pt-br/design-patterns/strategy).

Este padrão tem dois componentes principais: a interface Strategy e a classe Context. A interface Strategy declara o tipo de algoritmo, que pode ser uma classe abstrata ou uma interface.

***Exemplo***

Um exemplo desse padrão de projeto em java está disponível [aqui](https://github.com/andersonhsporto/design-patterns-java/tree/main/src/strategy) onde foi implementado uma strategy
para algoritmos de ordenação.

## Criacional

### Builder

O Builder é um padrão criacional muito similar ao método factory este organiza a criação
do objetos em etapas fora de sua própria classe e mova ele para objetos separados chamados builders. 

***Exemplo***

Um exemplo desse padrão de projeto em java está disponível [aqui](https://github.com/andersonhsporto/design-patterns-java/tree/main/src/builder).



## Estrutural

### Adapter

O padrão Adapter permite que você crie uma classe de meio termo que serve como um tradutor entre seu código e a classe antiga, uma classe de terceiros, ou qualquer outra classe com uma interface estranha.

***Exemplo***

Um exemplo desse padrão de projeto em java está disponível [aqui](https://github.com/andersonhsporto/design-patterns-java/tree/main/src/adapter) onde neste foi implementado
um adapter para dois sistemas de coordenadas distintos.

## Referências

- [refactoring.guru](https://refactoring.guru/pt-br/design-patterns/strategy) - Strategy
- [refactoring.guru](https://refactoring.guru/pt-br/design-patterns/builder) - Builder
- [refactoring.guru](https://refactoring.guru/pt-br/design-patterns/adapter) - Adapter
- [Java67](https://www.java67.com/2014/12/strategy-pattern-in-java-with-example.html) - How to use Strategy Design Pattern in Java
- [javarevisited](https://javarevisited.blogspot.com/2020/05/top-10-educative-courses-for-programmers.html#axzz8IV7nH73K) - Builder design pattern in Java
- [javarevisited](https://javarevisited.blogspot.com/2016/08/adapter-design-pattern-in-java-example.html#axzz8IgC9exUn) - Adapter design pattern in Java