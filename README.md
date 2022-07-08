# beer_api_dio
Bootcamp Digital Innovation & TQI: Desenvolvimento de testes unitários para validar uma API REST de gerenciamento de estoques de cerveja.

A live Coding com Rodrigo Peleias, teve o objetivo de ensinar a testar unitariamente uma API REST 
para o gerenciamento de estoques de cerveja. Assim foi construído testes unitários de validação do 
sistema de gerenciamento de estoque de cerveja, com Spring Boot, explorando os principais conceitos e 
vantagens de criar testes unitários com JUnit e Mockito. Também desenvolvido funcionalidades na API aplicando TDD.

Ferramentas utilizadas:

Java 11; Maven; Spring Boot (última versão estável);

GIT/GITHUB para versionamento; 

Frameworks: 

JUnit, Mockito e Hamcrest

[Palheta de atalhos de comandos do Intellij](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf/) 💻 - Working on it.


Em suma, no desafio foi explorado os seguintes conceitos e implementados testes de validação:

•	Entendimento e importância sobre testes unitários;

•	Entendimento dos principais frameworks para testes unitários;

•	Desenvolvido testes unitários para validação de funcionalidades básicas: 

       Na camada de Service:       
        . Criação, listagem, consulta por nome e exclusão 
        
       Na camada de Controller:
        . Criação, listagem, consulta por nome e exclusão 





Utilizando o conceito de TDD foi implementado também teste para incremento/decremento do número de cerveja ao estoque através do verbo HTTP PATH.

Quantidade estoque antes de executar o método de atualização parcial:

{

"name": "Colorado appia",

"brand": "Colorado",

"max": 20,

"quantity": 4,

"type": "LAGER"

}

Quantidade estoque após executar o método de atualização parcial:
PATCH: http://localhost:8090/api/v1/beers/1/increment

{

"quantity": 2        //quantidade adicionada

}

Resultado:

 {
 
    "id": 1,
    
    "name": "Colorado appia",
    
    "brand": "Colorado",
    
    "max": 20,
    
    "quantity": 6,
    
    "type": "LAGER"
    
}

Melhoria realizada

Como desafio implementei o método de DECREMENTO de cerveja  	

Estoque após a implementação do método:
PATCH: http://localhost:8090/api/v1/beers/1/decrement 

{

"quantity": 4       //quantidade decrementada 

}

Resultado:

{

    "id": 1,
    
    "name": "Colorado appia",
    
    "brand": "Colorado",
    
    "max": 20,
    
    "quantity": 2,          //quantidade após decremento
    
    "type": "LAGER"
}
