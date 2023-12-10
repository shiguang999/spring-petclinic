package org.springframework.samples.petclinic.vet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public abstract class VetRepositoryImpl implements VetRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public VetRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void deleteById(Integer id) {
		String sql = "DELETE FROM vets WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Set<Vet> findAll() throws DataAccessException {
		Set<Vet> vets = new HashSet<>();
		List<Vet> vetList = jdbcTemplate.query("SELECT id, first_name, last_name FROM vets", new VetRowMapper());
		vets.addAll(vetList);
		return vets;
	}

	private static final class VetRowMapper implements RowMapper<Vet> {

		@Override
		public Vet mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vet vet = new Vet();
			vet.setId(rs.getInt("id"));
			vet.setFirstName(rs.getString("first_name"));
			vet.setLastName(rs.getString("last_name"));
			return vet;
		}
	}

}
