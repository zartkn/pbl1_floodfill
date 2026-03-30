# Flood Fill com Pilha e Fila em Java

Projeto desenvolvido para a disciplina de **Resolução de Problemas Estruturados em Computação**, com o objetivo de implementar o algoritmo **Flood Fill** utilizando **estruturas próprias de Pilha e Fila**, seguindo os princípios de **Programação Orientada a Objetos**. O trabalho realiza o preenchimento de pixels conectados em uma imagem `.png`, gerando também os frames da execução para visualização da animação do processo.

## Integrantes

- Edmund Soares de Sousa
- Lucas Azzolin Haubmann
- Adrian Antonio de Souza Gomes

## Sobre o projeto

O algoritmo **Flood Fill** é utilizado para preencher áreas conectadas de uma imagem a partir de um ponto inicial, de forma semelhante à ferramenta “balde de tinta” presente em editores de imagem. Neste projeto, a implementação foi feita em **Java**, utilizando leitura e manipulação de imagens com `File` e `BufferedImage`, conforme solicitado no enunciado.

## Conceitos de POO aplicados

### Encapsulamento
Presente nos atributos `private` e nos métodos `get/set` da classe `Pixel`.

### Polimorfismo
Presente nas classes genéricas `Node<T>`, `Stack<T>` e `Queue<T>`, que permitem reutilizar a lógica das estruturas de dados para diferentes tipos de objeto, sem limitar a implementação apenas a números ou tipos primitivos.

## Estruturas utilizadas

O projeto foi desenvolvido com estruturas próprias, sem uso das implementações prontas do Java, atendendo ao requisito da atividade. Entre elas:

- `Node<T>`
- `Stack<T>`
- `Queue<T>`
- `Pixel`

## Funcionamento do algoritmo

O programa recebe uma imagem `.png` como entrada e realiza o preenchimento a partir de um ponto inicial. Durante a execução:

1. a cor base do pixel inicial é armazenada
2. o pixel inicial é inserido em uma **Pilha** ou **Fila**
3. o algoritmo percorre os pixels vizinhos laterais
4. cada posição é validada para evitar estouro de limite da matriz
5. somente pixels com a mesma cor de fundo inicial são pintados
6. a cada modificação, um novo frame pode ser salvo para compor a animação

Ao final, o programa gera a imagem preenchida e os registros visuais da execução.

## Saída do projeto

Depois de executar o código, os frames gerados podem ser encontrados dentro da pasta:

```bash
frames
```

Essa pasta fica na **raiz do projeto**.

## Tecnologias utilizadas

- Java
- File
- BufferedImage
- Programação Orientada a Objetos
- Estruturas de dados próprias

## Objetivo acadêmico

Este trabalho foi desenvolvido para demonstrar, na prática:

- manipulação de imagens em Java
- implementação manual de estruturas de dados
- aplicação de lógica de preenchimento por vizinhança
- organização do código com boas práticas de orientação a objetos

## Observações

O projeto segue a proposta acadêmica de implementar o Flood Fill de forma não recursiva ou com uso de repetição, utilizando obrigatoriamente Pilha e Fila como formas de armazenamento dos pixels durante a execução.

## Como executar

1. Clone este repositório:
```bash
git clone [URL_DO_REPOSITORIO]
```

2. Abra o projeto em sua IDE Java de preferência.

3. Execute a classe principal do projeto.

4. Após a execução:
   - verifique a imagem de saída gerada
   - acesse a pasta `frames` na raiz do projeto para visualizar os frames da animação

## Licença

Projeto desenvolvido para fins acadêmicos.
