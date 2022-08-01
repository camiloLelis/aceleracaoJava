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

### Desafio Agregador: Sistema Validador de Conta Bancária 💲

Olá! Hoje nosso desafio agregador vai nos colocar em um cenário onde supostamente estaremos dentro de um time de desenvolvimento de uma instituição financeira, e você, enquanto pessoa desenvolvedora, será responsável por implementar um pequeno sistema de apoio à validação de contas bancárias.

Nosso arquiteto de software montou uma especificação técnica que foi designada como uma demanda para você. Abaixo estão os detalhes:

>  ESPECIFICAÇÃO TÉCNICA
> ------------
> **Projeto**: Validador de Conta Bancária
>
> **Objetivo**: Verificamos que, ao utilizar a função de transferência eletrônica, outras instituições financeiras não estabelecem o mesmo formato no envio dos números das contas. Sendo assim, o desenvolvimento deste sistema tem como objetivo garantir que o formato das contas informadas pela pessoa usuária esteja de acordo com as diretrizes da nossa instituição (contas com 6 dígitos).
>
> **Requisitos**:
>
> - Definir o projeto como `gradle` para manter a gestão de dependências automatizada, escalável e distribuída;
> - Utilizar a biblioteca `Apache Commons Lang` na versão `3.11` para garantir a aderência entre todos os outros projetos da empresa;
> - A pessoa usuária deverá informar o número da conta bancária (apenas números) no console do sistema, cabendo ao sistema validar se o valor informado é maior, menor ou igual a 6 dígitos — o que levará a uma das ações abaixo:
    >   - `conta < 6 dígitos`: deverá adicionar zeros àa esquerda até atender ao tamanho de 6 números;
>   - `conta > 6 dígitos`: deverão ser removidos todos os números antes dos 6 últimos;
>   - `conta = 6 dígitos`: já está aderente, o valor deve permanecer inalterado.
> - Valores não númericos não serão aceitos;
> - Empacotar a aplicação no formato `jar` para o deploy.

#### Overview da Demanda 📄

- **Etapa 1 ☕**: A empresa apenas trabalha com o `gradle` como gerenciadores de dependências para o projeto;
- **Etapa 2 ☕**: Se você já instalou e configurou o gradle no seu ambiente de trabalho, já poderá começar realizar o download dos pacotes do [gradle](https://gradle.org/releases/ "Ir para o site") diretamente do site oficial e prosseguir com a criação;

  > Dica 💡: Sugere-se utilizar as versões `gradle 6.9.2`.

- **Etapa 3 ☕**: Tome como referência os seguintes parâmetros para a aplicação:

  > #### GRADLE
  >
  > **Type**: java-application, **Language**: java, **Multiple subprojects**: no, **DSL language**: Groovy, **Project name**: bank-account, **Source package**: com.betrybe.acc.java.bankaccount

- **Etapa 4 ☕**: Antes de começar a implementar a solução, lembre-se de alterar com consciência o seu arquivo `build.gradle`:
  - Adicione a dependência do `Apache Commons Lang versão 3.11` no bloco de dependências do projeto;
  - Atualize as depedências do projeto para que ele baixe as bibliotecas necessárias, que serão usadas durante as próximas etapas.

- **Etapa 5 ☕**: Para o projeto, não vamos precisar de muitos arquivos. Primeiro será necessária uma classe com o método `main` para inicializar nossa aplicação e uma segunda classe que podemos nomear de `AccountaNumberFormatter.java` com um método chamado `formatAccountNumber` para formatar o número da conta bancária;

  ```java
  public class Application {
      
      public static void main(String[] args) {
          // Utilize conhecimentos prévios para ler o input da pessoa usuária, capturar o número da conta, criar uma instância da classe AccountNumberFormatter e obter o retorno do número da conta formatado.
      }
      
  }
  ```
  
  ```java
  public class AccountNumberFormatter {
      
      public String formatAccountNumber(int literalAccountNumber) {
          return "fomattedNumber";
      }
      
  }
  ```

- **Etapa 6 ☕**: Se estiver com dúvidas na hora de implementar uma maneira de formatar o número da conta bancária dentro do método `formatAccountNumber`, não se esqueça de que a biblioteca `Apache Commons Lang` está aqui para facilitar o nosso trabalho. Você pode utilizar dois métodos úteis:

  ```java
  /*
  O método right remove todos os caracteres à esquerda e mantém todos os que estiverem à direita. O value corresponde à string que será processada, e o length corresponde à quantidade de caracteres que devem permanecer intactos na direita.
  */
  StringUtils.right(String value, int length);
  
  /*
  O método leftPad adiciona um preenchimento de caracteres à esquerda de uma String. O value corresponde à string que será processada, o length corresponde ao tamanho da string e o prefix corresponde ao caractere que deverá preencher os espaços faltantes.
  */
  StringUtils.leftPad(String value, int length, Char prefix);
  ```

- **Etapa 7 ☕**: A última etapa será empacotar a aplicação em um arquivo `.jar` executável. Utilize o seu gerenciador de dependências para completar essa tarefa. No caso do `gradle`, se todos os passos estiverem alinhados com as etapas desse *overview*, deverá ser gerado um arquivo `.jar` no diretório `/build/libs/`

> **Dica** 💡: Para executar o arquivo .jar gerado no final do processo, utilize o comando `java -jar local-está-seu-arquivo-jar`.

# Exemplos 👓

Se a pessoa usuária informar a conta `448` no input do console, deverá obter como resultado um feedback ok:

    Informe o número da conta:
    448
    Número da conta: 000448

No entanto, se a pessoa usuária informar a conta `1234567890` no input do console, deverá obter como resultado a mensagem de aviso:

    Informe o número da conta:
    1234567890
    Número da conta: 567890

Caso seja informado um valor não numérico (por exemplo `12345-X`), uma mensagem validando deverá aparecer:

    Informe o número da conta: 
    12345-X
    Número da conta inválido!

Boa sorte e foco na entrega de qualidade! 😉


---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---
