# Padrões de projeto em Java

Alguns exemplos de padrões de projeto feito na linguagem java
para aprendizado.

## Comportamental

### Strategy

O Strategy é um padrão de projeto comportamental que permite que você defina uma família de algoritmos, coloque-os em classes separadas, e faça os objetos deles intercambiáveis
[refactoring.guru](https://refactoring.guru/pt-br/design-patterns/strategy).

Este padrão tem dois componentes principais: a interface Strategy e a classe Context. A interface Strategy declara o tipo de algoritmo, que pode ser uma classe abstrata ou uma interface.

## Criacional

### Builder

O Builder é um padrão criacional muito similar ao método factory este organiza a criação
do objetos em etapas fora de sua própria classe e mova ele para objetos separados chamados builders. 

## Estrutural

### Adapter

O padrão Adapter permite que você crie uma classe de meio termo que serve como um tradutor entre seu código e a classe antiga, uma classe de terceiros, ou qualquer outra classe com uma interface estranha.

## Referências

- [refactoring.guru](https://refactoring.guru/pt-br/design-patterns/strategy) - Strategy
- [refactoring.guru](https://refactoring.guru/pt-br/design-patterns/builder) - Builder
- [refactoring.guru](https://refactoring.guru/pt-br/design-patterns/adapter) - Adapter
- [Java67](https://www.java67.com/2014/12/strategy-pattern-in-java-with-example.html) - How to use Strategy Design Pattern in Java
- [javarevisited](https://javarevisited.blogspot.com/2020/05/top-10-educative-courses-for-programmers.html#axzz8IV7nH73K) - Builder design pattern in Java
- [javarevisited](https://javarevisited.blogspot.com/2016/08/adapter-design-pattern-in-java-example.html#axzz8IgC9exUn) - Adapter design pattern in Java