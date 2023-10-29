package iftm.edu.tspi.crudoracao.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import iftm.edu.tspi.crudoracao.domain.Contato;


@Component
public class CrudDao {

    @Autowired
    JdbcTemplate db;

    public List<Contato> getContatos() {
        String sql = "select id, email, nome, sobrenome, celular from tb_contato";

        return db.query(sql, (res, rowNum) -> {
            return new Contato(
                    res.getInt("id"),
                    res.getString("nome"),
                    res.getString("sobrenome"),
                    res.getString("celular"),
                    res.getString("email"));
        });
    }

    public List<Contato> getContatos(String nome) {
        String sql = "select  id, nome, sobrenome, celular, email from tb_contato where lower(nome) like ?";

        return db.query(sql,
                new BeanPropertyRowMapper<>(Contato.class),
                new Object[] { "%" + nome + "%" });
    }

    public Contato getContato(Integer id) {
        String sql = "select  id, nome, sobrenome, celular, email from tb_contato where id = ?";

        List<Contato> contatos = db.query(sql,
                new BeanPropertyRowMapper<>(Contato.class),
                new Object[] { id });
        if (contatos != null && contatos.size() > 0) {
            return contatos.get(0);
        } else {
            return null;
        }
    }

    public void inserirContato(Contato contato) {
        String sql = "insert into tb_contato(nome, sobrenome, celular, email) values(?,?,?,?)";

        db.update(sql, new Object[] {contato.getNome(), contato.getSobrenome(), contato.getCelular(), contato.getEmail() });
    }

    public void updateContato(Contato contato) {
        String sql = "UPDATE tb_contato SET nome = ?, sobrenome = ?, celular = ?, email = ? WHERE id = ?";

        db.update(sql, new Object[] { contato.getNome(), contato.getSobrenome(), contato.getCelular(), contato.getEmail(), contato.getId()});
    }

    public void deleteContato(Integer id) {
        String sql = "delete from tb_contato where id = ?";

        db.update(sql, new Object[] { id });
    }
}
