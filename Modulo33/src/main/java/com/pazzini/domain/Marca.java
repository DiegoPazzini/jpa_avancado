// Declaração do pacote ao qual a classe pertence
package com.pazzini.domain;

// Importações de classes relacionadas à persistência e coleções
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// Declaração da classe de domínio Marca, mapeada como uma entidade JPA
@Entity
@Table(name = "TB_MARCA") // Especificação da tabela no banco de dados
public class Marca {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="marca_seq") // Configuração da geração automática de chaves primárias
	@SequenceGenerator(name="marca_seq", sequenceName="sq_marca", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 30, nullable = false, unique = true) // Configuração da coluna "CODIGO" no banco de dados
	private String codigo;
	
	@Column(name = "MODELO", length = 100, nullable = false) // Configuração da coluna "MODELO"
	private String modelo;
	
	@OneToMany(mappedBy = "marca") // Mapeamento da relação um para muitos com a entidade Carro
	private List<Carro> carros;

	// Métodos getters e setters para os campos da entidade

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
}
