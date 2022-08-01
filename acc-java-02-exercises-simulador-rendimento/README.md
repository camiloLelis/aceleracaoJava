### Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

---

# Boas vindas ao repositório do desafio da Aceleração Java!

Você já usa o GitHub diariamente para desenvolver os exercícios, certo? Agora, para desenvolver o desafio, você deverá seguir as instruções a seguir. Fique atento a cada passo, e se tiver qualquer dúvida, nos envie por _Slack_! #vqv 🚀

Aqui você vai encontrar os detalhes de como estruturar o desenvolvimento do seu desafio a partir deste repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

---
# Instruções para entregar seu projeto

## Não se esqueça de consultar as documentações!

⚠️ **Importante**:

Esse projeto tem como intuito te treinar para ter mais familiaridade com a documentação de aplicações, por tanto, poderão haver alguns comandos ou atributos que não estão no curso, mas que devem ser descritos no decorrer dos requisitos.

Nesses casos, é importante se atentar a aquilo que o requisito pede, e lembrar sempre de utilizar a [documentação oficial](https://docs.oracle.com/en/java/javase/11/) do Java para pesquisar detalhes sobre comandos.


## Antes de começar a desenvolver

Lembre-se que você pode consultar nosso conteúdo sobre [Git & GitHub](https://course.betrybe.com/intro/git/) sempre que precisar!

1. Clone o repositório
  * Por exemplo: `git clone git@github.com:tryber/desafio-aceleracao.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd desafio-aceleracao`

2. Instale as dependências:
    * `mvn install`

3. Crie uma branch a partir da branch `main`

  * Verifique que você está na branch `main`
    * Exemplo: `git branch`
  * Se não estiver, mude para a branch `main`
    * Exemplo: `git checkout main`
  * Agora, crie uma branch onde você vai guardar os commits do seu desafio
    * Você deve criar uma branch no seguinte formato: `nome-de-usuario-nome-do-desafio`
    * Exemplo:
      * `git checkout -b joaozinho-acc-java-sample`

4. Adicione a sua branch com o novo `commit` ao repositório remoto

  - Usando o exemplo anterior:
    - `git push -u origin joaozinho-acc-java-sample`

5. Crie um novo `Pull Request` _(PR)_
  * Vá até a aba de _Pull Requests_ deste repositório no GitHub
  * Clique no botão verde _"New pull request"_
  * Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
  * Clique no botão verde _"Create pull request"_
  * Adicione uma descrição para o _Pull Request_ e clique no botão verde _"Create pull request"_
  * **Não se preocupe em preencher mais nada por enquanto!**
  * Volte até a página de _Pull Requests_ do repositório e confira que o seu _Pull Request_ está criado
 
 ⚠️ **Lembre-se do CheckStyle! Deixe seu Eclipse configurado para arrumar o estilo automaticamente. Qualquer dúvida, volte no conteúdo.**

---

## Durante o desenvolvimento

* ⚠ **PULL REQUESTS COM ISSUES NO CHECKSTYLE NÃO SERÃO AVALIADAS, ATENTE-SE PARA RESOLVÊ-LAS ANTES DE FINALIZAR O DESENVOLVIMENTO!** ⚠

* Faça `commits` das alterações que você fizer no código regularmente

* Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto

* Os comandos que você utilizará com mais frequência são:
  1. `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde - no stage)_
  2. `git add` _(para adicionar arquivos ao stage do Git)_
  3. `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_
  4. `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na primeira vez que fizer o `push` de uma nova branch)_
  5. `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_

---

## Depois de terminar o desenvolvimento (opcional)

Para **"entregar"** seu projeto, siga os passos a seguir:

* Vá até a página **DO SEU** _Pull Request_, adicione a label de _"code-review"_ e marque seus colegas
  * No menu à direita, clique no _link_ **"Labels"** e escolha a _label_ **code-review**
  * No menu à direita, clique no _link_ **"Assignees"** e escolha **o seu usuário**
  * No menu à direita, clique no _link_ **"Reviewers"** e digite `students`, selecione o time `tryber/students-sd-0x`

Se ainda houver alguma dúvida sobre como entregar seu projeto, [aqui tem um video explicativo](https://vimeo.com/362189205).

---

# Requisitos do desafio

## Simulador de Rendimento

Agora é a hora de você colocar em prática o que aprendeu sobre a classe `LocalDateTime`!
Aqui nesse desafio você deverá montar um simulador de rendimentos. A pessoa usuária deve entrar com um montante de dinheiro inicial e com o valor que objetiva ter no futuro, e, por fim, seu simulador deve dizer em que ano o objetivo terá sido atingido ou ultrapassado.

Você terá que escrever uma classe nomeada `SimuladorRendimento`, e nela deve haver um método chamado `simularRendimentoAnos`.
Esse método `simularRendimentoAnos` deve receber dois argumentos `double`: um representando o valor do montante inicial, outro representando o valor do objetivo. O retorno deve ser um número inteiro que representa o ano futuro em que o objetivo será alcançado ou ultrapassado. Os passos desse método são: 

1- o método `simularRendimentoAnos` recebe dois argumentos `double`, que representam o valor inicial e o valor do objetivo, respectivamente;
2- considerando que o rendimento anual é de 10%, o método deve calcular quantos anos serão necessários para o valor inicial alcançar o valor do objetivo;
3- o método deve usar a classe `LocalDateTime` para pegar o ano atual (ex: 2022), somar a quantidade de anos que foram calculados no passo anterior e retornar em que ano do nosso calendário o valor do objetivo será alcançado. (Dicas: utilize os métodos `.plusYears()` e `.getYear()` para fazer essa manipulação.)
4- retornar um inteiro que representa o ano em que o objetivo será alcançado ou ultrapassado (ex: 2047).


# Exemplo
Se eu chamar o método `simularRendimentoAnos` passando 500 como valor inicial, e 5000 como valor do objetivo, considerando que estou executando isso no ano 2022, o retorno do método deve ser 2047. Isso porque o rendimento é de 10%, então para o valor inicial 500 alcançar 5000, levará 25 anos.

Note: se meu valor inicial é 500, no primeiro ano, com o rendimento de 10%, o valor que terei será 550. Para o segundo ano, o rendimento é calculado em cima do valor 550, ou seja, um rendimento de 10% em cima de 550 gera 605. No terceiro ano, o rendimento é calculado em cima do valor 605, e assim sucessivamente. Em outras palavras, como é rendimento, é cumulativo.

500 -> inicial

550 -> primeiro ano

605 -> segundo ano

665.5 -> terceiro ano

732.05 -> quarto ano

...

4924.87 -> vigésimo quarto ano

5417.36 -> vigésimo quinto ano

Adicione esse método `main` na sua classe `SimuladorRendimento`:
```java
public static void main(String[] args) {
    SimuladorRendimento obj = new SimuladorRendimento();
    double inicial = 500;
    double objetivo = 5000;
    System.out.println("Com " + inicial + " seu rendimento será " + objetivo 
            + " no ano " + obj.simularRendimentoAnos(inicial, objetivo));
}
```
Após executar seu programa, a saída deverá ser:
```
Com 500.0 seu rendimento será 5000.0 no ano 2047
```


---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---
