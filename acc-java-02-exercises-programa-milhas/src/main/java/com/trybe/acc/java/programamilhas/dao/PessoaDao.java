package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.dominio.TipoLancamentoEnum;
import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.util.HashUtil;
import com.trybe.acc.java.programamilhas.util.TokenUtil;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@ApplicationScoped
public class PessoaDao {

  @Inject
  EntityManager entityManager;

  @Inject
  private TokenUtil token;

  @Inject
  private HashUtil hash;

  /**
   * Método responsável pela realização do login.
   * 
   * <p>
   * Não delete este método!
   * </p>
   */
  public Pessoa autenticar(String login, String hash) {
    String hql = "from " + Pessoa.class.getSimpleName() + " where login = :login and hash = :hash";
    Query query = entityManager.createQuery(hql);
    query.setParameter("login", login);
    query.setParameter("hash", hash);
    return (Pessoa) query.getSingleResult();
  }

  /**
   * inserir.
   */
  @Transactional
  public void insert(LoginDto loginPessoa) 
      throws InvalidKeySpecException, NoSuchAlgorithmException {
    
    Pessoa pessoa = new Pessoa();
    pessoa.setLogin(loginPessoa.getLogin());
    pessoa.setHash(hash.hash(loginPessoa.getSenha()));
    
    EntityManager em = entityManager.getEntityManagerFactory().createEntityManager();

    em.getTransaction().begin();
    entityManager.persist(pessoa);
    em.getTransaction().commit();
    em.close();
  }

  /**
  * deletar.
  */
  @Transactional
  public void remover(String login) throws AcessoNaoAutorizadoException {
    EntityManager entity = entityManager.getEntityManagerFactory().createEntityManager();
    Integer id = token.obterIdUsuario(login);
    Pessoa pessoa = entity.find(Pessoa.class, id);
    entity.getTransaction().begin();
    entity.remove(pessoa);
    entity.getTransaction().commit();
    entity.close();
  }

  /**
   * pegar o saldo.
   */
  public List<SaldoResult> getSaldo() {
    String hql = "from " + Lancamento.class.getSimpleName();
    Query query = entityManager.createQuery(hql);
    @SuppressWarnings("unchecked")
    List<Lancamento> lancamentos = query.getResultList();

    String hql2 = "SELECT id from " + Pessoa.class.getSimpleName();
    Query queryId = entityManager.createQuery(hql2);
    @SuppressWarnings("unchecked")
    List<SaldoResult> saldos = queryId.getResultList();
    Set<Integer> idlist = new HashSet<>();

    for (Integer idUsuario : idlist) {
      TipoLancamentoEnum tipo1 = TipoLancamentoEnum.BONUS;
      TipoLancamentoEnum tipo3 = TipoLancamentoEnum.ACUMULO;

      SaldoResult saldoResult = new SaldoResult(0);

      for (Lancamento lancamento : lancamentos) {
        if (lancamento.getUsuario().getId() == idUsuario) {
          if (lancamento.getTipoLancamento().getId() == tipo1.getId()
              || lancamento.getTipoLancamento().getId() == tipo3.getId()) {
            saldoResult.setSaldo(saldoResult.getSaldo() + lancamento.getValor());
          } else {
            saldoResult.setSaldo(saldoResult.getSaldo() - lancamento.getValor());
          }
        }
      }
      saldos.add(saldoResult);
    }

    return saldos;
  }
}
