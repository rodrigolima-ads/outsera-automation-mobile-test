# PROVA TECNICA AUTOMAÇÃO DE TESTES MOBILE


## Automação de testes
Projeto com objetivo de demostrar as minhas habilidades com automação de testes mobile, utilizando tecnicas e boas práticas de testes com o uso do servidor Appium e ‘Framework’ Selenium.<br>
O projeto possui uma arquitura Page Object Pattern possibilitando uma melhor organizaçâo do teste separando os locators do codigo.<br>.


https://gitlab.com/rodrigo.qa/outsera-automation-mobile-test


### Pré-condições

Para execução do projeto, é necessário possuir as seguintes instalações na máquina:
- Java 17 ou superior;
- Maven


## Tecnologias e Bibliotecas
- Java 17
- Maven
- Appium
- [TestNG](https://testng.org/doc/)



### Executando o projeto
Após atender as pré-condições, executar o comando `mvn install` para baixar as dependências;

Para executar os testes, executar o comando: `mvn test`.

Também é possível executar por tags: `mvn test  -DincludeTags="<tag(s)>"`

### Tags

- financiamento


### Estrutura dos testes

#### Main
- **setup:** Contém as configurações basicas do teste, todas classes de Teste devem extende-la;
- **utils:** Contém classes auxiliares que ajudam na construção dos testes, constantes, reporte etc.


#### Test
- **action:** Contém os metodos responsaveis pela iteração com a página.
- **screen:** Contém os locators
- **testes:** Contém as classes de testes

#### Relatório HTML e TestNG

Após a execução dos testes é possível gerar o relatório personalizado feito em html o mesmo contem todos os passos<br> 
evidenciados por imagems e descrição dos passos, disso a automação possue um relatorio com o dashboard referente ao TestNG.<br>
