# ExercicioExtra

Projeto Maven criado automaticamente com Java 25 e JUnit 5.

## Requisitos

- Java 25
- Maven

## Regras implementadas

- O INSS corresponde a 10% do salário base.
- Técnicos recebem adicional de 0%, 5% ou 15% conforme as categorias 1, 2 ou 3.
- Professores recebem o valor da hora multiplicado pela carga horária semanal.
- Pesquisadores recebem o valor da hora multiplicado pela soma das horas semanais e de pesquisa.
- A aplicação lista três funcionários de cada tipo e apresenta as quantidades e os totais solicitados.

## Como compilar

```bash
mvn compile
```

## Como executar

```bash
mvn exec:java -Dexec.mainClass="com.exemplo.App"
```

## Como executar os testes

```bash
mvn test
```

## Como gerar o pacote

```bash
mvn package
```
