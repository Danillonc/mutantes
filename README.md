# labdna
Repositório criado para hospedar os artefatos do algoritmo de analise de dnas

# Observação:
 - O diretório tmp/src foi uma estrutura criada apenas para atender o deploy da aplicação na paltaforma OpenShift.

endpoints: 
* Análise de DNA
POST - http://labdna-labdna.7e14.starter-us-west-2.openshiftapps.com/labdna/simian <br/>

JSON Requisição:
{
   “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

* Estatísticas de dnas mutantes encontrados
GET - http://labdna-labdna.7e14.starter-us-west-2.openshiftapps.com/labdna/stats

## Compilando o projeto localmente (Maven)
* Para executar o mvn clean install no projeto lembre-se de estar com o serviço do mongo ativo localmente na porta 27017
* Substituir a string de conexão no arquivo application.yml para "mongodb://127.0.0.1:27017/labdna"

## Maven Springboot Application + Spring Data MongoDB

* Para executar esta aplicação, faça o clone deste repositório, <br/>
* Tendo o Maven instalado em sua máquina, execute o comando "mvn clean install" na pasta raiz do projeto<br/>
* O pacote labdna-1.0.0-SNAPSHOT.jar  do projeto será criado na pasta target<br/>
* Tendo JRE (8 ou maior) instalada, execute o comando "java -jar labdna-1.0.0-SNAPSHOT.jar"<br/>
* Ou pelo comando maven "mvn spring-boot:run"<br/>

## Gravando as consultas de dnas na base do mongo db

* Instale o mongodb seguindo o tutorial abaixo <br/>
https://docs.mongodb.com/manual/administration/install-community/

* Altere a propriedade spring.data.mongodb.uri para mongo://hostDB:port/databaseName que vocẽ criar

* Uma collection no banco será criada e as análises de dna serão gravadas nesta collection para a consulta posterior no endpoint "/stats"

