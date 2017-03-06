#iFood Backend Java Test

Este é um projeto base para demonstração de um micro-serviço fictício.

Recomenda-se gastar entre 4 a 6 horas para realizar essas tarefas. As duas primeiras são as mais importantes, 
enquanto que as duas últimas são opcionais, para quem conseguir terminar antes do previsto.

Esse projeto foi iniciado a partir do [Spring Initializr][SpringInitializr]. É o boilerplate padrão do Spring 1.5.2 com 
[Spring Boot][SpringBoot] (torna o serviço "rodável", sem necessidade de deploy para um servidor).

Crie um *fork* deste repositório e siga as tarefas abaixo.

##Tarefas

### 1. Crie um endpoint para retornar informações sobre o serviço

Para testar rapidamente se nosso serviço está funcionando, crie na classe `About` um endpoint `GET /about` que retorna
uma mensagem confirmando que nosso serviço está funcionando e recebendo requisições.


### 2. Integração com OpenWeatherMap

Vamos usar o OpenWeatherMap para obter informações do clima de uma cidade.

Primeiro, faça um registro rápido no [OpenWeatherMaps][OpenWeather] para obter uma API Key.

Agora, crie um endpoint `GET /weather` no nosso micro-serviço que aceite o parâmetro `city` e retorne os detalhes do
tempo na cidade (sunny, cloudy, etc) e detalhes meteorológicos (temperatura, pressão, etc), utilizando requisições HTTP 
para o OpenWeatherMaps.

Use a biblioteca que você tiver mais familiaridade, e estruture a resposta da maneira que achar mais organizada.


### 3. Usando Feign para requisições

Apesar das bibliotecas HTTP sugeridas funcionarem bem, elas ainda deixar por conta do programador várias tarefas básicas, 
como codificar e decodificar a resposta da requisição em um objeto, tratar erros, fazer tratamento pré-requisição, etc.

A biblioteca [Feign][FeignRepo] automatiza vários desses processos.

Nessa etapa, adicione a dependência do Feign e troque as requisições HTTP para usá-lo.

### 4. Tolerância a falhas

Se o serviço do OpenWeatherMaps estiver indisponível, por qualquer motivo, não podemos deixar que nosso micro-serviço
sofra com isso também.

Para isso, podemos adicionar uma biblioteca de controle de falhas chamada Hystrix.

Nessa etapa, adiciona e configure o [Hystrix][HystrixRepo] para tornar nosso micro-serviço mais robusto.


[OpenWeather]: https://openweathermap.org/appid
[FeignRepo]: https://github.com/OpenFeign/feign
[HystrixRepo]: https://github.com/Netflix/Hystrix
[SpringInitializr]: https://start.spring.io/
[SpringBoot]: https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started